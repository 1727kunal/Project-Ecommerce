package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import net.datafaker.Faker;

public class CommonUtility {

	static Faker faker = new Faker();

	public static void holdFor(long miliSeconds) {
		try {
			Thread.sleep(miliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getRandomFirstName() {
		return faker.name().firstName();
	}

	public static String getRandomLastName() {
		return faker.name().lastName();
	}

	public static String getRandomEmail() {
		return faker.internet().emailAddress();
	}

	public static String getRandomTelephoneNumber() {
		return faker.phoneNumber().cellPhone();
	}

	public static String getRandomPassword() {
		String password = faker.lorem().characters(12, true, true);
		return password;
	}

	public static String getSnanshot(WebDriver driver, String methodName) {
		String timeStamp = new SimpleDateFormat("dd.MMM.yyyy_hh.mm.ss").format(new Date());
		String destinationLocation = "C:\\Users\\admin\\eclipse-workspace\\ProjectEcommerce\\Screenshots\\" + methodName
				+ timeStamp + ".png";

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceImg = ts.getScreenshotAs(OutputType.FILE);
		File destImg = new File(destinationLocation);

		try {
			FileUtils.copyFile(sourceImg, destImg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destinationLocation;
	}
}
