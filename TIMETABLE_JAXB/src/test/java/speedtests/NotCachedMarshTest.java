package speedtests;

import org.junit.Test;

import com.khveras.jaxb.marshalling.BaseJaxbMarshaller;
import com.khveras.jaxb.marshalling.NotCachedMarshaller;



public class NotCachedMarshTest extends BaseMarshTest {

	public static final int NUM_OF_TEST_TIMETABLES=5;
	public static final int NUM_OF_TRIPS_IN_TIMETABLE=4;
	public static final int TEST_ATTEMPTS=10;
	
	@Test
	public void checkMarshWithoutCaching() {
		BaseJaxbMarshaller marshaller = new NotCachedMarshaller();
		measureSpeed(marshaller, NUM_OF_TEST_TIMETABLES, NUM_OF_TRIPS_IN_TIMETABLE, TEST_ATTEMPTS);
	}

}
