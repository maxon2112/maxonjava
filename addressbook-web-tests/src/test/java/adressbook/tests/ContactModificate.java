package adressbook.tests;


import adressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificate extends TestBase {


<<<<<<< HEAD
        @Test
=======
         @Test(enabled = false)
>>>>>>> parent of 60a2d43... лекция 5.3
        public void ModificateNewUser() {



            if (! app.getContactHelper().editContact()){

                app.getContactHelper().createContact(new Contact("Max", "Nemchenko", "Evropeyscii prosperct", "7981689712", "maxen_93@mail.ru", "https://vk.com", "1993", "December", "21", "test1", "Saint Peterburg", "8", "mt"));

            }

            List<Contact> before = app.getContactHelper().getContactList();
<<<<<<< HEAD
            app.getContactHelper().editUserPage (before.size()-1 );
=======
            app.getContactHelper().selectContact(before.size() - 1);
            app.getContactHelper().editUserPage ();
>>>>>>> parent of 60a2d43... лекция 5.3
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

