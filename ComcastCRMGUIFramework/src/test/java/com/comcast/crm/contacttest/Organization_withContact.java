package com.comcast.crm.contacttest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.castcast.crm.ObjectRepositoryUtility.CreatingNewOrganizationPage;
import com.castcast.crm.ObjectRepositoryUtility.HomePage;
import com.castcast.crm.ObjectRepositoryUtility.LoginPage;
import com.castcast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.castcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.castcast.crm.generic.fileutlity.ExcelUtility;
import com.castcast.crm.generic.fileutlity.FileUtility;
import com.castcast.crm.generic.webdrivereutlity.JavaUtility;
import com.castcast.crm.generic.webdrivereutlity.WebDriverUtility;

public class Organization_withContact {

	public static void main(String[] args) throws IOException, InterruptedException {

		// create object for fileutility class

		FileUtility futil = new FileUtility();

		String url = futil.getDataFromPropertiesFile("Url");
		String un = futil.getDataFromPropertiesFile("username");
		String pwd = futil.getDataFromPropertiesFile("password");

		// create object for java utility
		JavaUtility jutil = new JavaUtility();

		// create object for excel utility

		ExcelUtility eutil = new ExcelUtility();
		String orgname = eutil.getDataFromExcel("org", 1, 2) + jutil.getRandomNumber();
		String lastname = eutil.getDataFromExcel("org", 4, 2);

		// webdriveutility object creation

		WebDriverUtility wutil = new WebDriverUtility();

		// automate
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		// login
		// login using ObjectRepositoryUtility

		LoginPage loginreference = new LoginPage(driver);
		loginreference.loginInToApp(un, pwd);

		// organization link homepage
		HomePage homereference=new HomePage(driver);
		homereference.clickOrganizationLink();
	//	homereference.clickCampaignsLink();
		
		// organization page
		OrganizationPage organizationreference=new OrganizationPage(driver);
		organizationreference.getOrganizationCreateLink().click();
		

		// enter org name and click on same
		CreatingNewOrganizationPage CreateOrgReference=new CreatingNewOrganizationPage(driver);
		CreateOrgReference.createOrgName(orgname);
		CreateOrgReference.createIndustry("Education");
		CreateOrgReference.createAccounttype("Partner");
		CreateOrgReference.getSaveButton().click();

		// organization name verificUtion
		OrganizationInfoPage organizationinforeference=new OrganizationInfoPage(driver);
		String orgheader=organizationinforeference.getDvHeaderText().getText();
		

		if (orgheader.contains(orgname)) {
			System.out.println("pass : org header data is created :" + orgname);
		} else {
			System.out.println("fail org header data is not created ");
		}

		Thread.sleep(2000);
		// contact page
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// lastname
		driver.findElement(By.name("lastname")).sendKeys(lastname);

		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// switching to child window from parent window

		wutil.switchToWindowBasedOnUrl(driver, "module=Accounts");

		// child window task

		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();

		// dynamic xpath
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		// switch back to parent window
		wutil.switchToWindowBasedOnUrl(driver, "module=Contacts");

		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		// verification of contact information organization name
		String contactheader = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (contactheader.contains(orgname)) {
			System.out.println("pass : contact org header data is created :" + orgname);
		} else {
			System.out.println("fail contact org header data is not created ");
		}
         
		//logout
		homereference.clicksignout();
		driver.quit();
	}

}
