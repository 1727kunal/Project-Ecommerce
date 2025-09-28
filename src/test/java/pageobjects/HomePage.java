package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

public class HomePage extends PageBase {
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement linkMyAccount;
	@FindBy(linkText = "Register")
	WebElement linkRegister;
	@FindBy(linkText = "Login")
	WebElement linkLogin;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickOnMyAccount() {
		wait.until(ExpectedConditions.visibilityOf(linkMyAccount));
		linkMyAccount.click();
		Reporter.log("Clicked on My Account Link");
	}

	public void clickOnRegister() {
		wait.until(ExpectedConditions.visibilityOf(linkRegister));
		linkRegister.click();
		Reporter.log("Clicked on Register Link");
	}

	public void clickOnLogin() {
		wait.until(ExpectedConditions.visibilityOf(linkLogin));
		linkLogin.click();
		Reporter.log("Clicked on Login Link");
	}
}
