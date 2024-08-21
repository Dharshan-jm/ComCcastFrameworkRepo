package com.castcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
    
	WebDriver driver;
	
	public OrganizationInfoPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement DvHeaderText;

	public WebElement getDvHeaderText() {
		return DvHeaderText;
	}
	
	

	
	
	
	
	
	
}