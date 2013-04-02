package testdatagen;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.khveras.jaxb.hierarchy.ISO3166CountyCode;
import com.khveras.jaxb.hierarchy.ObjectFactory;
import com.khveras.jaxb.hierarchy.Station;
import com.khveras.jaxb.hierarchy.Timetable;
import com.khveras.jaxb.hierarchy.Trip;
import com.khveras.jaxb.hierarchy.TripType;


public class TestTimeTableFactory {
	public static Timetable generateRandomTimetable (int tripsCount){
		ObjectFactory of = new ObjectFactory();
		
		Timetable result = of.createTimetable();
		result.setRegion(RandomStringUtils.randomAlphanumeric(6));
		for (int i=0; i<tripsCount; i++){
			result.addTrip(createRandomTrip(of));
		}
		
		return result;
	}
	
	private static Trip createRandomTrip(ObjectFactory of){
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
	
	
	private static Station createRandomStation(ObjectFactory of, Random rnd){
		Station station = of.createStation();
		station.setCity(RandomStringUtils.randomAlphanumeric(rnd.nextInt(5)+3));
		station.setCountryCode(ISO3166CountyCode.values()[rnd.nextInt(ISO3166CountyCode.values().length)]);
		int gmtShift=(rnd.nextInt(23)-11);
		station.setTimeZone("GMT"+((gmtShift==0)?"":gmtShift));
		return station;
	}
	
	
}
