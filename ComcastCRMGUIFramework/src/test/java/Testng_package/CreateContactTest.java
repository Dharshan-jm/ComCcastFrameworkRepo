package Testng_package;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.castcast.crm.ObjectRepositoryUtility.CreateContactPage;
import com.castcast.crm.ObjectRepositoryUtility.CreatingNewOrganizationPage;
import com.castcast.crm.ObjectRepositoryUtility.HomePage;
import com.castcast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.castcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.baseclassutility.BaseClass;
import com.comcast.crm.listenerutility.ClassListenerutility;


public class CreateContactTest extends BaseClass {

	@Test(groups = "ST")
	public void createcontacttest() throws IOException {
           
	    ClassListenerutility.test.log(Status.INFO, "read data from excel");
		// read test script data from excel file
		String lastname = excelutil.getDataFromExcel("org", 4, 2) + javautil.getRandomNumber();

		// navigate to contact module
		ClassListenerutility.test.log(Status.INFO, "navigate to contact from home page");
		HomePage homepage = new HomePage(driver);
		homepage.getContactLink().click();

		// click on create contact
		ClassListenerutility.test.log(Status.INFO, "create contact from contact page");
		CreateContactPage createcontact = new CreateContactPage(driver);
		
		ClassListenerutility.test.log(Status.INFO, "click on create contact icon");
		createcontact.createcontactlinkicon();

		// enter all details and create new contact
		createcontact.lastname(lastname);
		ClassListenerutility.test.log(Status.INFO, "enter last name");
		createcontact.contactsavebuttonicon();
		System.out.println("text-1");
	}

	@Test(groups = "RT")
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
		System.out.println("text-2");
	}
	
	@Test(groups = "RT")
	public void OrgwithContacttest() throws InterruptedException, EncryptedDocumentException, IOException {
		String orgname = excelutil.getDataFromExcel("org", 1, 2) + javautil.getRandomNumber();
		String lastname = excelutil.getDataFromExcel("org", 4, 2);

		// organization link homepage
		HomePage homereference=new HomePage(driver);
		homereference.clickOrganizationLink();
		
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
		CreateContactPage ccp=new CreateContactPage(driver);
		homereference.clickContactLink();
		ccp.createcontactlinkicon();

		// lastname
		ccp.lastname(lastname);

		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// switching to child window from parent window

		webutil.switchToWindowBasedOnUrl(driver, "module=Accounts");

		// child window task

		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();

		// dynamic xpath
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		// switch back to parent window
		webutil.switchToWindowBasedOnUrl(driver, "module=Contacts");

		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		// verification of contact information organization name
		String contactheader = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (contactheader.contains(orgname)) {
			System.out.println("pass : contact org header data is created :" + orgname);
		} else {
			System.out.println("fail contact org header data is not created ");
		}
         
	}
		
		
	}

	
