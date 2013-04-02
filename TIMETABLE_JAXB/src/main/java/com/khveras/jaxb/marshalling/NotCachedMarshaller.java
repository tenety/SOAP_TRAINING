package com.khveras.jaxb.marshalling;

import javax.xml.bind.JAXBContext;

import com.khveras.jaxb.utils.JaxbContextManager;

public class NotCachedMarshaller extends BaseJaxbMarshaller {

	@Override
	public void marshalObject(Object object, String resourceName) {
		JAXBContext ctx = JaxbContextManager.forceNewContext(object.getClass());
		marshalUsingContext(ctx, object, resourceName);
	}

}
