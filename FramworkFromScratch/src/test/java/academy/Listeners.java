package academy;


import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners extends Base implements ITestListener
{
    ExtentTest test;

    //ExtentReporter extent = (ExtentReporter) ExtentReporterNg.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();


    @Override
    public void onStart(ITestContext context)
    {


    }

    @Override
    public void onFinish(ITestContext context)
    {

        // extent.flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {

    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        extentTest.get().fail(result.getThrowable());
        WebDriver driver = null;
        String testMethodName = result.getMethod().getMethodName();

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), result.getMethod().getMethodName());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onTestStart(ITestResult result)
    {
        //test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {

    }
}
