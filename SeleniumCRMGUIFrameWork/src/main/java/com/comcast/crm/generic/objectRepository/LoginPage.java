package com.comcast.crm.generic.objectRepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "user_name")
    private WebElement usernameEdt;

    @FindBy(name = "user_password")
    private WebElement passwordEdt;

    @FindBy(id = "submitButton")
    private WebElement loginBtn;

    public void loginToApp(String username, String password) {

        usernameEdt.sendKeys(username);
        passwordEdt.sendKeys(password);
        loginBtn.click();
    }
    
    @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
    private WebElement userImage;

    @FindBy(linkText = "Sign Out")
    private WebElement signOutLink;
    public void mouseOverUserImage() {
        Actions act = new Actions(driver);
        act.moveToElement(userImage).perform();
    }

    public void clickSignOut() {
        signOutLink.click();
    }
    
   }