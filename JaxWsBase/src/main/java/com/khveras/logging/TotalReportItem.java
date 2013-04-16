package com.khveras.logging;

public class TotalReportItem implements IReportItem {

	private String testName;
	private String runResult;
	private String suiteName;
	
	public TotalReportItem(String testName, String runResult, String suiteName){
		this.testName=testName;
		this.runResult=runResult;
		this.suiteName=suiteName;
	}
	
	
	public String getPresentation() {
		StringBuilder result = new StringBuilder();
			String simplifiedSuiteName;
		try {
			simplifiedSuiteName = Class.forName(suiteName).getSimpleName();
		} catch (ClassNotFoundException e) {
			simplifiedSuiteName = "<Unresolved>";
		}
		result.append(Logger.LINE_SEPARATOR+"Suite: "+simplifiedSuiteName+Logger.LINE_SEPARATOR);

		result.append(repeatSymbol("-", 45)+Logger.LINE_SEPARATOR);
		//Appending column headers
		result.append("| "+formatToLength("Test name", 30));
		result.append(" | "+formatToLength("Success", 8)+" |"+Logger.LINE_SEPARATOR);
		result.append(repeatSymbol("-",45)+Logger.LINE_SEPARATOR);
		result.append(getAppendBlock());
		return result.toString();
	}
	
	
	public String getAppendBlock() {
		StringBuilder result = new StringBuilder();
		// Appending values
		result.append("| "+formatToLength(testName, 30));
		result.append(" | "+formatToLength(runResult, 8)+" |"+Logger.LINE_SEPARATOR);
		result.append(repeatSymbol("-", 45));
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


	public String getSuiteName() {
		return suiteName;
	}


	public boolean isSimilar(IReportItem otherItem) {
		if (!this.getClass().equals(otherItem.getClass())){
			return false;
		}
		else if (otherItem instanceof TotalReportItem){
			if (!(((TotalReportItem) otherItem).getSuiteName().equals(this.getSuiteName()))){
				return false;
			}
		}
		return true;
	}

}
