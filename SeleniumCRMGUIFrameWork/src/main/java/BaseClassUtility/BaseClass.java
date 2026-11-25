
package BaseClassUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.objectRepository.LoginPage;

public class BaseClass {

    public WebDriver driver;
    public FileUtility fu;

    public String url;
    public String username;
    public String password;
    public static ExtentReports report;

    @BeforeClass
    public void launchBrowser() throws IOException {

        fu = new FileUtility();

        String browser = fu.getDatafromPropertiesFile("browser");
        url = fu.getDatafromPropertiesFile("url");
        username = fu.getDatafromPropertiesFile("username");
        password = fu.getDatafromPropertiesFile("password");

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }
        else {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(20));

        driver.get(url);
    }

    @BeforeMethod
    public void login() {

        LoginPage lp = new LoginPage(driver);

        lp.loginToApp(username, password);
    }

    @AfterMethod
    public void logout() {
        LoginPage lp = new LoginPage(driver);

    	lp.mouseOverUserImage();
        lp.clickSignOut();
    }

    @AfterClass
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }
    }
}
