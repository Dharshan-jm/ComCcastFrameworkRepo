package com.castcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	WebDriver driver;
	
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createcontactlink;
	
	@FindBy(name = "lastname")
	private WebElement lastname;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement contactsavebutton;

	public WebElement getCreatecontactlink() {
		return createcontactlink;
	}
	
	public WebElement contactsavebutton() {
		return contactsavebutton;
	}
	
	public WebElement lastnameelement() {
		return lastname;
	}
	
	//action method
	public void createcontactlinkicon() {
		getCreatecontactlink().click();
	}
	
	public void lastname(String name) {
		lastnameelement().sendKeys(name);
	}
	
	public void contactsavebuttonicon() {
		contactsavebutton().click();
	}
}
