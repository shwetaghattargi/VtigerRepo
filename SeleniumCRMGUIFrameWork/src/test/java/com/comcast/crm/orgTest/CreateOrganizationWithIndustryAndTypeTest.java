
package com.comcast.crm.orgTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import ListenerImplemention.ListernImplementionclass;

import com.comcast.crm.generic.objectRepository.OrganizationPage;
import com.comcast.crm.generic.WebdriverUtility.JavaUlility;
import com.comcast.crm.generic.fileutility.ExcelUlility;

@Listeners(ListernImplementionclass.class)

public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass {

	@Test
	public void verifyOrganizationWithIndustryAndType() throws IOException {

		JavaUlility jvu = new JavaUlility();
		ExcelUlility eu = new ExcelUlility();

		String orgName = eu.getDataFromExcelFile("org", 4, 2) + jvu.getRandomNumber();

		String industry = eu.getDataFromExcelFile("org", 4, 3);

		String type = eu.getDataFromExcelFile("org", 4, 4);

		OrganizationPage op = new OrganizationPage(driver);

		op.clickOrganization();

		op.clickCreateOrganization();

		op.enterOrganizationName(orgName);

		op.selectIndustry(industry);

		op.selectType(type);

		op.clickSave();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			String alertMessage = alert.getText();

			alert.accept();

			Assert.fail("Organization creation failed: " + alertMessage);

		} catch (TimeoutException e) {

		}

		// Verify Industry
		String actualIndustry = op.getIndustry();

		Assert.assertEquals(actualIndustry, industry, "Industry verification failed");
		Reporter.log("Industry Verification: PASS", true);

		String actualType = op.getType();

		Assert.assertEquals(actualType, type, "Organization Type verification failed");

		Reporter.log("Phone Number Verification: PASS", true);
	}
}
