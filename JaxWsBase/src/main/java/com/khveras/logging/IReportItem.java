package com.khveras.logging;

public interface IReportItem {
	public String getPresentation();
	public String getAppendBlock();
	public boolean isSimilar(IReportItem otherItem);
	
}
