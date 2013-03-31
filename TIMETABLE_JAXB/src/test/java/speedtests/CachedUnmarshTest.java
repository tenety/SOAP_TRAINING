package speedtests;

import org.junit.Test;

import com.khveras.jaxb.unmarshalling.CachedUnmarshaller;



public class CachedUnmarshTest extends BaseUnmarshTest {

	@Test
	public void checkUnmarshWithoutCaching() {
		CachedUnmarshaller unmarshaller = new CachedUnmarshaller();
		measureSpeed (unmarshaller, 10);
	}

}
