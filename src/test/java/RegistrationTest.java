

import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

class RegistrationTest {
    @Test
    void shouldApplicationForIssuingCard() {
        DataGenerator generator = new DataGenerator();
        String data = generator.dataGenerator(3);
        open("http://localhost:9999");
        $("[type='text']").setValue("Москва");
        $("[type='tel']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[type='tel']").setValue(data);
        $("[name='name']").setValue("Тапочкин Вася");
        $("[name='phone']").setValue("+71111111111");
        $("[data-test-id='agreement']").click();
        $(withText("Забронировать")).click();
        String text = "Встреча успешно забронирована на";
        String text2 = data;
        $(withText(text)).shouldBe(appear, Duration.ofSeconds(15));
        $(withText(text2)).shouldBe(appear);
    }
}
