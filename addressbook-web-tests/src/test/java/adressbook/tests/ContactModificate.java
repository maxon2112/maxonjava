package adressbook.tests;


import adressbook.model.Contact;
import org.testng.annotations.Test;

    public class ContactModificate extends TestBase {


        @Test
        public void ModificateNewUser() {



            if (! app.getContactHelper().editContact()){

                app.getContactHelper().createContact(new Contact("Max", "Nemchenko", "Evropeyscii prosperct", "7981689712", "maxen_93@mail.ru", "https://vk.com", "1993", "December", "21", "test1", "Saint Peterburg", "8", "mt"));

            }
            app.getContactHelper().editUserPage();
            app.getContactHelper().FillUserForm(new Contact("Misha", "Prtrov", "Evropeyscii prosperct", "7988834849595", "maxen_93@mail.ru", "https://vk.com", "1986", "July", "12", null, "Moscow", "9", "mot"), false);
            app.getContactHelper().returnToHomePage();

            List<Contact> before = app.getContactHelper().getContactList();
            app.getContactHelper().selectContact(before.size() - 1);
            app.getContactHelper().editUserPage ();
            Contact contact = new Contact(before.get(before.size() - 1).getId(),"zloy","luk");
            app.getContactHelper().FillUserForm(contact,false);
            app.getContactHelper().submitContactModification ();
            app.getContactHelper().returnToHomePage();
            List<Contact> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size());

            before.remove(before.size() - 1);
            before.add(contact);
            Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


        }


    }

