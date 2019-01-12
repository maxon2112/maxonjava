package ru.stqa.pft.adressbook.tests;

import ru.stqa.pft.adressbook.model.Contact;
import ru.stqa.pft.adressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class ContactDelete extends TestBase {

    @BeforeMethod
    public void ensurePreconditons() {
        if (!app.contactt().editContact()) {

            app.contactt().create(new Contact().withFirstname("max").withLastname("Nemchenko").withAdress("Evropeyscii prosperct").withHome("7981689712").withEmail("maxen_93@mail.ru").
                    withEmail("https://vk.com").withByear("1993").withBmonth("December").withBday("21").withGroup("test1").withAddress2("Saint Peterburg").withPhone2("8").withNotes("mt"));

        }
    }

    @Test
    public void DeleteUser() {
        Contacts before = app.contactt().all();
        Contact deleteContact = before.iterator().next();
        app.contactt().delete(deleteContact);
        Contacts after = app.contactt().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deleteContact)));

    }


}
