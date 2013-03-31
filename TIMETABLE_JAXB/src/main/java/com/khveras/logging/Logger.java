package com.khveras.logging;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

// Logger implementation for single-thread usage
public class Logger {
	public static final String REPORT_FILENAME="Report.txt";
	private OutputStream notifyStream = System.out; //Here notifications will appear
	// Log messages that get to notify stream
	public static final List<LogLevel> NOTIFICATION_LEVELS = new ArrayList<LogLevel>(){
		private static final long serialVersionUID = 1372696788150424138L;
	{
		add(LogLevel.TEST_ACTION);
		add(LogLevel.DEBUG);
		add(LogLevel.CUSTOM);
		add(LogLevel.JUNIT);
		add(LogLevel.WARNING);
	}};
	public static final LogLevel DEFAULT_LOG_LEVEL = LogLevel.TEST_ACTION;
	
	
	public static Logger logger;
	
	
	List<IReportItem> ongoingReport = new ArrayList<IReportItem>();
	List<IReportItem> totalReport = new ArrayList<IReportItem>();
	
	private Logger(){};
	
	public static Logger initLogger(){
		if (logger!=null){
			logger.notify("Logger was already init");
		}
		logger = new Logger();
		
		return logger;
	}
	
	public static Logger getLogger(){
		if (logger==null){
			throw new RuntimeException("Can't perform any operation with logger until it is init");
		}
		return logger;
	}
	
	
	private OutputStream initReportFile(String reportFileName){
		File reportFile = new File("Report.txt");
		if (reportFile.exists()) {
			reportFile.delete();
		}
		try {
			reportFile.createNewFile();
			return new FileOutputStream(reportFile);
		} catch (IOException e) {
			throw new RuntimeException("Error creating report file", e);
		}
	}
	
	public void saveTotalReport(){
		OutputStream fos = initReportFile(REPORT_FILENAME);
		try {
			for (IReportItem reportItem:ongoingReport){
					fos.write(reportItem.getPresentation().getBytes());
			}
			
			for (IReportItem reportItem:totalReport){
				fos.write(reportItem.getPresentation().getBytes());
			}
			fos.flush();
			fos.close();
			
		} catch (IOException e) {
			throw new RuntimeException("Error saving report", e);
		}
		
		
	}
	
	private void notify(String msg){
		try {
			notifyStream.write((msg+"\n").getBytes());
		} catch (IOException e) {
			throw new RuntimeException("Error writing in notifyStream", e);
		}
	}
	
	public void log (LogLevel logLevel, String message){
		OngoingReportItem repItem = new OngoingReportItem(logLevel.getPrefix(), message);
		ongoingReport.add(repItem);
		if (NOTIFICATION_LEVELS.contains(logLevel)){
			notify(repItem.getPresentation());
		}
	}
	
	public void debug (String message){
		log (LogLevel.DEBUG, message);
	}
	
	public void testAction (String message){
		log (LogLevel.TEST_ACTION, message);
	}

	public void addTotalsItem (IReportItem reportItem){
		totalReport.add(reportItem);
	}
	
	public void printTotals(){
		for (IReportItem reportItem:totalReport){
			notify(reportItem.getPresentation());
		}
	}
	
}
