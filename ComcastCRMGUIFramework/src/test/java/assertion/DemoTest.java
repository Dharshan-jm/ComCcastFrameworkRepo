package assertion;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {
	
	@Test
	public void homepage(Method mtd) {
		System.out.println(mtd.getName()+"method start");
		
		String exphomepagetitle="Homepage";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root@123");
		driver.findElement(By.id("submitButton")).click();
		
		String acthomepagetitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		
		//hard assert
		Assert.assertEquals(acthomepagetitle, exphomepagetitle);
	   
	
		
		System.out.println(mtd.getName()+"method end");
		driver.quit();
	}

	
	@Test
	public void logohomepagetest(Method mtd) {
		System.out.println(mtd.getName()+"method start");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root@123");
		driver.findElement(By.id("submitButton")).click();
		
		boolean key = driver.findElement(By.xpath("//img[@alt='vtiger-crm-logo.gif']")).isEnabled();
		
		//hard assert
		Assert.assertEquals(true,key);
		
		System.out.println(mtd.getName()+"method end");
		driver.quit();
	}
}
























