package Testng_package;


import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.castcast.crm.ObjectRepositoryUtility.CreatingNewOrganizationPage;
import com.castcast.crm.ObjectRepositoryUtility.HomePage;
import com.castcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.baseclassutility.BaseClass;

public class CreateOrgTest extends BaseClass{

	
	@Test(groups = "ST")
	public void Org_1_test() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
	    hp.clickOrganizationLink();
	    
	    OrganizationPage op=new OrganizationPage(driver);
	    op.getOrganizationCreateLink().click();
		
	    String orgname = excelutil.getDataFromExcel("org",1,2)+javautil.getRandomNumber();
	    //enter org name and click on same
	    driver.findElement(By.name("accountname")).sendKeys(orgname);
	    
	    CreatingNewOrganizationPage ccp=new CreatingNewOrganizationPage(driver);
	    ccp.getSaveButton().click();
		
		//verification of header information
		String headertextdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if (headertextdata.contains(orgname)) {
			System.out.println("pass : header data is created :"+orgname);
		} else {
			System.out.println("fail header data is not created ");
		}
		
		//verfication of organization name header information
		
		String orgheader = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (orgheader.contains(orgname)) {
			System.out.println("pass : org header data is created :"+orgname);
		} else {
			System.out.println("fail org header data is not created ");
		}
		
	}
	
	@Test(groups = "RT")
	public void org_2_test() throws EncryptedDocumentException, IOException {
		
		//common data from property file
		
			      
				String orgname = excelutil.getDataFromExcel("org", 1, 2)+javautil.getRandomNumber();
				String industry = excelutil.getDataFromExcel("org", 1, 4);
				String industrytype = excelutil.getDataFromExcel("org", 1, 5);
			    
				HomePage hp=new HomePage(driver);
			    hp.clickOrganizationLink();
			    
			    OrganizationPage op=new OrganizationPage(driver);
			    op.getOrganizationCreateLink().click();
			    
			    CreatingNewOrganizationPage ccp=new CreatingNewOrganizationPage(driver);
			    
			    ccp.createOrgName(orgname);
			    
				
			    //organization verification
			    String expecteddata = "Creating New Organization";
			    
			    String verifydata = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
				
			    if (verifydata.contains(expecteddata)) {
				System.out.println("DATA IS PRESENT PASS :"+expecteddata);	
				}
			    else {
			    	System.out.println("Data is Not present Fail :"+expecteddata);	
				}
			    
			    
			    //industry drop down button
			   ccp.createIndustry(industry);
			    
			    //industry type drop down button
			   ccp.createAccounttype(industrytype);
			    
			    //save
			    ccp.getSaveButton().click();
			
			    //validation for industry name
			    String validindustry = driver.findElement(By.id("dtlview_Industry")).getText();
			    if (validindustry.equals(industry)) {
					System.out.println("INDUSTRY NAME IS PRESENT PASS :"+industry);
				}else {
					System.out.println("INDUSTRY NAME IS NOT PRESENT FAIL :"+industry);
				}
			    
			    //validation for industry type
			    String validindustrytype = driver.findElement(By.id("dtlview_Type")).getText();
			    if (validindustrytype.equals(industrytype)) {
					System.out.println("INDUSTRY TYPE IS PRESENT PASS :"+industrytype);
				}else {
					System.out.println("INDUSTRY TYPE IS NOT PRESENT FAIL :"+industrytype);
				}
			    

		
	}
}
