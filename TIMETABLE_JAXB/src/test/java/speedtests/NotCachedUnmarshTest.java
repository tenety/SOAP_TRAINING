package speedtests;

import org.junit.Test;

import com.khveras.jaxb.marshalling.BaseJaxbUnmarshaller;
import com.khveras.jaxb.marshalling.NotCachedUnmarshaller;



public class NotCachedUnmarshTest extends BaseUnmarshTest {

	public static final int TEST_ATTEMPTS=10;
	public static final boolean USE_VALIDATION=false;
	
	@Test
	public void checkUnmarshWithoutCaching() {
		BaseJaxbUnmarshaller unmarshaller = new NotCachedUnmarshaller();
		measureSpeed (unmarshaller, TEST_ATTEMPTS, USE_VALIDATION);
	}

}
