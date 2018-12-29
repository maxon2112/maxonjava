package adressbook.tests;


import adressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificate extends TestBase {
    @BeforeMethod
    public void ensurePreconditons() {
        if (!app.contactt().editContact()) {

            app.contactt().create(new Contact("Max", "Nemchenko", "Evropeyscii prosperct", "7981689712", "maxen_93@mail.ru", "https://vk.com", "1993", "December", "21", "test1", "Saint Peterburg", "8", "mt"));

        }
    }

         @Test(enabled = false)
        public void ModificateNewUser() {

            List<Contact> before = app.contactt().list();
             int index = before.size()-1;
             Contact contact = new Contact(before.get(index).getId(),"Misha", "Prtrov", "Evropeyscii prosperct", "7988834849595", "maxen_93@mail.ru", "https://vk.com", "1986", "July", "12", null, "Moscow", "9", "mot");
             app.contactt().modify(index, contact);
             List<Contact> after = app.contactt().list();
            Assert.assertEquals(after.size(), before.size());

            before.remove(index);
            before.add(contact);
            Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


        }



}

