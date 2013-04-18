package com.khveras.jaxws.server;

import javax.jws.WebService;

import com.khveras.jaxws.baseObjects.EditTrnDestRequest;
import com.khveras.jaxws.baseObjects.Station;
import com.khveras.jaxws.baseObjects.TimeTablePortType;
import com.khveras.jaxws.baseObjects.Trip;
import com.khveras.jaxws.validators.BaseOperationsValidator;



 
@WebService(endpointInterface = "com.khveras.jaxws.baseObjects.TimeTablePortType",
	targetNamespace = "http://www.khveras.com/TimeTableService",
	portName = "timeTableService-soap11", serviceName = "timeTableService",
	wsdlLocation = "TimeTable.wsdl")
//@SchemaValidation
public class TimeTableServerImpl implements TimeTablePortType {
	
//	public static void main( String[] args ) {
//		Endpoint.publish( "http://localhost:8082/timeTableService", new TimeTableServerImpl() );
//		Logger.getLogger().debug("Server started");
//	}

	public String addTrip(Trip addTripInputPart) {
		return BaseOperationsValidator.validateAddTrip(addTripInputPart);
	}

	public String editTrainDestination(EditTrnDestRequest editTrnDestInputPart) {
		return BaseOperationsValidator.validateEditTrainDestination(editTrnDestInputPart);
	}

	public String addBus(Trip addBusInputPart) {
		return BaseOperationsValidator.validateAddBus(addBusInputPart);
	}

	public String deleteBus(String deleteBusInputPart) {
		return BaseOperationsValidator.validateDeleteBus(deleteBusInputPart);
	}

	public Trip getTrainListByDestination(Station getTrnByDestInputPart) {
		return BaseOperationsValidator.validateGetTrainListByDestination(getTrnByDestInputPart);
	}

}
