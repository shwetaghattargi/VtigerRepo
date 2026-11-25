package com.comcast.crm.generic.objectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	@FindBy(xpath="//a[.='Leads']")
	private WebElement leadbutton;

	public WebElement getLeadbutton() {
		return leadbutton;
	}
	
	public void clickonlead()
	{
		leadbutton.click();
	}
	WebDriver driver;

    WebDriverWait wait;

    public HomePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	

}
