package com.khveras.jaxb.utils;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.khveras.logging.Logger;


// Applicable for single-thread usage only
public class JaxbContextManager {
	private static Map<Class<?>, JAXBContext> contextCache = new HashMap<Class<?>, JAXBContext>();
	
	public static JAXBContext getContext(Class<?> clazz) {
		if (contextCache.containsKey(clazz)){
			Logger.getLogger().debug("JaxbContextManager: Returning previously cached context for class: '"+clazz.getSimpleName()+"'");
			return contextCache.get(clazz);
		}
		else{
			try{
				Logger.getLogger().debug("JaxbContextManager: Creating new context cache member for class '"+clazz.getSimpleName()+"'");
				JAXBContext newContext = JAXBContext.newInstance( clazz );
				contextCache.put(clazz, newContext);
				return newContext;
			} catch (JAXBException e) {
				Logger.getLogger().error(e.getClass().getSimpleName()+" occurred on attempt to create context for '"+clazz.getSimpleName()+"' class. Null will be returned.");
				Logger.getLogger().error(e.getStackTrace().toString());
				return null;
			}
		}
	}

	//Forced creation of a new context
	public static JAXBContext forceNewContext(Class<?> clazz) {
		Logger.getLogger().debug("JaxbContextManager: Forced creation of a new context for class '"+clazz.getSimpleName()+"'");
		JAXBContext newContext;
		try {
			newContext = JAXBContext.newInstance( clazz );
		} catch (JAXBException e) {
			Logger.getLogger().error(e.getClass().getSimpleName()+" occurred on attempt to create context for '"+clazz.getSimpleName()+"' class. Null will be returned.");
			Logger.getLogger().error(e.getStackTrace().toString());
			return null;
		}
		if (!contextCache.containsKey(clazz)){
			contextCache.put(clazz, newContext);
		}
		return newContext;
	}
	
}
