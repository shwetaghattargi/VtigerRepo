
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

public class CreateOrganizationTest extends BaseClass {

    @Test
    public void verifyCreateOrganization() throws IOException {

        JavaUlility jvu = new JavaUlility();
        ExcelUlility eu = new ExcelUlility();

        String orgName = eu.getDataFromExcelFile("org", 1, 2)
                + jvu.getRandomNumber();

        OrganizationPage op = new OrganizationPage(driver);

        op.clickOrganization();

        op.clickCreateOrganization();

        op.enterOrganizationName(orgName);

        op.clickSave();

        String actualHeader = op.getHeaderText();

        Assert.assertTrue(
                actualHeader.contains(orgName),
                "Organization header verification failed");

        Reporter.log("Organization Header Verification: PASS", true);
        String actualOrgName = op.getOrganizationDetails();

        Assert.assertEquals(
                actualOrgName,
                orgName,
                "Organization details verification failed");

    }
}
