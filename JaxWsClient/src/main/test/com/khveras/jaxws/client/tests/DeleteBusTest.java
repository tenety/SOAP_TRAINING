package com.khveras.jaxws.client.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.khveras.jaxws.client.impl.TimeTableClientImpl;

public class DeleteBusTest {

	public static final String EXISTING_BUS_ID="bus22222";
	
	public static final String NON_EXISTING_BUS_ID="bus0000";
	
	TimeTableClientImpl client;	
	
	@Before
	public void initClient(){
		client = TimeTableClientImpl.getInstance();
	}
	
	@Test
	public void checkDeleteExistingBus() {
		String response = client.deleteBus(EXISTING_BUS_ID);
		Assert.assertEquals(ResponseMessages.RESPONSE_NOT_MATCH, ResponseMessages.OPERATION_SUCCESSFUL_MSG, response);
	}
	
	@Test
	public void checkDeleteNonExistingBus() {
		String response = client.deleteBus(NON_EXISTING_BUS_ID);
		Assert.assertEquals(ResponseMessages.RESPONSE_NOT_MATCH, String.format(ResponseMessages.NOT_A_BUS_TRIP_TEMPLATE, NON_EXISTING_BUS_ID), response);
	}

}
