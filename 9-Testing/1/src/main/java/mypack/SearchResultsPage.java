package mypack;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    public ElementsCollection getResults() {
//        return $$(byClassName("serp-item"));
        return $$(".serp-item");
    }

    public SelenideElement getResult(int index) {
        return $(".serp-item", index);
    }
}