package com.khveras.jaxb.marshalling;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.khveras.jaxb.utils.FileSystemHelper;
import com.khveras.logging.Logger;


public abstract class BaseJaxbMarshaller {
	public abstract void marshalObject (Object object, String resourceName);
	
	protected void marshalUsingContext(JAXBContext context, Object object, String resourceName){
		Logger.getLogger().debug("BaseJaxbMarshaller: Marshalling object of class "+object.getClass().getSimpleName()+" to resuorse file "+resourceName+" using context");
		try{
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(object, FileSystemHelper.getResourceFile(resourceName));
			Logger.getLogger().debug("BaseJaxbMarshaller: Marshalling done");
		} catch (JAXBException e) {
			Logger.getLogger().error(e.getClass().getSimpleName()+" occurred while marshalling object  of class '"+object.getClass().getSimpleName()+"'.");
			e.printStackTrace();
		}
	}
}
