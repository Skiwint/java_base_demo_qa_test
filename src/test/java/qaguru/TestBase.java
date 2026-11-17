package qaguru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    public static final String BASE_URL = "https://demoqa.com/";
    public static final String BASE_URL_SIMPLE = "https://qa-guru.github.io/one-page-form/text-box.html";

    @BeforeAll
    public static void beforeAll(){
        Configuration.browser = "chrome";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        Configuration.browserCapabilities = options;
    }

    @AfterAll
    public static void afterEach(){
        closeWebDriver();
    }

}
