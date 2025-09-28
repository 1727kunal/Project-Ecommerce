package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

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

		String expectedTitle = objMyAccountPage.getPageTitle();
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
}
