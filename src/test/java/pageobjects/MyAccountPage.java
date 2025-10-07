package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

public class MyAccountPage extends PageBase {

	@FindBy(linkText = "Logout")
	WebElement linkLogout;
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement headTxtMyAcc;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnLogout() {
		wait.until(ExpectedConditions.visibilityOf(linkLogout));
		linkLogout.click();
		Reporter.log("Clicked on Logout Link");
	}

	public String checkMyAccountHeaderVisibility() {
		wait.until(ExpectedConditions.visibilityOf(headTxtMyAcc));
		return headTxtMyAcc.getText();
	}
}
