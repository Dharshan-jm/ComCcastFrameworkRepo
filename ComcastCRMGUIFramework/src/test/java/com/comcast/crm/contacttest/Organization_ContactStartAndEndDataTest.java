package com.comcast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.castcast.crm.ObjectRepositoryUtility.CreateContactPage;
import com.castcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.baseclassutility.BaseClass;


public class Organization_ContactStartAndEndDataTest extends BaseClass {

	@Test
	public void createTest() throws EncryptedDocumentException, IOException {

		// get local date and time format

		String actualdate = javautil.getSystemDateYYYYDDMM();
		String futuredate = javautil.getRequiredDataYYYYDDMM(+30);
		// ------------------------------------------------------------------

		// Script data from excel
		String lastname = excelutil.getDataFromExcel("org", 4, 2) + javautil.getRandomNumber();

		// -------------------------------------------------------------------

		String url = fileutil.getDataFromPropertiesFile("Url");
		driver.get(url);

		// login using ObjectRepositoryUtility

		// contact page
		HomePage homepage = new HomePage(driver);
		homepage.clickContactLink();

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createcontactlinkicon();
		ccp.lastname(lastname);

		// contact page date
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(actualdate);

		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(futuredate);

		// click on save
		ccp.contactsavebuttonicon();

		// validate start date

		String startdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();

		if (startdate.equals(actualdate)) {
			System.out.println("START DATE IS PRESENT PASS :" + actualdate);
		} else {
			System.out.println("START DATE IS NOT PRESENT PASS :" + actualdate);
		}

		// validate end date

		String enddate = driver.findElement(By.id("dtlview_Support End Date")).getText();

		if (enddate.equals(futuredate)) {
			System.out.println("END DATE IS PRESENT PASS :" + futuredate);
		} else {
			System.out.println("END DATE IS NOT PRESENT PASS :" + futuredate);
		}

	}

}
