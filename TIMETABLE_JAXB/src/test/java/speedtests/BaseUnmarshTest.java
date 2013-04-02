package speedtests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.khveras.jaxb.hierarchy.Timetable;
import com.khveras.jaxb.marshalling.BaseJaxbUnmarshaller;
import com.khveras.jaxb.utils.FileSystemHelper;
import com.khveras.logging.JunitSpeedTestsListener;
import com.khveras.logging.Logger;
import com.khveras.logging.TotalItemsFactory.TotalType;

public class BaseUnmarshTest {
	public static final List<String> filesToUnmarshal =
		new ArrayList<String>(){
			private static final long serialVersionUID = -5985046905492604701L;
		{
		add ("AustralianTimeTable.xml");
		add ("EuropeanTimeTable.xml");
		add ("USATimeTable.xml");
	}};
	
	protected void measureSpeed (BaseJaxbUnmarshaller unmarshaller, int attempts, boolean useValidation){
		Logger.getLogger().testAction("Measuring average unmarshalling speed: "+attempts+" attempts.");
		long abs = Calendar.getInstance().getTimeInMillis();
		long bytes = 0;
		for (int attempt=1; attempt<=attempts; attempt++){
			Logger.getLogger().debug("Test unmarshalling: attempt "+attempt);
			for (String xmlResource: filesToUnmarshal){
				unmarshaller.unmarshalObject(xmlResource, Timetable.class, useValidation);
				bytes+=FileSystemHelper.getResourceSize(xmlResource);
			}
		}
		
		long totalSec=Calendar.getInstance().getTimeInMillis()-abs;
		Logger.getLogger().addTotalsItem(TotalType.SPEED_TEST_RESULT, JunitSpeedTestsListener.currentTestMethod, totalSec, bytes, attempts, bytes/totalSec);
	}
}
