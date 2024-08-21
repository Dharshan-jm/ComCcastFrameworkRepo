package assertion;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.castcast.crm.ObjectRepositoryUtility.CreateContactPage;
import com.castcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.baseclassutility.BaseClass;


public class DemoContactTest extends BaseClass {

	
	@Test
	public void contacttest() throws EncryptedDocumentException, IOException {
		
		HomePage hp=new HomePage(driver);
		
		//homepage 
		hp.clickContactLink();
		
		String lastname = excelutil.getDataFromExcel("org", 4, 2)+javautil.getRandomNumber();
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createcontactlinkicon();
		ccp.lastname(lastname);
		ccp.contactsavebuttonicon();
		
		//page verification
		String actelement = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		boolean status = actelement.contains(lastname);
		//assert(hard)
		Assert.assertEquals(status, true);
		
		//act last name verification
		String actlastname = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actlastname,lastname);
		soft.assertAll();
    //    System.out.println();
	}
}
