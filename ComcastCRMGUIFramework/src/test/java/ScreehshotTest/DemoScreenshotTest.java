package ScreehshotTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class DemoScreenshotTest {

	
	@Test
	public void demotest() throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		
		EventFiringWebDriver event=new EventFiringWebDriver(driver);
		
		File temp = event.getScreenshotAs(OutputType.FILE);
		
		File dest=new File("./screenshotdata/pic1243.png");
		
		FileUtils.copyFile(temp, dest);
	}
}
