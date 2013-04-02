package com.khveras.jaxb.utils;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.transform.stream.StreamSource;

import com.khveras.logging.Logger;

public class FileSystemHelper {
	public static StreamSource readResource(String resourceName){
		Logger.getLogger().debug("FileSystemHelper: Reading resourse '"+resourceName+"'");
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName);
		return new StreamSource(is);
	}
	
	public static File getResourceFile(String resourceName){
		return new File("src\\test\\resources", resourceName);
	}
	
	public static long getResourceSize(String resourceName) {
		URL url = Thread.currentThread().getContextClassLoader().getResource(resourceName);
		try {
			File file = new File(url.toURI());
			return file.length();
		} catch (URISyntaxException e) {
			Logger.getLogger().warn("Can't return size of resource '"+resourceName+"'");
			return 0;
		}
		
	}
	
}
