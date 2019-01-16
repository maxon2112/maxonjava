package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contact;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class ContactModificate extends TestBase {
    @BeforeMethod
    public void ensurePreconditons() {
        if (app.db().contactt().size() == 0) {
            app.goTo().goToHomePage();
            app.contactt().create(new Contact().withFirstname("max").withLastname("Nemchenko").withAdress("Evropeyscii prosperct").withHome("7981689712").withEmail("maxen_93@mail.ru").
                    withEmail("https://vk.com").withByear("1993").withBmonth("December").withBday("21").withAddress2("Saint Peterburg").withPhone2("8").withNotes("mt"));

        }
    }

         @Test
        public void ModificateNewUser() {

             Contacts before = app.db().contactt();
             Contact modifiedContact = before.iterator().next();
             Contact contact = new Contact(). withId(modifiedContact.getId()).withFirstname("Misha").withLastname("Nemo").withAdress("Slavi prosperct").withHome("7981689712").withEmail("maxen_93@mail.ru").
                     withEmail("https://vk.com").withAddress2("Moscow").withPhone2("8").withNotes("mt");

             app.contactt().modify(contact);
             app.goTo().goToHomePage();
             assertThat(app.contactt().ContactCount(), equalTo(before.size()));
             Contacts after = app.db().contactt();
             assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

        }



}

