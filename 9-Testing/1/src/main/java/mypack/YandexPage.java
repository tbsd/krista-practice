package mypack;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class YandexPage {
    public void searchFor(String text) {
        $(By.name("text")).val(text).pressEnter();
    }
}
