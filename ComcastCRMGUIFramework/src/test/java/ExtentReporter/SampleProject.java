package ExtentReporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.baseclassutility.BaseClass;
import com.comcast.crm.listenerutility.ClassListenerutility;


@Listeners(com.comcast.crm.listenerutility.ClassListenerutility.class)
public class SampleProject extends BaseClass{

     
	@Test
	public void createContactTest() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		

		ClassListenerutility.test.log(Status.INFO, "login to app");
		ClassListenerutility.test.log(Status.INFO, "navigate to contact page");
		ClassListenerutility.test.log(Status.INFO, "create contact");

		if ("hdfc".equals("dfc")) {
			ClassListenerutility.test.log(Status.PASS, "contact is created");
		} else {
		
		}

		ClassListenerutility.test.log(Status.INFO, "logout");

	}
    
	@Test
	public void createContactWithOrgTest() {

		ClassListenerutility.test.log(Status.INFO, "login to app");
		ClassListenerutility.test.log(Status.INFO, "navigate to contact page");
		ClassListenerutility.test.log(Status.INFO, "create contact");

		if ("hdfc".equals("hdfc")) {
			ClassListenerutility.test.log(Status.PASS, "contact with org is created");
		} else {
			ClassListenerutility.test.log(Status.FAIL, "contact with org is not created");
		}

		ClassListenerutility.test.log(Status.INFO, "logout");

	}
	
	@Test
	public void createContactWithPhoneNumberTest() {


		ClassListenerutility.test.log(Status.INFO, "login to app");
		ClassListenerutility.test.log(Status.INFO, "navigate to contact page");
		ClassListenerutility.test.log(Status.INFO, "create contact");

		if ("hdfc".equals("hdfc")) {
			ClassListenerutility.test.log(Status.PASS, "contact with phone no is created");
		} else {
			ClassListenerutility.test.log(Status.FAIL, "contact with phone no is not created");
		}

		ClassListenerutility.test.log(Status.INFO, "logout");

	}
}
