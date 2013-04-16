package com.khveras.jaxws.client.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.khveras.jaxws.baseObjects.Station;
import com.khveras.jaxws.baseObjects.Trip;
import com.khveras.jaxws.baseObjects.TripType;
import com.khveras.jaxws.client.exceptions.ClientOperationException;
import com.khveras.jaxws.client.impl.TimeTableClientImpl;
import com.khveras.jaxws.dataGenerators.RandomTimeTableFactory;

public class AddTripTest {

	TimeTableClientImpl client;	
	
	@Before
	public void initClient(){
		client = TimeTableClientImpl.getInstance();
	}
	
	@Test
	public void checkValidRequest() {
		Trip validTrip = RandomTimeTableFactory.createRandomTrip();
		while (validTrip.getDepStation().equals(validTrip.getDestStation())){
			validTrip.setDepStation(RandomTimeTableFactory.createRandomStation());
		}
		validTrip.setTripType(TripType.TRAIN);
		
		String response = client.addTrip(validTrip);
		Assert.assertEquals(ResponseMessages.RESPONSE_NOT_MATCH, ResponseMessages.OPERATION_SUCCESSFUL_MSG, response);

	}
	
	@Test
	public void checkSameStationsRequest() {
		Trip inValidTrip = RandomTimeTableFactory.createRandomTrip();
		inValidTrip.setDepStation(inValidTrip.getDestStation());
		inValidTrip.setTripType(TripType.BUS);
		
		String response = client.addTrip(inValidTrip);
		Assert.assertEquals(ResponseMessages.RESPONSE_NOT_MATCH, ResponseMessages.SAME_STATIONS_FORBIDDEN+inValidTrip.getDestStation(), response);
	}
	
	@Test (expected= ClientOperationException.class)
	public void checkInvalidTzRequest() {
		Trip inValidTrip = RandomTimeTableFactory.createRandomTrip();
		Station station = RandomTimeTableFactory.createRandomStation();
		station.setTimeZone("GMTd");
		inValidTrip.setDestStation(station);
		
		String response = client.addTrip(inValidTrip);
		Assert.assertEquals(ResponseMessages.RESPONSE_NOT_MATCH, ResponseMessages.SAME_STATIONS_FORBIDDEN+inValidTrip.getDestStation(), response);
	}

}
