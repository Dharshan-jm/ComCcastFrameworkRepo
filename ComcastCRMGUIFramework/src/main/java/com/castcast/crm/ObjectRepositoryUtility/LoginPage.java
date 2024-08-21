package com.castcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.castcast.crm.generic.webdrivereutlity.WebDriverUtility;

public class LoginPage extends WebDriverUtility{
	
	WebDriver driver;
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver,this);
	}

	// rule-1 create a seperate java class
	// Rule-2 find element by @findby

	@FindBy(name = "user_name")
	private WebElement Username;

	@FindBy(name = "user_password")
	private WebElement Password;

	@FindBy(id = "submitButton")
	private WebElement LoginButton;

	// Rule-3 Object initialization should be always done in test script

	// Rule-4 Object encapsulation, create getter methods for all the private
	// variables

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//business library(it is created and used only for specific application)
	//Rule-5 we can provid action 
	public void loginInToApp(String username,String password) {
		
		//for webdriverutility
		waitForPageToLoad(driver);
		
		driver.manage().window().maximize();
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();
	}

}









