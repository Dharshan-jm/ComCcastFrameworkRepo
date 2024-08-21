package com.castcast.crm.generic.webdrivereutlity;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	// implicite wait
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	// explicite wait for webelement to load
	public void waitForElementPresent(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// switch to window either parent or child
	public void switchToWindowBasedOnUrl(WebDriver driver, String partialtext) {

		Set<String> windowid = driver.getWindowHandles();

		Iterator<String> id = windowid.iterator();

		while (id.hasNext()) {

			String var = id.next();
			driver.switchTo().window(var);

			String currenturl = driver.getCurrentUrl();
			if (currenturl.contains(partialtext)) {
				break;
			}
		}
	}

	// switch to window either parent or child
	public void switchToWindowBasedOnTitle(WebDriver driver, String partialtitle) {

		Set<String> windowid = driver.getWindowHandles();

		Iterator<String> id = windowid.iterator();

		while (id.hasNext()) {

			String var = id.next();
			driver.switchTo().window(var);

			String currenturl = driver.getTitle();
			if (currenturl.contains(partialtitle)) {
				break;
			}
		}
	}

	// switch to frame : index
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	// switch to frame : name
	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}

	// switch to frame : webelement
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	// alert pop up
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// drop down
	// select by text
	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	// select by index
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	//move to element mouse related action class
	
	public void moveToElement(WebDriver driver,WebElement element) {
		
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}

}














