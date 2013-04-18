package com.khveras.jaxws.client.impl;

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
import com.khveras.jaxws.client.exceptions.ClientOperationException;

public class TimeTableClientImpl implements TimeTablePortType {
    
	public static final String DEFAULT_URL = "http://localhost:8080/JaxWsServer-1.0/timetableservice?wsdl";
	
	public static final QName DEFAULT_QNAME = new QName("http://www.khveras.com/TimeTableService", "timeTableService");
	
	private static final Map<String, TimeTableClientImpl> cachedServices = new HashMap<String, TimeTableClientImpl>();

	private TimeTablePortType port;
	
	
	public static TimeTableClientImpl getInstance(URL wsdlLocation, QName serviceName){
		String wsIdentifier=serviceName.toString()+":"+wsdlLocation;

		if (cachedServices.containsKey(wsIdentifier)){
			return cachedServices.get(wsIdentifier);
		}
		else{
			TimeTableClientImpl newInstance;
			try{
				newInstance=new TimeTableClientImpl(createPort(wsdlLocation, serviceName));
			}
			catch (RuntimeException e){
				throw new ClientOperationException("Unable to instantiate connect to server", e);
			}
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
		try{
			return port.addTrip(addTripInputPart);
		}
		catch (Exception e){
			throw new ClientOperationException ("Unable to add trip: "+e.getMessage());
		}
	}

	public String editTrainDestination(EditTrnDestRequest editTrnDestInputPart) {
		try{
			return port.editTrainDestination(editTrnDestInputPart);
		}
		catch (Exception e){
			throw new ClientOperationException ("Unable to edit train destination: "+e.getMessage());
		}
	}

	public String addBus(Trip addBusInputPart) {
		try{
			return port.addBus(addBusInputPart);
		}
		catch (Exception e){
			throw new ClientOperationException ("Unable to add bus: "+e.getMessage());
		}
	}

	public String deleteBus(String deleteBusInputPart) {
		try{
			return port.deleteBus(deleteBusInputPart);
		}
		catch (Exception e){
			throw new ClientOperationException ("Unable to delete bus: "+e.getMessage());
		}
	}

	public Trip getTrainListByDestination(Station getTrnByDestInputPart) {
		try{
			return port.getTrainListByDestination(getTrnByDestInputPart);
		}
		catch (Exception e){
			throw new ClientOperationException ("Unable to get trains by destination station: "+e.getMessage());
		}
	}
   
    
}
