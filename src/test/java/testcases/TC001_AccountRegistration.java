package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.RegistrationPage;
import utility.CommonUtility;

public class TC001_AccountRegistration extends TestBase {

	@Test
	public void verifyRegistration() {
		logger.info("***** Started TC001_AccountRegistration *****");

		HomePage objHomePage = new HomePage(driver);
		objHomePage.clickOnMyAccount();
		logger.info("Clicked on My Account Link");
		objHomePage.clickOnRegister();
		logger.info("Clicked on Register Link");

		RegistrationPage objRegistrationPage = new RegistrationPage(driver);
		objRegistrationPage.enterFirstName(CommonUtility.getRandomFirstName());
		objRegistrationPage.enterLastName(CommonUtility.getRandomLastName());
		String email = CommonUtility.getRandomEmail();
		System.out.println("Current Email: " + email);
		objRegistrationPage.enterEmail(email);
		logger.info("Entered the email address");
		objRegistrationPage.enterTelephone(CommonUtility.getRandomTelephoneNumber());
		logger.info("Entered the telephone number");
		String password = CommonUtility.getRandomPassword();
		System.out.println("Current Password: " + password);
		objRegistrationPage.enterPassword(password);
		logger.info("Entered the password");
		objRegistrationPage.enterConfirmPassword(password);
		logger.info("Entered the confirm password");
		objRegistrationPage.clickPrivacyPolicyCheckbox();
		logger.info("Clicked on privacy-policy checkbox");
		objRegistrationPage.clickFirstContinueButton();
		logger.info("Clicked on first continue button");

		String actualResult = objRegistrationPage.getSuccessMessage();
		String expectedResult = "Congratulations! Your new account has been successfully created!";
		Assert.assertEquals(actualResult, expectedResult, "Message doesn't matched, registration failed");

		objRegistrationPage.clickSecondContinueButton();
		logger.info("Clicked on second continue button");

		logger.info("***** Finished TC001_AccountRegistration *****");
	}
}
