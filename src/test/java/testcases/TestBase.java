package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {
	public WebDriver driver;
	public Logger logger;
	public FileInputStream propertiesFile;
	public Properties properties;

	@Parameters({ "os", "browser" })
	@BeforeMethod(groups = { "Sanity", "Regression", "DataDriven", "Master" })
	public void launchBrowser(String os, String browser) {
		// Loading data from config.properties file...
		try {
			propertiesFile = new FileInputStream(
					"C:\\Users\\admin\\eclipse-workspace\\ProjectEcommerce\\src\\test\\resources\\config.properties");
			properties = new Properties();
			properties.load(propertiesFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// To generate logs, logger is initialised...
		logger = LogManager.getLogger(this.getClass());

		// To perform cross-browser testing, parameter has been passed through
		// testng.xml file and received here...
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Wrong browser parameter...");
			return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().to(properties.getProperty("websiteURL"));
	}

	@AfterMethod(groups = { "Sanity", "Regression", "DataDriven", "Master" })
	public void tearDown() {
		try {
			propertiesFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
