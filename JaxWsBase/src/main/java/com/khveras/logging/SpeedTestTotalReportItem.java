package com.khveras.logging;

public class SpeedTestTotalReportItem implements IReportItem {

	private String testName;
	private long totalTime;
	private long totalBytes;
	private int cycles;
	private long avgSpeed;
	
	public SpeedTestTotalReportItem(String testName, long totalTime, long totalBytes, int cycles, long avgSpeed){
		this.testName=testName;
		this.totalTime=totalTime;
		this.totalBytes=totalBytes;
		this.cycles=cycles;
		this.avgSpeed=avgSpeed;
	}
	
	
	public String getPresentation() {
		StringBuilder result = new StringBuilder();
		result.append(">>> TEST RUN TOTALS:"+Logger.LINE_SEPARATOR);

		result.append(repeatSymbol("-", 95)+Logger.LINE_SEPARATOR);
		//Appending column headers
		result.append("| "+formatToLength("Test name", 30));
		result.append(" | "+formatToLength("Total Time, ms", 14));
		result.append(" | "+formatToLength("Bytes Proceed", 13));
		result.append(" | "+formatToLength("Cycles", 6));
		result.append(" | "+formatToLength("Avg. Speed, kb/s", 16)+" |"+Logger.LINE_SEPARATOR);
		result.append(repeatSymbol("-",95)+Logger.LINE_SEPARATOR);
		result.append(getAppendBlock());
		return result.toString();
	}
	
	
	public String getAppendBlock() {
		StringBuilder result = new StringBuilder();
		// Appending values
		result.append("| "+formatToLength(testName, 30));
		result.append(" | "+formatToLength(Long.toString(totalTime), 14));
		result.append(" | "+formatToLength(Long.toString(totalBytes), 13));
		result.append(" | "+formatToLength(Integer.toString(cycles), 6));
		result.append(" | "+formatToLength(Long.toString(avgSpeed), 16)+" |"+Logger.LINE_SEPARATOR);
		result.append(repeatSymbol("-", 95));
		return result.toString();
	}
	
	
	private String formatToLength(String str, int length){
		int space = (length-str.length()) / 2;
		return repeatSymbol(" ", space)+str+repeatSymbol(" ", length-str.length()-space);
		
	}
	
	public String repeatSymbol(String symb, int repeations){
		StringBuilder result = new StringBuilder();
		for (int i=1; i<=repeations; i++){
			result.append(symb);
		}
		return result.toString();
	}



	
	
	
}
