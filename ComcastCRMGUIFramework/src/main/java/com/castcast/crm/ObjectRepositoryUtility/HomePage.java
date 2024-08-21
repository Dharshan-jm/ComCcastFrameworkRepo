package com.castcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement OrganizationLink;

	@FindBy(linkText = "Contacts")
	private WebElement ContactLink;

	@FindBy(xpath = "//a[text()='More']")
	private WebElement MoreLink;

	@FindBy(name = "Campaigns")
	private WebElement CampaignsLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logouticon;

	@FindBy(linkText = "Sign Out")
	private WebElement Sign_Out;

	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}

	public WebElement getlogouticon() {
		return logouticon;
	}

	public WebElement getSign_Out() {
		return Sign_Out;
	}

	// business action

	public void clickOrganizationLink() {
		getOrganizationLink().click();
	}

	public void clickContactLink() {
		getContactLink().click();
	}

	public void clickCampaignsLink() {
		// getMoreLink().click(); or

		Actions act = new Actions(driver);
		act.moveToElement(MoreLink).perform();
		getCampaignsLink().click();
	}

	public void clicksignout() {
		Actions act = new Actions(driver);
		act.moveToElement(logouticon).perform();
		getSign_Out().click();

	}
}
