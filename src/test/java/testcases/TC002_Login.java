package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import utility.CommonUtility;
import utility.ExtentReportUtility;

public class TC002_Login extends TestBase {

	@Test(groups = { "Regression", "Master" }, retryAnalyzer = ExtentReportUtility.class)
	public void verfiyLogin() {
		logger.info("***** Started TC002_Login *****");

		HomePage objHomePage = new HomePage(driver);
		LoginPage objLoginPage = new LoginPage(driver);

		objHomePage.clickOnMyAccount();
		logger.info("Clicked on My Account Link");
		objHomePage.clickOnLogin();
		logger.info("Clicked on Login Link");

		objLoginPage.enterEmail(properties.getProperty("email"));
		logger.info("Entered the email address");
		objLoginPage.enterPassword(properties.getProperty("password"));
		logger.info("Entered the password");
		objLoginPage.clickLoginButton();
		logger.info("Clicked on login button");
		CommonUtility.holdFor(1000);

		String actualResult = driver.getTitle();
		String expectedResult = "My Account";
		Assert.assertEquals(actualResult, expectedResult, "Title doesn't matched, login failed");

		logger.info("***** Finished TC002_Login *****");
	}
}
