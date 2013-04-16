package com.khveras.jaxws.client.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.khveras.jaxws.baseObjects.EditTrnDestRequest;
import com.khveras.jaxws.client.impl.TimeTableClientImpl;
import com.khveras.jaxws.dataGenerators.RandomTimeTableFactory;

public class EditTrainDestinationTest {

	public static final String EXISTING_TRAIN_ID="trn11111";
	
	public static final String NON_EXISTING_TRAIN_ID="trn0000";
	
	TimeTableClientImpl client;	
	
	@Before
	public void initClient(){
		client = TimeTableClientImpl.getInstance();
	}
	
	@Test
	public void checkEditExistingTrain() {
		EditTrnDestRequest request = new EditTrnDestRequest (EXISTING_TRAIN_ID, RandomTimeTableFactory.createRandomStation());
		String response = client.editTrainDestination(request);
		Assert.assertEquals(ResponseMessages.RESPONSE_NOT_MATCH, ResponseMessages.OPERATION_SUCCESSFUL_MSG, response);
	}
	
	@Test
	public void checkEditNonExistingTrain() {
		EditTrnDestRequest request = new EditTrnDestRequest (NON_EXISTING_TRAIN_ID, RandomTimeTableFactory.createRandomStation());
		String response = client.editTrainDestination(request);
		Assert.assertEquals(ResponseMessages.RESPONSE_NOT_MATCH, String.format(ResponseMessages.TRAIN_NOT_FOUND_TEMPLATE, NON_EXISTING_TRAIN_ID), response);
	}

}
