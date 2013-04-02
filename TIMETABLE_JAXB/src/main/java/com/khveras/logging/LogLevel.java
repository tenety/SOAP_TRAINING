package com.khveras.logging;

public enum LogLevel {
	TEST_ACTION ("TEST ACTION: "),
	DEBUG ("DEBUG: "),
	ERROR ("ERROR: "),
	WARNING ("WARNING: "),
	JUNIT ("JUNIT: "),
	CUSTOM ("");
	
	private String prefix;
	
	private LogLevel(String prefix){
		this.prefix = prefix;
	}
	
	public String getPrefix(){
		return prefix;
	}
	
}
