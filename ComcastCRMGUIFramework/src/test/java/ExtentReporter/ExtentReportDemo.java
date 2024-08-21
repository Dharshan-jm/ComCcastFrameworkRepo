package ExtentReporter;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.castcast.crm.generic.webdrivereutlity.UtilityClassObject;
import com.comcast.baseclassutility.BaseClass;
import com.comcast.crm.listenerutility.newextentlistener;

@Listeners(com.comcast.crm.listenerutility.newextentlistener.class)
public class ExtentReportDemo extends BaseClass{

	@Test
	public void demotest() {
		
//		UtilityClassObject.getTest().log(Status.INFO, "open browser");
//		WebDriver driver=new ChromeDriver();
//		
//		UtilityClassObject.getTest().log(Status.INFO, "go to url");
//		driver.get("http://localhost:8")

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("img[@alt='Create Organization...']")).click();
		
		//test fail
		driver.findElement(By.name("acname")).sendKeys("abcd");
		
		
		
		newextentlistener.test.log(Status.INFO,"check if block");
		
		if ("abcd".equals("efgh")) {
			UtilityClassObject.getTest().log(Status.PASS, "verified");
		}
		else {
			UtilityClassObject.getTest().log(Status.FAIL, "not verified");
		}
		
		
	}
}
