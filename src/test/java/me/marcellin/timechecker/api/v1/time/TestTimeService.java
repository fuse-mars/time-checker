package me.marcellin.timechecker.api.v1.time;


import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTimeService {

	@Test()
	public void testTimeServiceCreation() {
		// START simulated environment
		String queryCity = "Kathmandu";
		String city = "New York";
		String time = "9:30 AM";

		String expectedTime = "7:15 PM";
		// END simulated environment

		TimeService ts = new TimeService();
		TimeModel tm = ts.checkTimeByCity(queryCity, time, city);
		
		System.err.printf("[service] <%s>\n", tm.toTimeString());
		Assert.assertNotNull(ts);
		Assert.assertEquals(tm.getCity(), queryCity);
		Assert.assertEquals(tm.toTimeString(), expectedTime);

	}

}