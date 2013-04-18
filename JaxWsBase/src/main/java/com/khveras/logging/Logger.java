package com.khveras.logging;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

// Logger implementation for single-thread usage
public class Logger {
	public static final String REPORT_FILENAME="Report.txt";
	public static final boolean SKIP_SAVING_REPORT=false;
	public static final boolean OPEN_REPORT_IN_OS=true;
	
	private File reportFile;
	
	private OutputStream notifyStream = System.out; //Here notifications will appear
	// Disable subitems to configure notifications level
	public static final List<LogLevel> NOTIFICATION_LEVELS = new ArrayList<LogLevel>(){
		private static final long serialVersionUID = 1372696788150424138L;
	{
		add(LogLevel.TEST_ACTION);
		add(LogLevel.DEBUG);
		add(LogLevel.CUSTOM);
		add(LogLevel.JUNIT);
		add(LogLevel.WARNING);
		add(LogLevel.ERROR);
	}};
	public static final LogLevel DEFAULT_LOG_LEVEL = LogLevel.TEST_ACTION;
	
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	
	public static Logger logger;
	
	
	List<IReportItem> ongoingReport = new ArrayList<IReportItem>();
	List<IReportItem> totalReport = new ArrayList<IReportItem>();
	
	private Logger(){};
	

	public static Logger getLogger(){
		if (logger==null){
			logger = new Logger();
		}
		
		return logger;
	}
	
	public String getReportFullPath(){
		if (!reportFile.exists()) {
			error("Can't get report fullpath: report file doesn't exist");
			return "";
		}
		return reportFile.getAbsolutePath();
	}
	
	private OutputStream initReportFile(String reportFileName){
		reportFile = new File("Report.txt");
		if (reportFile.exists()) {
			reportFile.delete();
		}
		try {
			reportFile.createNewFile();
//			Logger.getLogger().debug("Report file created: "+reportFile.getAbsolutePath());
			return new FileOutputStream(reportFile);
		} catch (IOException e) {
			throw new RuntimeException("Error creating report file", e);
		}
	}
	
	public void saveTotalReport(){
		if (SKIP_SAVING_REPORT) return;
		OutputStream fos = initReportFile(REPORT_FILENAME);
		try {
			
			IReportItem previousItem=null;
			
			fos.write((" >>> Test results: "+LINE_SEPARATOR).getBytes());
			
			for (IReportItem currentItem: totalReport){
				if ((previousItem!=null)&&(currentItem.isSimilar(previousItem))){
					fos.write((currentItem.getAppendBlock()+LINE_SEPARATOR).getBytes());
				}
				else{
					fos.write((currentItem.getPresentation()+LINE_SEPARATOR).getBytes());
				}
				previousItem = currentItem;
			}
			
			fos.write(LINE_SEPARATOR.getBytes());
			
			fos.write((" >>> Debug: "+LINE_SEPARATOR+LINE_SEPARATOR).getBytes());
			
			for (IReportItem reportItem:ongoingReport){
					fos.write((reportItem.getPresentation()+LINE_SEPARATOR).getBytes());
			}
			
			

			fos.flush();
			fos.close();
			if (OPEN_REPORT_IN_OS){
				Desktop.getDesktop().open(reportFile);
			}
			
		} catch (IOException e) {
			throw new RuntimeException("Error saving report", e);
		}
		
		
	}
	
	private void notify(String msg){
		try {
			notifyStream.write((msg+LINE_SEPARATOR).getBytes());
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
	
	public void error (String message){
		log (LogLevel.ERROR, message);
	}
	
	public void testAction (String message){
		log (LogLevel.TEST_ACTION, message);
	}
	
	public void warn (String message){
		log (LogLevel.WARNING, message);
	}

	public void addTotalsItem (TotalType totalType, String... args){
		totalReport.add(TotalItemsFactory.createTotalReportItem(totalType, args));
	}
	
	public void printTotals(){
		IReportItem previousItem=null;
		for (IReportItem currentItem: totalReport){
			if ((previousItem!=null)&&(currentItem.isSimilar(previousItem))){
				notify(currentItem.getAppendBlock());
			}
			else{
				notify(currentItem.getPresentation());
			}
			previousItem = currentItem;
		}
	}
	
}
