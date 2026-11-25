
package com.comcast.crm.generic.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Contacts")
    private WebElement contactsLink;

    @FindBy(xpath = "//img[@alt='Create Contact...']")
    private WebElement createContactBtn;

    @FindBy(name = "lastname")
    private WebElement lastNameEdt;

    @FindBy(name = "button")
    private WebElement saveBtn;

    @FindBy(className = "dvHeaderText")
    private WebElement headerText;
    @FindBy(name = "support_start_date")
    private WebElement supportStartDateEdt;

    @FindBy(name = "support_end_date")
    private WebElement supportEndDateEdt;

    @FindBy(id = "dtlview_Support Start Date")
    private WebElement supportStartDateText;

    @FindBy(id = "dtlview_Support End Date")
    private WebElement supportEndDateText;

    public void clickContacts() {
        contactsLink.click();
    }

    public void clickCreateContact() {
        createContactBtn.click();
    }

    public void enterLastName(String lastName) {
        lastNameEdt.sendKeys(lastName);
    }

    public void clickSave() {
        saveBtn.click();
    }
    public void enterSupportStartDate(String startDate) {
        supportStartDateEdt.clear();
        supportStartDateEdt.sendKeys(startDate);
    }

    public void enterSupportEndDate(String endDate) {
        supportEndDateEdt.clear();
        supportEndDateEdt.sendKeys(endDate);
    }

    public String getSupportStartDate() {
        return supportStartDateText.getText();
    }

    public String getSupportEndDate() {
        return supportEndDateText.getText();
    }

    public String getHeaderText() {
        return headerText.getText();
    }
}