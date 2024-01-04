package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FirstUITests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.timeout = 7000;
    }

    // Тест на успешный поиск
    @Test
    void successfulSearchTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".markdown-body li a[href*='SoftAssertions']").click();
        $(".markdown-body").shouldHave(text("JUnit5"));
    }

    // Тест на наведение мыши
    @Test
    void hoverTest() {
        open("https://github.com/");
        $$("button.HeaderMenu-link").findBy(text("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" + "developer platform."));
    }

    // Тест на перетаскивание элементов
    @Test
    void dragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
        $("#column-a").shouldHave(text("B"));
        //$("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
    }
}
