import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestDate2 {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss a");


        LocalDateTime dateNow = LocalDateTime.now();
        System.out.println("Before : " + dateNow.format(formatter));

        String now = "9:30:12 AM";

        LocalTime formatTime = LocalTime.parse(now, formatter);

        dateNow = dateNow.withHour(formatTime.getHour());
        dateNow = dateNow.withMinute(formatTime.getMinute());
        dateNow = dateNow.withSecond(formatTime.getSecond());


        System.out.println("After : " + dateNow.format(formatter));


    }
}
