import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataGenerator {
    public String dataGenerator(int day) {
        LocalDate date = LocalDate.now();
        date = date.plusDays(day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String data = date.format(formatter);
        return data;
    }

}
