package listeners;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyListener implements ITestListener {

    public static ExtentReports reports;
    public static ExtentTest test;

    public void onTestStart(ITestResult result) {
        test = reports.startTest(result.getMethod().getMethodName());
        test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
    }

    public void onTestSuccess(ITestResult result) {
        test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
    }

    public void onTestFailure(ITestResult result) {
        test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");

    }

    public void onTestSkipped(ITestResult result) {
        test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("on test sucess within percentage");
    }

    public void onStart(ITestContext context) {
        reports = new ExtentReports("reports/Extent Reports/" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
    }

    public void onFinish(ITestContext context) {
        System.out.println("on finish");
        reports.endTest(test);
        reports.flush();
    }

}