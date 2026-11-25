
package com.comcast.crm.ContanctTest;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import ListenerImplemention.ListernImplementionclass;

import com.comcast.crm.generic.objectRepository.ContactPage;
import com.comcast.crm.generic.fileutility.ExcelUlility;

@Listeners(ListernImplementionclass.class)

public class CreateContactWithSupportDatesTest extends BaseClass {

	@Test
	public void verifyContactWithSupportDates() throws IOException {

		ExcelUlility eu = new ExcelUlility();

		String lastName = eu.getDataFromExcelFile("constact", 1, 3) + System.currentTimeMillis();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate start = LocalDate.now();
		LocalDate end = start.plusDays(30);

		String startDate = start.format(formatter);
		String endDate = end.format(formatter);

		ContactPage cp = new ContactPage(driver);

		cp.clickContacts();

		cp.clickCreateContact();

		cp.enterLastName(lastName);

		cp.enterSupportStartDate(startDate);

		cp.enterSupportEndDate(endDate);

		cp.clickSave();

		try {
			Alert alert = driver.switchTo().alert();

			String alertMessage = alert.getText();

			alert.accept();

			Assert.fail("Contact creation failed: " + alertMessage);

		} catch (NoAlertPresentException e) {
		}

		String actualStartDate = cp.getSupportStartDate();

		Assert.assertEquals(actualStartDate, startDate, "Support Start Date verification failed");

		String actualEndDate = cp.getSupportEndDate();

		Assert.assertEquals(actualEndDate, endDate, "Support End Date verification failed");

		Reporter.log("Contact Header Verification: PASS", true);
	}
}
