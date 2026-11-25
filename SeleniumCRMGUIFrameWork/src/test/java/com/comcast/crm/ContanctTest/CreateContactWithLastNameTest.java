
package com.comcast.crm.ContanctTest;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import ListenerImplemention.ListernImplementionclass;

import com.comcast.crm.generic.objectRepository.ContactPage;

import com.comcast.crm.generic.WebdriverUtility.JavaUlility;
import com.comcast.crm.generic.fileutility.ExcelUlility;

@Listeners(ListernImplementionclass.class)

public class CreateContactWithLastNameTest extends BaseClass {

	@Test
	public void verifyContactWithLastName() throws IOException {

		ExcelUlility eu = new ExcelUlility();

		String lastName = eu.getDataFromExcelFile("constact", 1, 3);

		ContactPage cp = new ContactPage(driver);

		cp.clickContacts();

		cp.clickCreateContact();

		cp.enterLastName(lastName);

		cp.clickSave();

		String actualHeader = cp.getHeaderText();

		Assert.assertTrue(actualHeader.contains(lastName), "Contact creation failed - Last Name not found in header");

		Reporter.log("Contact Header Verification: PASS", true);
	}
}
