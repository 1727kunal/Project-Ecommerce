package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	public WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://tutorialsninja.com/demo/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
