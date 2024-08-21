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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Organization_test {

	public static void main(String[] args) throws IOException {
	
	
	String path="./test_config/test_config.properties";
	
	//common data from property file
	FileInputStream fis=new FileInputStream(new File(path));
	
	Properties prop=new Properties();
	prop.load(fis);
	
    String url = prop.getProperty("Url");
    String username = prop.getProperty("username");
    String password = prop.getProperty("password");
    String browser = prop.getProperty("browser");
    
    //read data from excel file : test script data
    String excel = "./test_config/apachetestdata.xlsx";
    
    Random random=new Random();
    int number = random.nextInt(1000);
    
    FileInputStream fis1=new FileInputStream(new File(excel));
    Workbook workbook = WorkbookFactory.create(fis1);
    Sheet sheet = workbook.getSheet("org");
    String orgname = sheet.getRow(1).getCell(2).toString()+number;
    
    WebDriver driver=null;
    
    if(browser.equals("chrome"))
    {
    driver=new ChromeDriver();
    }
    else if (browser.equals("edge")) {
	driver=new EdgeDriver();
	}
    
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
	
    //enter org name and click on same
    driver.findElement(By.name("accountname")).sendKeys(orgname);
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
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
	
	//logout
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("(//img[@border='0'])[3]"))).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	
	driver.close();
	}
}
