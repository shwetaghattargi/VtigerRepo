
package com.comcast.crm.orgTest;

import java.io.IOException;

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

public class CreateOrganizationWithPhoneNumberTest extends BaseClass {

	@Test
	public void verifyOrganizationWithPhoneNumber() throws IOException {

		JavaUlility jvu = new JavaUlility();
		ExcelUlility eu = new ExcelUlility();

		String orgName = eu.getDataFromExcelFile("org", 7, 2) + jvu.getRandomNumber();

		String phoneNumber = eu.getDataFromExcelFile("org", 7, 3);

		OrganizationPage op = new OrganizationPage(driver);

		op.clickOrganization();

		op.clickCreateOrganization();

		op.enterOrganizationName(orgName);

		op.enterPhoneNumber(phoneNumber);

		op.clickSave();

		String actualNumber = op.getPhoneNumber();

		Assert.assertEquals(actualNumber, phoneNumber, "Phone number verification failed");

		Reporter.log("Phone Number Verification: PASS", true);
	}
}
