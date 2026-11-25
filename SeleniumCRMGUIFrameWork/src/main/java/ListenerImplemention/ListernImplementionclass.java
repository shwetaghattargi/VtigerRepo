
package ListenerImplemention;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClassUtility.BaseClass;

public class ListernImplementionclass
        implements ITestListener, ISuiteListener {

    public static ThreadLocal<ExtentTest> test =
            new ThreadLocal<ExtentTest>();

    // Initialize Extent Report
    @Override
    public void onStart(ISuite suite) {


        String timeStamp = new java.text.SimpleDateFormat(
                "dd_MM_yyyy_hh_mm_ss_a")
                .format(new java.util.Date());

        String reportName = "CRMReport_" + timeStamp + ".html";

        ExtentSparkReporter spark =
                new ExtentSparkReporter("./Reports/" + reportName);

        spark.config().setDocumentTitle("CRM Test Suite Results");
        spark.config().setReportName("CRM Report");
        spark.config().setTheme(Theme.DARK);

        BaseClass.report = new ExtentReports();

        BaseClass.report.attachReporter(spark);

        BaseClass.report.setSystemInfo("OS", "Windows 11");
        BaseClass.report.setSystemInfo("Browser", "Chrome");

        System.out.println("Extent Report Initialized: " + reportName);
    }

    // Test Started
    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getTestClass()
                .getRealClass().getSimpleName()
                + "_"
                + result.getMethod().getMethodName();

        ExtentTest extentTest =
                BaseClass.report.createTest(testName);

        test.set(extentTest);

        System.out.println("Test Started: " + testName);
    }

    // Test Passed
    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTest extentTest = test.get();

        if (extentTest != null) {

            extentTest.log(Status.PASS,
                    "Test passed successfully");
        }

        System.out.println("Test Passed: "
                + result.getMethod().getMethodName());

        test.remove();
    }

    // Test Failed
    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest extentTest = test.get();

        if (extentTest == null) {
            return;
        }

        extentTest.log(Status.FAIL, result.getThrowable());

        try {

            BaseClass base =
                    (BaseClass) result.getInstance();

            if (base.driver != null) {

                TakesScreenshot ts =
                        (TakesScreenshot) base.driver;

                String screenshot =
                        ts.getScreenshotAs(OutputType.BASE64);

                extentTest.addScreenCaptureFromBase64String(
                        screenshot,
                        "Failure Screenshot");
            }

        } catch (Exception e) {

            extentTest.log(Status.WARNING,
                    "Screenshot error: " + e.getMessage());
        }

        System.out.println("Test Failed: "
                + result.getMethod().getMethodName());

        test.remove();
    }

    // Test Skipped
    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTest extentTest = test.get();

        if (extentTest != null) {

            extentTest.log(Status.SKIP,
                    "Test skipped");
        }

        System.out.println("Test Skipped: "
                + result.getMethod().getMethodName());

        test.remove();
    }

    // Flush Report
    @Override
    public void onFinish(ISuite suite) {

        if (BaseClass.report != null) {

            BaseClass.report.flush();
        }

        System.out.println("Extent Report Generated Successfully");
    }
}
