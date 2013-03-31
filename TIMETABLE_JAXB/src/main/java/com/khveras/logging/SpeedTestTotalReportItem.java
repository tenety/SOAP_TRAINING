package com.khveras.logging;

public class SpeedTestTotalReportItem implements IReportItem {
	private IReportItem previousRepItem;

	private long totalTime;
	private long totalBytes;
	private int cycles;
	private long avgSpeed;
	
	public SpeedTestTotalReportItem(long totalTime, long totalBytes, int cycles, long avgSpeed){
		this.totalTime=totalTime;
		this.totalBytes=totalBytes;
		this.cycles=cycles;
		this.avgSpeed=avgSpeed;
	}
	
	public SpeedTestTotalReportItem(IReportItem previousRepItem, long totalTime, long totalBytes, int cycles, long avgSpeed){
		this (totalTime, totalBytes, cycles, avgSpeed);
		this.previousRepItem=previousRepItem;

	}
	
	public String getPresentation() {
		StringBuilder result = new StringBuilder();
		result.append(">>> TEST RUN TOTALS:\n");
		if (!(previousRepItem instanceof SpeedTestTotalReportItem)){
			result.append(repeatSymbol("-", 30)+"\n");
			//Appending column headers
			result.append("| Total Time, ms ");
			result.append("| Bytes Proceed ");
			result.append("| Cycles ");
			result.append("| Avg. Speed, kb/s |\n");
			result.append(repeatSymbol("-", 30)+"\n");
		}
		
		
		// Appending values
		result.append(formatToLength("| "+totalTime, 8));
		result.append(formatToLength(" | "+totalBytes, 10));
		result.append(formatToLength(" | "+cycles, 10));
		result.append(formatToLength(" | "+avgSpeed, 10));
		result.append(repeatSymbol("-", 30)+"\n");
		
		return result.toString();
	}
	
	private String formatToLength(String str, int length){
		int space = (length-str.length()) / 2;
		return repeatSymbol(" ", space)+str+repeatSymbol(" ", space);
		
	}
	
	public String repeatSymbol(String symb, int repeations){
		StringBuilder result = new StringBuilder();
		for (int i=1; i<=repeations; i++){
			result.append(symb);
		}
		return result.toString();
	}

	public IReportItem getPreviousRepItem() {
		return previousRepItem;
	}

	public void setPreviousRepItem(IReportItem previousRepItem) {
		this.previousRepItem = previousRepItem;
	}
	
	
}
