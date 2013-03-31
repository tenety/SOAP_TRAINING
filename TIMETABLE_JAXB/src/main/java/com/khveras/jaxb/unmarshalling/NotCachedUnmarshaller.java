package com.khveras.jaxb.unmarshalling;

import javax.xml.bind.JAXBContext;

import com.khveras.jaxb.utils.JaxbContextManager;

public class NotCachedUnmarshaller extends BaseJaxbUnmarshaller {
	public <T> T unmarshalObject (String resourceName, Class<T> objectClass){
			JAXBContext ctx = JaxbContextManager.forceNewContext( objectClass );
			return unmarshalUsingContext(ctx, objectClass, resourceName);
	}
}
