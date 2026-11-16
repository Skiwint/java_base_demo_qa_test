package QA_GURU;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeSimpleFormTest extends TestBase{

    private static final String BASE_URL = "https://qa-guru.github.io/one-page-form/text-box.html";

    @Test
    void fillSimpleFormTest(){
        open(BASE_URL);
        $(By.xpath("//*[@id='userName']")).setValue("Абакаров Сурхай Заурович");
        $(By.xpath("//*[@id='userEmail']")).setValue("Abakarov2512@gmail.com");
        $(By.xpath("//*[@id='currentAddress']")).setValue("Ввод произвольного актуального адреса");
        $(By.xpath("//*[@id='permanentAddress']")).setValue("Ввод произвольного постоянного адреса");

        $(By.xpath("//*[@id='submit']")).click();

        $(By.xpath("//*[@id='output']//*[@id='name']")).shouldHave(exactText("Name:Абакаров Сурхай Заурович"));
        $(By.xpath("//*[@id='output']//*[@id='email']")).shouldHave(exactText("Email:Abakarov2512@gmail.com"));
        $(By.xpath("//*[@id='output']//*[@id='currentAddress']")).shouldHave(exactText("Current Address :Ввод произвольного актуального адреса"));
        $(By.xpath("//*[@id='output']//*[@id='permanentAddress']")).shouldHave(exactText("Permananet Address :Ввод произвольного постоянного адреса"));
    }

    @Test
    void dontFillSimpleFormTest(){
        open(BASE_URL);
        $(By.xpath("//*[@id='submit']")).click();

        $(By.xpath("//*[@id='output']//*[@id='name']")).shouldHave(exactText("Name:"));
        $(By.xpath("//*[@id='output']//*[@id='email']")).shouldHave(exactText("Email:"));
        $(By.xpath("//*[@id='output']//*[@id='currentAddress']")).shouldHave(exactText("Current Address :"));
        $(By.xpath("//*[@id='output']//*[@id='permanentAddress']")).shouldHave(exactText("Permananet Address :"));
    }

}
