package com.khveras.jaxws.validators;

import com.khveras.jaxws.baseObjects.EditTrnDestRequest;
import com.khveras.jaxws.baseObjects.ISO3166CountyCode;
import com.khveras.jaxws.baseObjects.Station;
import com.khveras.jaxws.baseObjects.Trip;
import com.khveras.jaxws.dataGenerators.RandomTimeTableFactory;

public class BaseOperationsValidator {
	public static final String OPERATION_SUCCESSFUL_MSG = "Operation was successful";
	
	public static String validateAddTrip (Trip trip){
		if (trip.getDepStation().equals(trip.getDestStation())){
			return "Departure station should differ from destination station: "+trip.getDestStation();
		}
		else{
			return OPERATION_SUCCESSFUL_MSG;
		}
	}
	
	public static String validateEditTrainDestination (EditTrnDestRequest editTrnDestRequest){
		if (editTrnDestRequest.getTrnID().equals("trn11111")){
			return OPERATION_SUCCESSFUL_MSG;
		}
		else{
			return "Train with id="+editTrnDestRequest.getTrnID()+" was not found";
		}
	}
	
	public static String validateAddBus (Trip trip){
		if (trip.getDepStation().equals(trip.getDestStation())){
			return "Departure station should differ from destination station: "+trip.getDestStation();
		}
		else{
			return OPERATION_SUCCESSFUL_MSG;
		}
	}
	
	public static String validateDeleteBus (String tripId){
		if (tripId.equals("bus22222")){
			return OPERATION_SUCCESSFUL_MSG;
		}
		else{
			return "Trip with id="+tripId+" is not a bus.";
		}
	}
	
	public static Trip validateGetTrainListByDestination(Station station) {
		if (station.getCountryCode().equals(ISO3166CountyCode.WF)){
			throw new InvalidDestinationException("Trains don't go to "+station.getCountryCode());
		}
		else{
			return RandomTimeTableFactory.createRandomTrip();
		}
	}
	
}
