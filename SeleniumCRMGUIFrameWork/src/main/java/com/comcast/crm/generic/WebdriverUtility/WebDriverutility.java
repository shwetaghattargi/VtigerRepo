package com.comcast.crm.generic.WebdriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverutility {
	public void waitForPageToLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
		
		public void maximizePage(WebDriver driver) {
			driver.manage().window().maximize();
		}
		public void waitforElementPresent(WebDriver driver, WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		}

		public void switchToTabOnUrl(WebDriver driver, String partialUrl) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String windowID = it.next();
				driver.switchTo().window(windowID);
				
				String actUrl = driver.getCurrentUrl();
				if(actUrl.contains(partialUrl)) {
					break;
				}
			}
		}

		public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String windowID = it.next();
				driver.switchTo().window(windowID);
				
				String actTitle = driver.getCurrentUrl();
				if(actTitle.contains(partialTitle)) {
					break;
				}
			}
		}
		public void switchToAlertAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}

		public void switchToAlertAndCancel(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		public void switchToframe(WebDriver driver,int index) {
			driver.switchTo().frame(index);
		}
		public void switchToframe(WebDriver driver,String nameID) {
			driver.switchTo().frame(nameID);
		}
		public void switchToframe(WebDriver driver,WebElement element) {
			driver.switchTo().frame(element);
		}
		public void select(WebElement element, int index) {
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}

		public void select(WebElement element, String text) {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}

		public void mouseMoveToElement(WebDriver driver,WebElement element ) {
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		public void mouseDoubleClick(WebDriver driver,WebElement element ) {
			Actions act = new Actions(driver);
			act.doubleClick(element).perform();
		


		
	}

}





