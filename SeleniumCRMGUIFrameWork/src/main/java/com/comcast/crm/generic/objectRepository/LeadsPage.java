package com.comcast.crm.generic.objectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadsPage {
	WebDriver driver;

    WebDriverWait wait;

    public LeadsPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @FindBy(xpath="//img[@title='Create Lead...']")
    private WebElement createlead;

	public WebElement getCreatelead() {
		return createlead;
	}
	public void clickoncreatelead()
	{
		createlead.click();
	}
	
	//firstname textfield 
	@FindBy( name="firstname")
	private WebElement firstnametext;

	public WebElement getFirstnametext() {
		return firstnametext;
	}
	
			

}
