package com.khveras.jaxb.unmarshalling;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.khveras.jaxb.utils.FileSystemHelper;


public abstract class BaseJaxbUnmarshaller {
	public abstract <T> T unmarshalObject (String resourceName, Class<T> objectClass);
	
	protected <T> T  unmarshalUsingContext(JAXBContext context, Class<T> objectClass, String resourceName){
		System.out.println("BaseJaxbUnmarshaller: Unmarshalling object of class "+objectClass.getSimpleName()+" using context");
		try{
			Unmarshaller u = context.createUnmarshaller();
			JAXBElement<T> unmarshaled =
				      u.unmarshal( FileSystemHelper.readResource(resourceName), objectClass );
			System.out.println("BaseJaxbUnmarshaller: Unmarshalling done");
			return unmarshaled.getValue();
		} catch (JAXBException e) {
			System.out.println(e.getClass().getSimpleName()+" occurred while unmarshalling resource '"+resourceName+"'. Null will be returned.");
			e.printStackTrace();
			return null;
		}
	}
}
