package speedtests;

import org.junit.Test;

import com.khveras.jaxb.unmarshalling.NotCachedUnmarshaller;



public class NotCachedUnmarshTest extends BaseUnmarshTest {

	@Test
	public void checkUnmarshWithoutCaching() {
		NotCachedUnmarshaller unmarshaller = new NotCachedUnmarshaller();
		measureSpeed (unmarshaller, 10);
	}

}
