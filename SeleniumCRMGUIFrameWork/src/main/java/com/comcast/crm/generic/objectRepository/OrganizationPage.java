
package com.comcast.crm.generic.objectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrganizationPage {

    WebDriver driver;

    WebDriverWait wait;

    public OrganizationPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Organization Link
    @FindBy(linkText = "Organizations")
    private WebElement organizationLink;

    // Create Organization Button
    @FindBy(xpath = "//img[@title='Create Organization...']")
    private WebElement createOrganizationBtn;

    // Organization Name
    @FindBy(name = "accountname")
    private WebElement organizationNameEdt;

    // Industry Dropdown
    @FindBy(name = "industry")
    private WebElement industryDropdown;

    // Type Dropdown
    @FindBy(name = "accounttype")
    private WebElement typeDropdown;

    // Save Button
    @FindBy(name = "button")
    private WebElement saveBtn;

    // Header Text
    @FindBy(className = "dvHeaderText")
    private WebElement headerText;

    // Organization Details
    @FindBy(id = "dtlview_Organization Name")
    private WebElement organizationDetails;

    // Industry Details
    @FindBy(id = "mouseArea_Industry")
    private WebElement industryText;

    // Type Details
    @FindBy(id = "mouseArea_Type")
    private WebElement typeText;

    // Phone Number Text Field
    @FindBy(id = "phone")
    private WebElement phoneNumberEdt;

    // Phone Number Details
    @FindBy(id = "dtlview_Phone")
    private WebElement phoneNumberText;


    // Click Organizations
    public void clickOrganization() {

        wait.until(ExpectedConditions.elementToBeClickable(organizationLink));

        organizationLink.click();
    }

    // Click Create Organization
    public void clickCreateOrganization() {

        wait.until(ExpectedConditions.elementToBeClickable(createOrganizationBtn));

        createOrganizationBtn.click();
    }

    // Enter Organization Name
    public void enterOrganizationName(String orgName) {

        wait.until(ExpectedConditions.visibilityOf(organizationNameEdt));

        organizationNameEdt.sendKeys(orgName);
    }

    // Select Industry
    public void selectIndustry(String industry) {

        wait.until(ExpectedConditions.visibilityOf(industryDropdown));

        Select sel = new Select(industryDropdown);

        sel.selectByVisibleText(industry);
    }

    // Select Type
    public void selectType(String type) {

        wait.until(ExpectedConditions.visibilityOf(typeDropdown));

        Select sel = new Select(typeDropdown);

        sel.selectByContainsVisibleText(type);
    }

    // Click Save
    public void clickSave() {

        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));

        saveBtn.click();
    }

    // Get Header Text
    public String getHeaderText() {

        wait.until(ExpectedConditions.visibilityOf(headerText));

        return headerText.getText();
    }

    // Get Organization Name
    public String getOrganizationDetails() {

        wait.until(ExpectedConditions.visibilityOf(organizationDetails));

        return organizationDetails.getText();
    }

    // Get Industry
    public String getIndustry() {

        wait.until(ExpectedConditions.visibilityOf(industryText));

        return industryText.getText();
    }

    // Get Type
    public String getType() {

        wait.until(ExpectedConditions.visibilityOf(typeText));

        return typeText.getText();
    }

    // Enter Phone Number
    public void enterPhoneNumber(String number) {

        wait.until(ExpectedConditions.visibilityOf(phoneNumberEdt));

        phoneNumberEdt.sendKeys(number);
    }

    // Get Phone Number
    public String getPhoneNumber() {

        wait.until(ExpectedConditions.visibilityOf(phoneNumberText));

        return phoneNumberText.getText();
    }
}
