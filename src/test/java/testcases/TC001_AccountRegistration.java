package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.RegistrationPage;
import utility.CommonUtility;

public class TC001_AccountRegistration extends TestBase {
	HomePage objHomePage;
	RegistrationPage objRegistrationPage;

	@Test
	public void verifyRegistration() {
		objHomePage = new HomePage(driver);
		objHomePage.clickOnMyAccount();
		objHomePage.clickOnRegister();

		objRegistrationPage = new RegistrationPage(driver);
		objRegistrationPage.enterFirstName(CommonUtility.getRandomFirstName());
		objRegistrationPage.enterLastName(CommonUtility.getRandomLastName());
		String email = CommonUtility.getRandomEmail();
		System.out.println("Current Email: " + email);
		objRegistrationPage.enterEmail(email);
		objRegistrationPage.enterTelephone(CommonUtility.getRandomTelephoneNumber());
		String password = CommonUtility.getRandomPassword();
		System.out.println("Current Password: " + password);
		objRegistrationPage.enterPassword(password);
		objRegistrationPage.enterConfirmPassword(password);
		objRegistrationPage.clickPrivacyPolicyCheckbox();
		objRegistrationPage.clickFirstContinueButton();

		Assert.assertEquals(objRegistrationPage.getSuccessMessage(),
				"Congratulations! Your new account has been successfully created!");

		objRegistrationPage.clickSecondContinueButton();
	}
}
