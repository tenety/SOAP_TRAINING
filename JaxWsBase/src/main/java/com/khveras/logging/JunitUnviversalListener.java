package com.khveras.logging;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class JunitUnviversalListener extends RunListener {

	public boolean ignore = false;
	private String currentTestClass="";

	/**
	 * Called before any tests have been run.
	 * 
	 * @param description
	 *            describes the tests to be run
	 */
	public void testRunStarted(Description description) throws Exception {
		Logger.getLogger().log(LogLevel.JUNIT, "Tests started!");
	}

	/**
	 * Called when all tests have finished
	 * 
	 * @param result
	 *            the summary of the test run, including all the tests that
	 *            failed
	 */
	public void testRunFinished(Result result) throws Exception {
		Logger logger = Logger.getLogger();

		logger.log(LogLevel.JUNIT, "Test run finished!");
		int passTests = result.getRunCount() - result.getFailureCount()
				- result.getIgnoreCount();
		logger.log(LogLevel.JUNIT, "Tests passed: " + passTests
				+ ", tests failed: " + result.getFailureCount()
				+ ", tests ignored: " + result.getIgnoreCount() + ".");

		logger.printTotals();
		logger.saveTotalReport();
		logger.log(LogLevel.JUNIT, (Logger.SKIP_SAVING_REPORT ? ""
				: " See report at '" + logger.getReportFullPath() + "' file"));
	}

	/**
	 * Called when an atomic test is about to be started.
	 * 
	 * @param description
	 *            the description of the test that is about to be run (generally
	 *            a class and method name)
	 */
	public void testStarted(Description description) throws Exception {
		ignore = false;
		if (!currentTestClass.equals(description.getClassName())){
			currentTestClass = description.getClassName();
		}
		
		Logger.getLogger().log(LogLevel.JUNIT,
				"Test started: " + description.getMethodName());
	}

	/**
	 * Called when an atomic test has finished, whether the test succeeds or
	 * fails.
	 * 
	 * @param description
	 *            the description of the test that just ran
	 */
	public void testFinished(Description description) throws Exception {
		Logger.getLogger().log(LogLevel.JUNIT,
				"Test finished: " + description.getMethodName());
		if (ignore)
			return;
		Logger.getLogger().addTotalsItem(TotalType.METHOD_RESULT,
				description.getMethodName(), "pass", currentTestClass);

	}

	/**
	 * Called when an atomic test fails.
	 * 
	 * @param failure
	 *            describes the test that failed and the exception that was
	 *            thrown
	 */
	public void testFailure(Failure failure) throws Exception {
		ignore = true;
		Logger.getLogger().addTotalsItem(TotalType.METHOD_RESULT,
				failure.getDescription().getMethodName(), "fail", currentTestClass);
		Logger.getLogger().log(LogLevel.JUNIT,
				"Test failed: " + failure.getMessage());
	}

	/**
	 * Called when an atomic test flags that it assumes a condition that is
	 * false
	 * 
	 * @param failure
	 *            describes the test that failed and the
	 *            {@link AssumptionViolatedException} that was thrown
	 */
	public void testAssumptionFailure(Failure failure) {
	}

	/**
	 * Called when a test will not be run, generally because a test method is
	 * annotated with {@link org.junit.Ignore}.
	 * 
	 * @param description
	 *            describes the test that will not be run
	 */
	public void testIgnored(Description description) throws Exception {
		ignore = true;
		Logger.getLogger().addTotalsItem(TotalType.METHOD_RESULT,
				description.getMethodName(), "ignored");
		Logger.getLogger().log(
				LogLevel.JUNIT,
				"Test ignored: " + description.getClassName() + " - "
						+ description.getMethodName());
	}

}
