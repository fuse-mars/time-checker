package me.marcellin.timechecker.api.v1.time;

import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTimeService {

	@Test()
	public void testTimeServiceCreation() {
		// START simulated environment
		// String queryCity = "New York";
		// String city = "Kathmandu";
		// String time = "9:30 AM";

		// END simulated environment

		TimeService ts = new TimeService();
		Assert.assertNotNull(ts);
		// ts.checkTimeByCity(queryCity, time, city);


	}

}