package com.khveras.logging;

public class TotalItemsFactory {
	public enum TotalType{
		SPEED_TEST_RESULT;
//		Extend in case of need;
	}
	
	
	public static IReportItem createTotalReportItem (TotalType totalType, Object... args){
		switch (totalType){
			case SPEED_TEST_RESULT:
				String testName = args[0].toString();
				long totalTime = (Long)args[1];
				long totalBytes = (Long)args[2];
				int cycles = (Integer)args[3];;
				long avgSpeed = (Long)args[4];;
				return new SpeedTestTotalReportItem(testName, totalTime, totalBytes, cycles, avgSpeed);
			default:
				Logger.getLogger().warn("Not implemented for this total type. Returning null");
				return null;
		}
	}
}
