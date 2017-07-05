package me.marcellin.timechecker.api.v1.time;

import java.time.LocalDateTime;

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
		int expectedHrs = 9;
		int expectedMins = 30;
		String stringTime = expectedHrs+":"+expectedMins+":00 AM"; // => "9:30:00 AM";

		LocalDateTime time = TimeManipulator.stringToTime(stringTime);

		// END simulated environment


		// START system
		TimeModel obj = new TimeModel(time, city);
		System.out.println(obj.toString());
		// END system

		Assert.assertNotNull(obj);
		Assert.assertEquals(obj.getCity(), city);
		Assert.assertEquals(obj.getTime().getHour(), expectedHrs);
		Assert.assertEquals(obj.getTime().getMinute(), expectedMins);

	}

}