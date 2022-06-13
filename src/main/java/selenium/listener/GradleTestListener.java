package selenium.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class GradleTestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(GradleTestListener.class);

    @Override
    public void onTestStart(ITestResult result) {logger.info("Test starts");}

    @Override
    public void onTestSuccess(ITestResult result) {logger.info("Test failure");}

    @Override
    public void onTestFailure(ITestResult result) {}

    @Override
    public void onTestSkipped(ITestResult result) {logger.info("Test skipped");}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {logger.info("Test finished");}
}
