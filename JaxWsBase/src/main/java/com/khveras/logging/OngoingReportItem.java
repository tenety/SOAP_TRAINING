package com.khveras.logging;

public class OngoingReportItem implements IReportItem {
	private String prefix;
	private String message;
	
	public OngoingReportItem (String prefix, String message){
		this.prefix=prefix;
		this.message=message;
	}
	
	public String getPresentation() {
		return prefix+message;
	}

	public String getAppendBlock() {
		return getPresentation();
	}

	public boolean isSimilar(IReportItem otherItem) {
		return otherItem.getClass().equals(this.getClass());
	}
	
	
}
