package speedtests;

import org.junit.Test;

import com.khveras.jaxb.marshalling.BaseJaxbUnmarshaller;
import com.khveras.jaxb.marshalling.CachedUnmarshaller;



public class CachedUnmarshTest extends BaseUnmarshTest {
	
	public static final int TEST_ATTEMPTS=12;
	public static final boolean USE_VALIDATION=false;

	@Test
	public void checkUnmarshWithCaching() {
		BaseJaxbUnmarshaller unmarshaller = new CachedUnmarshaller();
		measureSpeed (unmarshaller, TEST_ATTEMPTS, USE_VALIDATION);
	}

}
