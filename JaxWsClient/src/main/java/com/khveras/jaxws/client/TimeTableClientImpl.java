package com.khveras.jaxws.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import com.khveras.jaxws.baseObjects.BaseTimeTableService;
import com.khveras.jaxws.baseObjects.EditTrnDestRequest;
import com.khveras.jaxws.baseObjects.Station;
import com.khveras.jaxws.baseObjects.TimeTablePortType;
import com.khveras.jaxws.baseObjects.Trip;

public class TimeTableClientImpl implements TimeTablePortType {
    
	public static final String DEFAULT_URL = "http://localhost:8080/timeTableService?wsdl";
	
	public static final QName DEFAULT_QNAME = new QName("http://www.khveras.com/TimeTableService", "timeTableService");
	
	private static final Map<String, TimeTableClientImpl> cachedServices = new HashMap<String, TimeTableClientImpl>();

	private TimeTablePortType port;
	
	
	public static TimeTableClientImpl getInstance(URL wsdlLocation, QName serviceName){
		String wsIdentifier=serviceName.toString()+":"+wsdlLocation;

		if (cachedServices.containsKey(wsIdentifier)){
			return cachedServices.get(wsIdentifier);
		}
		else{
			TimeTableClientImpl newInstance=new TimeTableClientImpl(createPort(wsdlLocation, serviceName));
			cachedServices.put(wsIdentifier, newInstance);
			return newInstance;
		}
	}
	
	public static TimeTableClientImpl getInstance() {
		try {
			return getInstance(new URL(DEFAULT_URL), DEFAULT_QNAME);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Unable to create service instance", e);
		}
	}
	
	private TimeTableClientImpl(){}
	
	private TimeTableClientImpl(TimeTablePortType port){
		this.port=port;
	}
	
	
	private static TimeTablePortType createPort(URL wsdlLocation, QName serviceName){
		return new BaseTimeTableService(wsdlLocation, serviceName).getTimeTableServiceSoap11();
    }
	
	public String addTrip(Trip addTripInputPart) {
		// TODO Auto-generated method stub
		return null;
	}

	public String editTrainDestination(EditTrnDestRequest editTrnDestInputPart) {
		// TODO Auto-generated method stub
		return null;
	}

	public String addBus(Trip addBusInputPart) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteBus(String deleteBusInputPart) {
		// TODO Auto-generated method stub
		return null;
	}

	public Trip getTrainListByDestination(Station getTrnByDestInputPart) {
		// TODO Auto-generated method stub
		return null;
	}
   
    
}
