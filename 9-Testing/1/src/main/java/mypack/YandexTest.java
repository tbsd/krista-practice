package mypack;

import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class YandexTest {
    @Test
    public void userCanSearch() {
        open("https://ya.ru/");
        new YandexPage().searchFor("ЯрГУ ИВТ");

        SearchResultsPage results = new SearchResultsPage();
        results.getResults().shouldHave(sizeGreaterThan(1));
        results.getResult(0).shouldHave(text("ivt.uniyar.ac.ru"));
    }
}
