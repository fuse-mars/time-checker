package me.marcellin.timechecker.api.v1.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// import java.util.Date;
// import java.util.Locale;
// import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import me.marcellin.timechecker.util.TimeManipulator;

public class TestTimeModel {

	@Test()
	public void testModelCreation() {

		// START simulated environment
		// INPUT city, time		
		String city = "New York";
		String expectedTime = "9:30 AM";

		LocalDateTime time = TimeManipulator.stringToTime(expectedTime);

		// END simulated environment


		// START system
		TimeModel obj = new TimeModel(time, city);
				System.err.printf("[model] <%s>\n", obj);

		// END system

		Assert.assertNotNull(obj);
		Assert.assertEquals(obj.getCity(), city);
		Assert.assertEquals(obj.toTimeString(), expectedTime);

	}

}