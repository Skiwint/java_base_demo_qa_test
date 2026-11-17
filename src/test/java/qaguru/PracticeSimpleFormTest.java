package qaguru;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeSimpleFormTest extends TestBase{

    @Test
    void fillSimpleFormTest(){
        open(BASE_URL_SIMPLE);
        $("#userName").setValue("Абакаров Сурхай Заурович");
        $("#userEmail").setValue("Abakarov2512@gmail.com");
        $("#currentAddress").setValue("Ввод произвольного актуального адреса");
        $("#permanentAddress").setValue("Ввод произвольного постоянного адреса");

        $("#submit").click();

        $("#output #name").shouldHave(exactText("Name:Абакаров Сурхай Заурович"));
        $("#output #email").shouldHave(exactText("Email:Abakarov2512@gmail.com"));
        $("#output #currentAddress").shouldHave(exactText("Current Address :Ввод произвольного актуального адреса"));
        $("#output #permanentAddress").shouldHave(exactText("Permananet Address :Ввод произвольного постоянного адреса"));
    }

    @Test
    void dontFillSimpleFormTest(){
        open(BASE_URL_SIMPLE);
        $("#submit").click();

        $("#output #name").shouldHave(exactText("Name:"));
        $("#output #email").shouldHave(exactText("Email:"));
        $("#output #currentAddress").shouldHave(exactText("Current Address :"));
        $("#output #permanentAddress").shouldHave(exactText("Permananet Address :"));
    }

}
