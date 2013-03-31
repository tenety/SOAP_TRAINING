package speedtests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.khveras.jaxb.hierarchy.Timetable;
import com.khveras.jaxb.unmarshalling.BaseJaxbUnmarshaller;
import com.khveras.jaxb.utils.FileSystemHelper;

public class BaseUnmarshTest {
	public static final List<String> filesToUnmarshal =
		new ArrayList<String>(){
			private static final long serialVersionUID = -5985046905492604701L;
		{
		add ("AustralianTimeTable.xml");
		add ("EuropeanTimeTable.xml");
		add ("USATimeTable.xml");
	}};
	
	protected void measureSpeed (BaseJaxbUnmarshaller unmarshaller, int attempts){
		System.out.println("Measuring average unmarshalling speed: "+attempts+" attempts.");
		long abs = Calendar.getInstance().getTimeInMillis();
		long bytes = 0;
		for (int attempt=1; attempt<=attempts; attempt++){
			System.out.println("Test unmarshalling: attempt "+attempt);
			for (String xmlResource: filesToUnmarshal){
				unmarshaller.unmarshalObject(xmlResource, Timetable.class);
				bytes+=FileSystemHelper.getFileSize(xmlResource);
			}
		}
		
		long totalSec=Calendar.getInstance().getTimeInMillis()-abs;
		System.out.println("Average unmarshalling time: "+totalSec/attempts+" msec for total bytes: "+bytes);
		System.out.println("Average speed: "+bytes/totalSec+" kb/sec");
	}
}
