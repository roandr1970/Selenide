

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

class RegistrationTest {
    @Test
    void shouldApplicationForIssuingCard() {
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();
        String data = dayOfMonth + "." + month + "." + year;

        open("http://localhost:9999");
        $("[type='text']").setValue("Москва");
        $("[type='tel']").setValue(data);
        $("[name='name']").setValue("Тапочкин Вася");
        $("[name='phone']").setValue("+71111111111");
        $("[data-test-id='agreement']").click();
        $(withText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(appear, Duration.ofSeconds(15));
    }
}
