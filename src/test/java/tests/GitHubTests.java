package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void checkWikiForJunit() {
        open("https://github.com/");

        $("[data-unscoped-placeholder='Search GitHub']").setValue("selenide").pressEnter();
        $("[href='/selenide/selenide']").click();
        $("[data-content='Wiki']").click();
        $("[data-filterable-for='wiki-pages-filter']").$(byText("SoftAssertions")).click();

        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
