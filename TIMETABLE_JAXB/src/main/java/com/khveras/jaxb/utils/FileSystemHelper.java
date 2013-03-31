package com.khveras.jaxb.utils;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.transform.stream.StreamSource;

public class FileSystemHelper {
	public static StreamSource readResource(String resourceName){
		System.out.println("FileSystemHelper: Reading resourse '"+resourceName+"'");
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName);
		return new StreamSource(is);
	}
	
	public static long getFileSize(String resourceName) {
		URL url = Thread.currentThread().getContextClassLoader().getResource(resourceName);
		try {
			File file = new File(url.toURI());
			return file.length();
		} catch (URISyntaxException e) {
			System.out.println("Can't return size of resource "+resourceName+"'");
			return 0;
		}
		
	}
}
