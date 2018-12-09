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


        }


    }

