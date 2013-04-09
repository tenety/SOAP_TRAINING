package com.khveras.jaxws.server;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import com.khveras.jaxws.baseObjects.EditTrnDestRequest;
import com.khveras.jaxws.baseObjects.Station;
import com.khveras.jaxws.baseObjects.TimeTablePortType;
import com.khveras.jaxws.baseObjects.Trip;
import com.sun.xml.internal.ws.developer.SchemaValidation;


@SchemaValidation 
@WebService(endpointInterface = "com.khveras.jaxws.baseObjects.TimeTablePortType",
	targetNamespace = "http://www.khveras.com/TimeTableService",
	portName = "timeTableService-soap11", serviceName = "timeTableService",
	wsdlLocation = "TimeTable.wsdl")

public class TimeTableServerImpl implements TimeTablePortType {
	
	public static void main( String[] args ) {
		Endpoint.publish( "http://localhost:8081/timeTableService", new TimeTableServerImpl() );
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
