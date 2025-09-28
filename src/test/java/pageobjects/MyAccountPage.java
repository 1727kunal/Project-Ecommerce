package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getPageTitle() {
		wait.until(ExpectedConditions.titleContains("My Account"));
		return driver.getTitle();
	}
}
