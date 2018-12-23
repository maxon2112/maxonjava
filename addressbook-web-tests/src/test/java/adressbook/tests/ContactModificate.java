package adressbook.tests;


import adressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificate extends TestBase {


        @Test
        public void ModificateNewUser() {



            if (! app.getContactHelper().editContact()){

                app.getContactHelper().createContact(new Contact("Max", "Nemchenko", "Evropeyscii prosperct", "7981689712", "maxen_93@mail.ru", "https://vk.com", "1993", "December", "21", "test1", "Saint Peterburg", "8", "mt"));

            }

            List<Contact> before = app.getContactHelper().getContactList();
            app.getContactHelper().editUserPage (before.size()-1 );
            Contact contact = new Contact(before.get(before.size() - 1).getId(),"Misha", "Prtrov", "Evropeyscii prosperct", "7988834849595", "maxen_93@mail.ru", "https://vk.com", "1986", "July", "12", null, "Moscow", "9", "mot");
            app.getContactHelper().FillUserForm(contact,false);
            app.getContactHelper().returnToHomePage();
            List<Contact> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size());

            before.remove(before.size() - 1);
            before.add(contact);
            Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


        }


    }

