package com.khveras.jaxb.utils;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;


// Applicable for single-thread usage only
public class JaxbContextManager {
	private static Map<Class<?>, JAXBContext> contextCache = new HashMap<Class<?>, JAXBContext>();
	
	public static JAXBContext getContext(Class<?> clazz) {
		if (contextCache.containsKey(clazz)){
			System.out.println("JaxbContextManager: Returning previously cached context for class: '"+clazz.getSimpleName()+"'");
			return contextCache.get(clazz);
		}
		else{
			try{
				System.out.println("JaxbContextManager: Creating new context cache member for class '"+clazz.getSimpleName()+"'");
				JAXBContext newContext = JAXBContext.newInstance( clazz );
				contextCache.put(clazz, newContext);
				return newContext;
			} catch (JAXBException e) {
				System.out.println(e.getClass().getSimpleName()+" occurred on attempt to create context for '"+clazz.getSimpleName()+"' class. Null will be returned.");
				e.printStackTrace();
				return null;
			}
		}
	}

	//Forced creation of a new context
	public static JAXBContext forceNewContext(Class<?> clazz) {
		System.out.println("JaxbContextManager: Forced creation of a new context for class '"+clazz.getSimpleName()+"'");
		JAXBContext newContext;
		try {
			newContext = JAXBContext.newInstance( clazz );
		} catch (JAXBException e) {
			System.out.println(e.getClass().getSimpleName()+" occurred on attempt to create context for '"+clazz.getSimpleName()+"' class. Null will be returned.");
			e.printStackTrace();
			return null;
		}
		if (!contextCache.containsKey(clazz)){
			contextCache.put(clazz, newContext);
		}
		return newContext;
	}
	
}
