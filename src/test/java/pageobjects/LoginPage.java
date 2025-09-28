package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

public class LoginPage extends PageBase {
	@FindBy(id = "input-email")
	WebElement txtEmail;
	@FindBy(id = "input-password")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnLogin;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(txtEmail));
		txtEmail.sendKeys(email);
		Reporter.log("Email address is entered");
	}

	public void enterPassword(String pass) {
		wait.until(ExpectedConditions.visibilityOf(txtPassword));
		txtPassword.sendKeys(pass);
		Reporter.log("Password is entered");
	}

	public void clickLoginButton() {
		wait.until(ExpectedConditions.visibilityOf(btnLogin));
		btnLogin.click();
		Reporter.log("Login button is clicked");
	}

}
