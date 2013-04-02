package com.khveras.jaxb.marshalling;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.khveras.jaxb.utils.FileSystemHelper;
import com.khveras.logging.Logger;


public abstract class BaseJaxbUnmarshaller {
	public abstract <T> T unmarshalObject (String resourceName, Class<T> objectClass, boolean useValidation);
	
	protected <T> T  unmarshalUsingContext(JAXBContext context, Class<T> objectClass, String resourceName, boolean useValidation){
		Logger.getLogger().debug("BaseJaxbUnmarshaller: Unmarshalling object of class "+objectClass.getSimpleName()+" using context");
		try{
			Unmarshaller u = context.createUnmarshaller();
			if (useValidation){
				u.setSchema(getSchema());
				u.setEventHandler(getValidationEventHandler());
			}
			JAXBElement<T> unmarshaled =
				      u.unmarshal( FileSystemHelper.readResource(resourceName), objectClass );
			Logger.getLogger().debug("BaseJaxbUnmarshaller: Unmarshalling done");
			return unmarshaled.getValue();
		} catch (JAXBException e) {
			Logger.getLogger().error(e.getClass().getSimpleName()+" occurred while unmarshalling resource '"+resourceName+"'. Null will be returned.");
			e.printStackTrace();
			return null;
		}
	}
	
	// Override if you need other implementation
	public Schema getSchema(){
		SchemaFactory factory = SchemaFactory.newInstance( "http://www.w3.org/2001/XMLSchema" );
		try {
			return factory.newSchema( new File( "src//main//resources//TimeTable.xsd" ) );
		} catch (SAXException e) {
			Logger.getLogger().warn(e.getClass().getSimpleName()+" ocurred when working with schema");
			return null;
		}
	}

	// Override if you need other implementation
	public ValidationEventHandler getValidationEventHandler(){
		return new ValidationEventHandler(){
			 public boolean handleEvent( ValidationEvent event )  {
				 Logger.getLogger().warn("XML validation error:\n"+
				    "Message: "+event.getMessage()+"\n"+
				 	"Locator: "+event.getLocator().toString() );
				    return false; 
			 }};
	}
		
}
