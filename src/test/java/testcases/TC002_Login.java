package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import utility.CommonUtility;

public class TC002_Login extends TestBase {
	HomePage objHomePage;
	LoginPage objLoginPage;
	MyAccountPage objMyAccountPage;

	@Test
	public void verfiyLogin() {
		objHomePage = new HomePage(driver);
		objLoginPage = new LoginPage(driver);
		objMyAccountPage = new MyAccountPage(driver);

		objHomePage.clickOnMyAccount();
		objHomePage.clickOnLogin();

		objLoginPage.enterEmail("kunalwagh1163@gmail.com");
		objLoginPage.enterPassword("kunal1727");
		objLoginPage.clickLoginButton();

		CommonUtility.holdFor(1000);
		String currentTitle = driver.getTitle();
		Assert.assertEquals(currentTitle, "My Account");
	}
}
