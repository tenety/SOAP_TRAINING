package com.khveras.logging;

public class TotalItemsFactory {

	public static IReportItem createTotalReportItem(TotalType totalType,
			String... args) {
		switch (totalType) {
		case METHOD_RESULT:
			return new TotalReportItem(args[0], args[1], args[2]);
			
		default:
			Logger.getLogger().warn(
					"Not implemented for this total type. Returning null");
			return null;
		}
	}
}
