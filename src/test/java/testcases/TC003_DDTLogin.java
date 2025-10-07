package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import utility.DataProviderClass;

public class TC003_DDTLogin extends TestBase {

	@Test(dataProvider = "dataProviderForLogin", dataProviderClass = DataProviderClass.class, groups = { "DataDriven" })
	public void verifyLoginWithDDT(String email, String password, String expResult) {
		logger.info("***** Started TC003_DDTLogin *****");

		HomePage objHomePage = new HomePage(driver);
		LoginPage objLoginPage = new LoginPage(driver);
		MyAccountPage objMyAccountPage = new MyAccountPage(driver);

		objHomePage.clickOnMyAccount();
		logger.info("Clicked on My Account Link");
		objHomePage.clickOnLogin();
		logger.info("Clicked on Login Link");

		objLoginPage.enterEmail(email); // Get email using data provider
		logger.info("Entered the email address");
		objLoginPage.enterPassword(password); // Get password using data provider
		logger.info("Entered the password");
		objLoginPage.clickLoginButton();
		logger.info("Clicked on login button");

		String isHeaderPresent = objMyAccountPage.checkMyAccountHeaderVisibility();
		boolean isCorrectHeader = isHeaderPresent.trim().equals("My Account");
		if (expResult.equals("valid") && isCorrectHeader) {
			objHomePage.clickOnMyAccount();
			logger.info("Clicked on My Account Link");
			objMyAccountPage.clickOnLogout();
			Assert.assertTrue(true);
		} else if (expResult.equals("invalid") && !isCorrectHeader) {
			logger.info("Invalid credentials correctly rejected");
			Assert.assertTrue(true);
		} else {
			logger.error("Unexpected result - test failed");
			Assert.assertTrue(false);
		}

		logger.info("***** Finished TC003_DDTLogin *****");

	}

}
