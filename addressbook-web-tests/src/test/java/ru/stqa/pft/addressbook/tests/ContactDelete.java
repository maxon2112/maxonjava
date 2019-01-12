package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contact;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class ContactDelete extends TestBase {

    @BeforeMethod
    public void ensurePreconditons() {
        if (app.db().contactt().size() == 0) {
            app.goTo().goToHomePage();
            app.contactt().create(new Contact().withFirstname("max").withLastname("Nemchenko").withAdress("Evropeyscii prosperct").withHome("7981689712").withEmail("maxen_93@mail.ru").
                    withEmail("https://vk.com").withByear("1993").withBmonth("December").withBday("21").withGroup("test1").withAddress2("Saint Peterburg").withPhone2("8").withNotes("mt"));

        }
    }

    @Test
    public void DeleteUser() {
        Contacts before = app.db().contactt();
        Contact deleteContact = before.iterator().next();
        app.contactt().delete(deleteContact);
        Contacts after = app.db().contactt();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deleteContact)));

    }


}
