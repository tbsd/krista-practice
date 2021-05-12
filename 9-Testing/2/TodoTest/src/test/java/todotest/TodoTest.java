package todotest;

import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class TodoTest {
    @Test
    public void userCanAddNotes() {
        open("http://localhost:3000");
        TodoPage page = new TodoPage();
        String noteText = "New note 1";
        page.addNote(noteText);
        page.getNotes().shouldHave(sizeGreaterThan(0));
        page.getNotes().last().shouldHave(text(noteText));
    }

    @Test
    public void userCanMarkNoteComplete() {
        open("http://localhost:3000");
        TodoPage page = new TodoPage();
        String noteText = "New note 2";
        page.addNote(noteText);
        page.markComplete(noteText);
        page.getCompletedNotes().last().shouldHave(text(noteText));
    }

    @Test
    public void userCanRemoveNotes() {
        open("http://localhost:3000");
        TodoPage page = new TodoPage();
        String noteText = "New note 3";
        page.addNote(noteText);
        page.removeNote(noteText);
        sleep(2000);
        if (!page.getNotes().isEmpty())
            page.getNotes().last().shouldNotHave(text(noteText));
    }
}

