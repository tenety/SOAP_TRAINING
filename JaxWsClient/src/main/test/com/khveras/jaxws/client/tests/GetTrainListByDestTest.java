package com.khveras.jaxws.client.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.khveras.jaxws.baseObjects.ISO3166CountyCode;
import com.khveras.jaxws.baseObjects.Station;
import com.khveras.jaxws.baseObjects.Trip;
import com.khveras.jaxws.client.exceptions.ClientOperationException;
import com.khveras.jaxws.client.impl.TimeTableClientImpl;
import com.khveras.jaxws.dataGenerators.RandomTimeTableFactory;

public class GetTrainListByDestTest {

	public static final ISO3166CountyCode IN_SERVICE_COUNTRY=ISO3166CountyCode.RU;
	
	public static final ISO3166CountyCode OUT_OF_SERVICE_COUNTRY=ISO3166CountyCode.WF;
	
	TimeTableClientImpl client;	
	
	@Before
	public void initClient(){
		client = TimeTableClientImpl.getInstance();
	}
	
	@Test
	public void getTrainsToCountryOfService() {
		Station station = RandomTimeTableFactory.createRandomStation();
		station.setCountryCode(IN_SERVICE_COUNTRY);
		Trip response = client.getTrainListByDestination(station);
		Assert.assertNotNull(ResponseMessages.RESPONSE_NOT_MATCH, response);
	}
	
	@Test (expected = ClientOperationException.class)
	public void getTrainsToOutOfServiceCountry() {
		Station station = RandomTimeTableFactory.createRandomStation();
		station.setCountryCode(OUT_OF_SERVICE_COUNTRY);
		Trip response = client.getTrainListByDestination(station);
		System.out.println(response);
	}

}
