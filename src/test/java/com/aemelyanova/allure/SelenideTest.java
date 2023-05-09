package com.aemelyanova.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    @DisplayName("Тест с Listener (без step)")
    public void testIssueSearch() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("aemelyanova/");
        $(".header-search-input").submit();
        $(linkText("aemelyanova/allure_reports")).click();
        $("#repository-container-header").shouldHave(text("Issues"));
    }
}
