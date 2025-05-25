package TestNGPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Started");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Success");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Failed");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Skipped");
	}
	 
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Case Failed But Within Success Percentage");
	}
	
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test Case Failed With Timeout");
	}
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Suite Started");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite Finished");
	}
	
}
