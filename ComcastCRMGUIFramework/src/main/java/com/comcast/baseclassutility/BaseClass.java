package com.comcast.baseclassutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.castcast.crm.ObjectRepositoryUtility.HomePage;
import com.castcast.crm.ObjectRepositoryUtility.LoginPage;
import com.castcast.crm.generic.databaseutlity.DataBaseUtility;
import com.castcast.crm.generic.fileutlity.ExcelUtility;
import com.castcast.crm.generic.fileutlity.FileUtility;
import com.castcast.crm.generic.webdrivereutlity.JavaUtility;
import com.castcast.crm.generic.webdrivereutlity.UtilityClassObject;
import com.castcast.crm.generic.webdrivereutlity.WebDriverUtility;

public class BaseClass {

	// object Creation for utility classes
	public DataBaseUtility datautil = new DataBaseUtility();
	public FileUtility fileutil = new FileUtility();
	public ExcelUtility excelutil = new ExcelUtility();
	public JavaUtility javautil = new JavaUtility();
	public WebDriverUtility webutil = new WebDriverUtility();

	// webdriver object
	public WebDriver driver = null;

	public static WebDriver tempdriver = null;

	@BeforeSuite(groups = { "ST", "RT" })
	public void configBS() throws SQLException {
		// connection to data base utility
		datautil.getDBconnection();
		System.out.println("before suite");

	}

	// parameters from testNG
//	@Parameters("browser")
	@BeforeClass(groups = { "ST", "RT" })
	public void configBC() throws IOException {
		// launch the browser
		String browser = fileutil.getDataFromPropertiesFile("browser");
		// or
		// reading the data from xml parameter
		// String browser=browserdata;

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		tempdriver = driver;
		UtilityClassObject.setDriver(driver);
		System.out.println("before class");
	}

	@BeforeMethod(groups = { "ST", "RT" })
	public void configBM() throws IOException {
		// login to app
		// object creation for object repository package class
		LoginPage loginrepo = new LoginPage(driver);

		String url = fileutil.getDataFromPropertiesFile("Url");
		String un = fileutil.getDataFromPropertiesFile("username");
		String pwd = fileutil.getDataFromPropertiesFile("password");

		driver.get(url);
		loginrepo.loginInToApp(un, pwd);
		System.out.println("before method");
	}

	@AfterMethod(groups = { "ST", "RT" })
	public void configAM() throws InterruptedException {
		// logout from app
		HomePage homerepo = new HomePage(driver);
		homerepo.clicksignout();
		Thread.sleep(4000);
		System.out.println("after method");
	}

	@AfterClass(groups = { "ST", "RT" })
	public void configAC() {
		// close the browser
		driver.quit();
		System.out.println("after class");
	}

	@AfterSuite(groups = { "ST", "RT" })
	public void configAS() throws SQLException {
		// close connection of database
		datautil.closeDBconnection();

		System.out.println("after suite");
	}

}
