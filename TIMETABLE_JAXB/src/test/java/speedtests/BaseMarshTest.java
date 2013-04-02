package speedtests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;

import testdatagen.TestTimeTableFactory;

import com.khveras.jaxb.hierarchy.Timetable;
import com.khveras.jaxb.marshalling.BaseJaxbMarshaller;
import com.khveras.jaxb.utils.FileSystemHelper;
import com.khveras.logging.JunitSpeedTestsListener;
import com.khveras.logging.Logger;
import com.khveras.logging.TotalItemsFactory.TotalType;

public class BaseMarshTest {
	
	@BeforeClass
	public static void deleteTmpDir() throws IOException{
		File tmpDir = new File("src\\test\\resources\\tmp");
		Logger.getLogger().debug("Cleaning 'tmp' dir in resources folder");
		if (tmpDir.exists()){
			FileUtils.cleanDirectory(tmpDir);
		}
		else{
			tmpDir.mkdir();
		}
	}
	
	protected void measureSpeed (BaseJaxbMarshaller marshaller, int timeTablesCount, int tripsCount, int attempts){
		Logger.getLogger().testAction("Measuring average marshalling speed: "+attempts+" attempts.");
		List<Timetable> timetables = generateTestTimetables(timeTablesCount, tripsCount);
		long abs = Calendar.getInstance().getTimeInMillis();
		long bytes = 0;
		for (int attempt=1; attempt<=attempts; attempt++){
			Logger.getLogger().debug("Test marshalling: attempt "+attempt);
			for (int item=0; item< timetables.size(); item++){
				String tmpFileName="tmp\\tmp_t_t+it"+item+"_att"+attempt+".xml";
				marshaller.marshalObject(timetables.get(item), tmpFileName);
				bytes+=FileSystemHelper.getResourceFile(tmpFileName).length();
			}
		}
		
		long totalSec=Calendar.getInstance().getTimeInMillis()-abs;
		Logger.getLogger().addTotalsItem(TotalType.SPEED_TEST_RESULT, JunitSpeedTestsListener.currentTestMethod, totalSec, bytes, attempts, bytes/totalSec);
	}
	
	private List<Timetable> generateTestTimetables(int timeTablesCount, int tripsCount){
		List<Timetable> result = new ArrayList<Timetable>();
		for (int i=0; i<timeTablesCount; i++){
			result.add(TestTimeTableFactory.generateRandomTimetable(tripsCount));
		}
		return result;
	}
}
