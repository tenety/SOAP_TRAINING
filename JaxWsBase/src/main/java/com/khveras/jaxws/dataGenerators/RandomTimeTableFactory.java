package com.khveras.jaxws.dataGenerators;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.khveras.jaxws.baseObjects.ISO3166CountyCode;
import com.khveras.jaxws.baseObjects.ObjectFactory;
import com.khveras.jaxws.baseObjects.Station;
import com.khveras.jaxws.baseObjects.Trip;
import com.khveras.jaxws.baseObjects.TripType;


public class RandomTimeTableFactory {
	
	public static Trip createRandomTrip(ObjectFactory of){
		Random rnd = new Random();
		Trip trip = of.createTrip();
		
		TripType tripType = TripType.values()[rnd.nextInt(TripType.values().length)];
		trip.setTripType(tripType);
		
		switch(tripType){
			case TRAIN:
				trip.setVehicleID("trn"+RandomStringUtils.randomAlphanumeric(5));
				break;
			case BUS:
				trip.setVehicleID("bus"+RandomStringUtils.randomAlphanumeric(5));
				break;
		}
	
		trip.setDepStation(createRandomStation (of, rnd));
		trip.setDestStation(createRandomStation (of, rnd));
		trip.setTimeInWay(formatTo2Digits(rnd.nextInt(24))+":"+formatTo2Digits(rnd.nextInt(60)));
		return trip;
	}
	
	//just a stub
	public static Trip createRandomTrip(){
		return createRandomTrip(new ObjectFactory());
	}
	
	private static String formatTo2Digits(int initialInt){
		if (initialInt<0){
			throw new IllegalArgumentException("Applicable for positive aguments only");
		}
		if (initialInt>99){
			throw new IllegalArgumentException("Applicable for arguments less than 100 only");
		}
		String result = Integer.toString(initialInt);
		
		if (result.length()==1){
			return "0"+result;
		}
		else {
			return result;
		}
	}
	
	
	public static Station createRandomStation(ObjectFactory of, Random rnd){
		Station station = of.createStation();
		station.setCity(RandomStringUtils.randomAlphanumeric(rnd.nextInt(5)+3));
		station.setCountryCode(ISO3166CountyCode.values()[rnd.nextInt(ISO3166CountyCode.values().length)]);
		int gmtShift=(rnd.nextInt(23)-11);
		if (gmtShift==0){
			station.setTimeZone("GMT");
		}
		else{
			station.setTimeZone("GMT"+((gmtShift>0)?"+"+gmtShift:gmtShift));
		}
		return station;
	}
	
	//just a stub
	public static Station createRandomStation(){
		return createRandomStation(new ObjectFactory(), new Random());
	}
	
}
