package me.marcellin.timechecker.api.v1.time;

import java.util.Date;
import java.util.Locale;
import java.text.ParseException;

import org.springframework.format.datetime.DateFormatter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTimeService {

	@Test()
	public void testEmailGenerator() {

		String city = "New York";
		DateFormatter timeFormatter;
		Date time = null;
		TimeModel obj = null;
		try {

			timeFormatter = new DateFormatter();
			time = timeFormatter.parse("9:30 AM", Locale.ENGLISH);

			obj = new TimeModel(time, city);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		Assert.assertNotNull(obj);
		Assert.assertEquals(obj.getCity(), city);
		System.out.println(obj.getTime().getHours());
		Assert.assertEquals(obj.getTime().getHours(), 9);

	}

}