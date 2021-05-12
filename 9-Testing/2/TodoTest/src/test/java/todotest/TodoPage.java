package todotest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TodoPage {
    public void addNote(String text) {
        $(byClassName("form-control")).val(text).pressEnter();
    }

    public ElementsCollection getNotes() {
        return $$(byClassName("item"));
    }

    public void markComplete(String text) {
        $(byText(text)).parent().find(byTagName("button")).click();
    }

    public ElementsCollection getCompletedNotes() {
        return $$(byClassName("completed"));
    }

    public void removeNote(String text) {
        $(byText(text)).parent().find(byClassName("remove"))
                .find(byTagName("button")).click();
    }

}
