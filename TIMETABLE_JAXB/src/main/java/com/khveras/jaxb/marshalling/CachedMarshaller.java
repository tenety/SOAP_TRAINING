package com.khveras.jaxb.marshalling;

import javax.xml.bind.JAXBContext;

import com.khveras.jaxb.utils.JaxbContextManager;

public class CachedMarshaller extends BaseJaxbMarshaller {

	@Override
	public void marshalObject(Object object, String resourceName) {
		JAXBContext ctx = JaxbContextManager.getContext(object.getClass());
		marshalUsingContext(ctx, object, resourceName);
	}

}
