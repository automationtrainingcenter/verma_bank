package utilities;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class TestNGListener extends BrowserHelper implements ISuiteListener, ITestListener{

	@Override
	public void onStart(ISuite suite) {
		reports = new ExtentReports(getFilePath("reports", "report.html"));
	}

	@Override
	public void onFinish(ISuite suite) {
		reports.flush();
		reports.close();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = reports.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName()+" started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName()+" passed");
		reports.endTest(test);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, result.getName()+" failed");
		reports.endTest(test);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.INFO, result.getName()+ " skipped");
		reports.endTest(test);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

}
