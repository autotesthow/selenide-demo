package org.example;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class Main {
    public static void main(String[] args) {

        open("https://google.com/ncr");
        $("[name=q]").append("selenidejs");
        $("[name=q]").pressEnter();

        $$("#rso>div").shouldHave(size(9));
        $$("#rso>div").first().shouldHave(text("SelenideJS - GitHub"));
        $$("#rso>div").first().find("h3").click();

        webdriver().shouldHave(title(
                "GitHub - KnowledgeExpert/selenidejs: User-oriented Web UI browser tests in JavaScript (Selenide port to JS)"
        ));
    }
}