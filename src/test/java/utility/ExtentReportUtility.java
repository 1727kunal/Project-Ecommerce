package utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testcases.TestBase;

public class ExtentReportUtility implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReports;
	public ExtentTest test;

	String reportLocation;

	@Override
	public void onStart(ITestContext context) {
		String currentDate = new SimpleDateFormat("dd.MMM.yyyy_hh.mm.ss").format(new Date());
		reportLocation = "C:\\Users\\admin\\eclipse-workspace\\ProjectEcommerce\\Reports\\" + "Extent-Report-"
				+ currentDate + ".html";
		sparkReporter = new ExtentSparkReporter(reportLocation);
		sparkReporter.config().setDocumentTitle("Extent-Report-ProjectEcommerce");
		sparkReporter.config().setReportName("Final Report");
		sparkReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Project Name", "Ecommerce Website");
		extentReports.setSystemInfo("Module", "Registration and Login");
		extentReports.setSystemInfo("OS", context.getCurrentXmlTest().getParameter("os"));
		extentReports.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));
		extentReports.setSystemInfo("Team Member", "Kunal");
		extentReports.setSystemInfo("Environment", "QA");

		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extentReports.setSystemInfo("Groups", includedGroups.toString());
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extentReports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getMethod().getMethodName() + " passed successfully.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extentReports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getMethod().getMethodName() + " has been failed.");
		test.log(Status.INFO, result.getThrowable().getMessage());

		String screenshotLink = CommonUtility.getSnanshot(TestBase.driver, result.getName());
		test.addScreenCaptureFromPath(screenshotLink);
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
}
