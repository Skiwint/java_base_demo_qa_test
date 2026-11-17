package qaguru;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PraticeFormTest extends TestBase{

    @Test
    void fillAllFormsOnThePageTest(){
        open(BASE_URL + "automation-practice-form");
        $("#firstName").setValue("Сурхай");
        $("#lastName").setValue("Абакаров");
        $("#userEmail").setValue("Abakarov2512@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9055268389");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("2002");
        $(".react-datepicker__month[aria-label='Month December, 2002']")
                .$$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(text("25")).click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFromClasspath("photo_2026-10-12_15-47-51.jpg");
        $("#currentAddress").setValue("Рандомный адрес в Москве ... ");
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Noida")).click();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text("Сурхай Абакаров"));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text("Abakarov2512@gmail.com"));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text("9055268389"));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text("25 December,2002"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text("Computer Science"));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text("photo_2026-10-12_15-47-51.jpg"));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text("Рандомный адрес в Москве ... "));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text("NCR Noida"));
    }

    @Test
    void fillOnlyNecessaryFormsTest(){
        open(BASE_URL + "automation-practice-form");
        $("#firstName").setValue("Сурхай");
        $("#lastName").setValue("Абакаров");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("9055268389");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("2002");
        $(".react-datepicker__month[aria-label='Month December, 2002']")
                .$$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(text("25")).click();

        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text("Сурхай Абакаров"));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text("9055268389"));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text("25 December,2002"));
    }

    @Test
    void fillWongWayPhoneTest(){
        open(BASE_URL + "automation-practice-form");
        $("#firstName").setValue("Сурхай");
        $("#lastName").setValue("Абакаров");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("905526838");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("2002");
        $(".react-datepicker__month[aria-label='Month December, 2002']")
                .$$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(text("25")).click();

        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldBe(hidden);
    }

    @Test
    void fillFormWithoutFirstAndLastNameTest(){
        open(BASE_URL + "automation-practice-form");

        $("#gender-radio-1").click();
        $("#userNumber").setValue("9055268389");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("2002");
        $(".react-datepicker__month[aria-label='Month December, 2002']")
                .$$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(text("25")).click();

        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldBe(hidden);
    }

    @Test
    void fillFormWithoutGenderTest(){
        open(BASE_URL + "automation-practice-form");
        $("#firstName").setValue("Сурхай");
        $("#lastName").setValue("Абакаров");
        $("#userNumber").setValue("9055268389");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("2092");
        $(".react-datepicker__month[aria-label='Month December, 2092']")
                .$$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(text("25")).click();

        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldBe(hidden);
    }
}
