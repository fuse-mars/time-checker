package me.marcellin.timechecker.api.v1.time;

import java.util.Date;
import java.util.Locale;
import java.text.ParseException;

import org.springframework.format.datetime.DateFormatter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTimeModel {

	@Test()
	public void testEmailGenerator() {

		// START simulated environment
		String city = "New York";
		String stringTime = "9:30 AM";

		Date time;

		DateFormatter timeFormatter;
		TimeModel obj = null;
		try {

			timeFormatter = new DateFormatter();
			time = timeFormatter.parse(stringTime, Locale.ENGLISH);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		// INPUT city, time
		// END simulated environment

		// START system
		obj = new TimeModel(time, city);
		// END system

		Assert.assertNotNull(obj);
		Assert.assertEquals(obj.getCity(), city);
		System.out.println(obj.getTime().getHours());
		Assert.assertEquals(obj.getTime().getHours(), 9);

	}

}