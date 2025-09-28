package utility;

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
}
