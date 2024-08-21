package com.castcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
	WebDriver driver;
	
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "accountname")
	private WebElement Accountname;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveButton;
	
	@FindBy(name = "industry")
	private WebElement Industry;
	
	@FindBy(name = "accounttype")
	private WebElement Accounttype;
	

	public WebElement getAccountname() {
		return Accountname;
	}
	
	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public WebElement getIndustry() {
		return Industry;
	}
	
	public WebElement getAccountType() {
		return Accounttype;
	}
	
	//business method for orgname
	
	public void createOrgName(String orgname) {
		getAccountname().sendKeys(orgname);
	}
	
	public void createIndustry(String industryname) {
		WebElement dropdown = getIndustry();
		Select sel=new Select(dropdown);
		sel.selectByVisibleText(industryname);
	}
	
	public void createAccounttype(String Accounttype) {
		WebElement dropdown = getAccountType();
		Select sel=new Select(dropdown);
		sel.selectByVisibleText(Accounttype);
	}

}
