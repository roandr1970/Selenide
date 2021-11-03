

import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

class RegistrationTest {
    @Test
    void shouldApplicationForIssuingCard() {
        String meetingDate = DataGenerator.generateDate(3);
        open("http://localhost:9999");
        $("[type='text']").setValue("Москва");
        $("[type='tel']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[type='tel']").setValue(meetingDate);
        $("[name='name']").setValue("Тапочкин Вася");
        $("[name='phone']").setValue("+71111111111");
        $("[data-test-id='agreement']").click();
        $(withText("Забронировать")).click();
        $("[data-test-id='notification'] .notification__content")
                .shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(exactText("Встреча успешно забронирована на " + meetingDate));
    }
}
