package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {
	public static WebDriver driver;
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

		// Here we are checking value of parameter environment from properties file to
		// decide browser should be opened locally or remotely...
		if (properties.getProperty("environment").equalsIgnoreCase("remote")) {
			// To perform cross-platform testing, here we are setting up the HUB using
			// selenium grid concept (Remote Setup)...

			String gridURL = "http://localhost:4444";
			DesiredCapabilities capabilities = new DesiredCapabilities();
			if (os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN10);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("Wrong operating system parameter...");
			}

			switch (browser.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("msedge");
				break;
			case "firefox":
				capabilities.setBrowserName("firefox");
				break;
			default:
				System.out.println("Wrong browser parameter...");
				return;
			}
			try {
				URI uri = new URI(gridURL);
				URL url = uri.toURL();
				driver = new RemoteWebDriver(url, capabilities);
			} catch (MalformedURLException | URISyntaxException e) {
				e.printStackTrace();
			}
		}

		if (properties.getProperty("environment").equalsIgnoreCase("local")) {
			// To perform cross-browser testing, parameter has been passed through
			// testng.xml file and received here (Local Setup)...

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
