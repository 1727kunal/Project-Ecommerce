package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

public class RegistrationPage extends PageBase {
	@FindBy(id = "input-firstname")
	WebElement txtFirstName;
	@FindBy(id = "input-lastname")
	WebElement txtLastName;
	@FindBy(id = "input-email")
	WebElement txtEmail;
	@FindBy(id = "input-telephone")
	WebElement txtTelephone;
	@FindBy(id = "input-password")
	WebElement txtPassword;
	@FindBy(id = "input-confirm")
	WebElement txtConfirmPassword;
	@FindBy(name = "agree")
	WebElement checkPrivacyPolicy;
	@FindBy(xpath = "// input[@type='submit' and @value='Continue']")
	WebElement btnContinue1;
	@FindBy(xpath = "//div[@id='content']/p[1]")
	WebElement msgSuccess;
	@FindBy(linkText = "Continue")
	WebElement btnContinue2;

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	public void enterFirstName(String fName) {
		wait.until(ExpectedConditions.visibilityOf(txtFirstName));
		txtFirstName.sendKeys(fName);
		Reporter.log("First name is entered");
	}

	public void enterLastName(String lName) {
		wait.until(ExpectedConditions.visibilityOf(txtLastName));
		txtLastName.sendKeys(lName);
		Reporter.log("Last name is entered");
	}

	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(txtEmail));
		txtEmail.sendKeys(email);
		Reporter.log("Email address is entered");
	}

	public void enterTelephone(String telNum) {
		wait.until(ExpectedConditions.visibilityOf(txtTelephone));
		txtTelephone.sendKeys(telNum);
		Reporter.log("Telephone number is entered");
	}

	public void enterPassword(String pass) {
		wait.until(ExpectedConditions.visibilityOf(txtPassword));
		txtPassword.sendKeys(pass);
		Reporter.log("Password is entered");
	}

	public void enterConfirmPassword(String conPass) {
		wait.until(ExpectedConditions.visibilityOf(txtConfirmPassword));
		txtConfirmPassword.sendKeys(conPass);
		Reporter.log("Confirm password is entered");
	}

	public void clickPrivacyPolicyCheckbox() {
		wait.until(ExpectedConditions.visibilityOf(checkPrivacyPolicy));
		checkPrivacyPolicy.click();
		Reporter.log("Privacy-policy checkbox is checked");
	}

	public void clickFirstContinueButton() {
		wait.until(ExpectedConditions.visibilityOf(btnContinue1));
		btnContinue1.click();
		Reporter.log("First continue button is clicked");
	}

	public String getSuccessMessage() {
		wait.until(ExpectedConditions.visibilityOf(msgSuccess));
		return msgSuccess.getText();
	}

	public void clickSecondContinueButton() {
		wait.until(ExpectedConditions.visibilityOf(btnContinue2));
		btnContinue2.click();
		Reporter.log("Second continue button is clicked");
	}
}
