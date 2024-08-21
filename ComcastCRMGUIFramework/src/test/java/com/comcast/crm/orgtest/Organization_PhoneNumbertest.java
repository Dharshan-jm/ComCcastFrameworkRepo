package com.comcast.crm.orgtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Organization_PhoneNumbertest {

	public static void main(String[] args) throws IOException {
		
		//common data from property file
		String path = "./test_config/test_config.properties";
		FileInputStream fis=new FileInputStream(new File(path));
		
		Properties prop=new Properties();
		prop.load(fis);
		
		String url = prop.getProperty("Url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		//script data from excel
		String excel="./test_config/apachetestdata.xlsx";
		
		FileInputStream fis1=new FileInputStream(new File(excel));
		Workbook workbook = WorkbookFactory.create(fis1);
		Sheet sheet = workbook.getSheet("org");
		
		Random ran=new Random();
		int number = ran.nextInt(20000);
		String orgname = sheet.getRow(1).getCell(2).toString()+number;
		String industry = sheet.getRow(1).getCell(4).toString();
		String industrytype = sheet.getRow(1).getCell(5).toString();
		String phone=sheet.getRow(1).getCell(6).toString();
		
				
		//---------------------------------------------------------
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
		 //login
	    driver.findElement(By.name("user_name")).sendKeys(username);
	    driver.findElement(By.name("user_password")).sendKeys(password);
	    driver.findElement(By.id("submitButton")).click();
	    
	    //click on organization
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		
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
	    WebElement industrydropdown = driver.findElement(By.name("industry"));
	    Select sel=new Select(industrydropdown);
	    sel.selectByVisibleText(industry);
	    
	    //industry type drop down button
	    WebElement industrytypedropdown = driver.findElement(By.name("accounttype"));
	    Select sel1=new Select(industrytypedropdown);
	    sel1.selectByVisibleText(industrytype);
	    
	    //enter phone number
	    driver.findElement(By.id("phone")).sendKeys(phone);
	    
	    //save
	    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
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
	    
	    //validation for phone number
	    String validphoneno = driver.findElement(By.id("dtlview_Phone")).getText();
	    if (validphoneno.equals(phone)) {
			System.out.println("PHONE NUMBER IS PRESENT PASS :"+phone);
		}else {
			System.out.println("PHONE NUMBER IS NOT PRESENT FAIL :"+phone);
		}
	    
	    //logout
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//img[@border='0'])[3]"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();

	}

}
