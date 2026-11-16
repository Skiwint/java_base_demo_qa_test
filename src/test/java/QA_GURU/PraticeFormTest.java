package QA_GURU;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Scanner;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PraticeFormTest extends TestBase{

    private static final String BASE_URL = "https://demoqa.com/";

    @Test
    void fillAllFormsOnThePageTest(){
        open(BASE_URL + "automation-practice-form");
        $(By.xpath("//*[@id='firstName']")).setValue("Сурхай");
        $(By.xpath("//*[@id='lastName']")).setValue("Абакаров");
        $(By.xpath("//*[@id='userEmail']")).setValue("Abakarov2512@gmail.com");
        $(By.xpath("//*[@id='gender-radio-1']")).click();
        $(By.xpath("//*[@id='userNumber']")).setValue("9055268389");
        $(By.xpath("//*[@id='dateOfBirthInput']")).click();
        $(By.xpath("//*[@class='react-datepicker__month-select']")).selectOption("December");
        $(By.xpath("//*[@class='react-datepicker__year-select']")).selectOption("2002");
        $(By.xpath("//*[contains(@class, 'react-datepicker__month') and @aria-label='Month December, 2002'] " +
                "//*[contains(@class, 'react-datepicker__day')" +
                " and not(contains(@class, 'react-datepicker__day--outside-month'))\n" +
                " and normalize-space(.)='25']")).click();
        $(By.xpath("//*[@id='subjectsInput']")).setValue("Computer Science").pressEnter();
        $(By.xpath("//*[@id='hobbies-checkbox-1']")).click();
        $(By.xpath("//*[@id='uploadPicture']")).uploadFile(new File("src/test/resources/photo_2026-10-12_15-47-51.jpg"));
        $(By.xpath("//*[@id='currentAddress']")).setValue("Рандомный адрес в Москве ... ");
        $(By.xpath("//*[@id='state']")).click();
        $(By.xpath("//*[@id='state']")).$(byText("NCR")).click();
        $(By.xpath("//*[@id='city']")).click();
        $(By.xpath("//*[@id='city']")).$(byText("Noida")).click();
        $(By.xpath("//*[@id='submit']")).click();


        $(By.xpath("//*[@id='example-modal-sizes-title-lg']")).shouldHave(text("Thanks for submitting the form"));
        $$("table.table tbody tr")
                .findBy(text("Student Name"))
                .$$("td").get(1)
                .shouldHave(text("Сурхай Абакаров"));

        $$("table.table tbody tr")
                .findBy(text("Student Email"))
                .$$("td").get(1)
                .shouldHave(text("Abakarov2512@gmail.com"));

        $$("table.table tbody tr")
                .findBy(text("Gender"))
                .$$("td").get(1)
                .shouldHave(text("Male"));

        $$("table.table tbody tr")
                .findBy(text("Mobile"))
                .$$("td").get(1)
                .shouldHave(text("9055268389"));

        $$("table.table tbody tr")
                .findBy(text("Date of Birth"))
                .$$("td").get(1)
                .shouldHave(text("25 December,2002"));

        $$("table.table tbody tr")
                .findBy(text("Subjects"))
                .$$("td").get(1)
                .shouldHave(text("Computer Science"));

        $$("table.table tbody tr")
                .findBy(text("Hobbies"))
                .$$("td").get(1)
                .shouldHave(text("Sports"));

        $$("table.table tbody tr")
                .findBy(text("Picture"))
                .$$("td").get(1)
                .shouldHave(text("photo_2026-10-12_15-47-51.jpg"));

        $$("table.table tbody tr")
                .findBy(text("Address"))
                .$$("td").get(1)
                .shouldHave(text("Рандомный адрес в Москве ... "));

        $$("table.table tbody tr")
                .findBy(text("State and City"))
                .$$("td").get(1)
                .shouldHave(text("NCR Noida"));
    }

    @Test
    void fillOnlyNecessaryFormsTest(){
        open(BASE_URL + "automation-practice-form");
        $(By.xpath("//*[@id='firstName']")).setValue("Сурхай");
        $(By.xpath("//*[@id='lastName']")).setValue("Абакаров");
        $(By.xpath("//*[@id='gender-radio-1']")).click();
        $(By.xpath("//*[@id='userNumber']")).setValue("9055268389");
        $(By.xpath("//*[@id='dateOfBirthInput']")).click();
        $(By.xpath("//*[@class='react-datepicker__month-select']")).selectOption("December");
        $(By.xpath("//*[@class='react-datepicker__year-select']")).selectOption("2002");
        $(By.xpath("//*[contains(@class, 'react-datepicker__month') and @aria-label='Month December, 2002'] " +
                "//*[contains(@class, 'react-datepicker__day')" +
                " and not(contains(@class, 'react-datepicker__day--outside-month'))\n" +
                " and normalize-space(.)='25']")).click();

        $(By.xpath("//*[@id='submit']")).click();


        $(By.xpath("//*[@id='example-modal-sizes-title-lg']")).shouldHave(text("Thanks for submitting the form"));
        $$("table.table tbody tr")
                .findBy(text("Student Name"))
                .$$("td").get(1)
                .shouldHave(text("Сурхай Абакаров"));
        $$("table.table tbody tr")
                .findBy(text("Gender"))
                .$$("td").get(1)
                .shouldHave(text("Male"));

        $$("table.table tbody tr")
                .findBy(text("Mobile"))
                .$$("td").get(1)
                .shouldHave(text("9055268389"));

        $$("table.table tbody tr")
                .findBy(text("Date of Birth"))
                .$$("td").get(1)
                .shouldHave(text("25 December,2002"));
    }

    @Test
    void fillWongWayPhoneTest(){
        open(BASE_URL + "automation-practice-form");
        $(By.xpath("//*[@id='firstName']")).setValue("Сурхай");
        $(By.xpath("//*[@id='lastName']")).setValue("Абакаров");
        $(By.xpath("//*[@id='gender-radio-1']")).click();
        $(By.xpath("//*[@id='userNumber']")).setValue("905526838");
        $(By.xpath("//*[@id='dateOfBirthInput']")).click();
        $(By.xpath("//*[@class='react-datepicker__month-select']")).selectOption("December");
        $(By.xpath("//*[@class='react-datepicker__year-select']")).selectOption("2002");
        $(By.xpath("//*[contains(@class, 'react-datepicker__month') and @aria-label='Month December, 2002'] " +
                "//*[contains(@class, 'react-datepicker__day')" +
                " and not(contains(@class, 'react-datepicker__day--outside-month'))\n" +
                " and normalize-space(.)='25']")).click();

        $(By.xpath("//*[@id='submit']")).click();
        $(By.xpath("//*[@id='example-modal-sizes-title-lg']")).shouldBe(hidden);
    }

    @Test
    void fillFormWithoutFirstAndLastNameTest(){
        open(BASE_URL + "automation-practice-form");

        $(By.xpath("//*[@id='gender-radio-1']")).click();
        $(By.xpath("//*[@id='userNumber']")).setValue("9055268389");
        $(By.xpath("//*[@id='dateOfBirthInput']")).click();
        $(By.xpath("//*[@class='react-datepicker__month-select']")).selectOption("December");
        $(By.xpath("//*[@class='react-datepicker__year-select']")).selectOption("2002");
        $(By.xpath("//*[contains(@class, 'react-datepicker__month') and @aria-label='Month December, 2002'] " +
                "//*[contains(@class, 'react-datepicker__day')" +
                " and not(contains(@class, 'react-datepicker__day--outside-month'))\n" +
                " and normalize-space(.)='25']")).click();

        $(By.xpath("//*[@id='submit']")).click();
        $(By.xpath("//*[@id='example-modal-sizes-title-lg']")).shouldBe(hidden);
    }

    @Test
    void fillFormWithoutGenderTest(){
        open(BASE_URL + "automation-practice-form");
        $(By.xpath("//*[@id='firstName']")).setValue("Сурхай");
        $(By.xpath("//*[@id='lastName']")).setValue("Абакаров");
        $(By.xpath("//*[@id='userNumber']")).setValue("9055268389");
        $(By.xpath("//*[@id='dateOfBirthInput']")).click();
        $(By.xpath("//*[@class='react-datepicker__month-select']")).selectOption("December");
        $(By.xpath("//*[@class='react-datepicker__year-select']")).selectOption("2092");
        $(By.xpath("//*[contains(@class, 'react-datepicker__month') and @aria-label='Month December, 2092'] " +
                "//*[contains(@class, 'react-datepicker__day')" +
                " and not(contains(@class, 'react-datepicker__day--outside-month'))\n" +
                " and normalize-space(.)='25']")).click();

        $(By.xpath("//*[@id='submit']")).click();
        $(By.xpath("//*[@id='example-modal-sizes-title-lg']")).shouldBe(hidden);
    }
}
