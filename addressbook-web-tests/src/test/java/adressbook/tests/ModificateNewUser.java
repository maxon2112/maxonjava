package adressbook.tests;


import adressbook.model.Contact;
import org.testng.annotations.Test;

    public class ModificateNewUser extends TestBase {


        @Test
        public void ModificateNewUser() {


            app.getContactHelper().editUserPage();
            app.getContactHelper().modificateUserForm(new Contact("Misha", "Prtrov", "Evropeyscii prosperct", "7988834849595", "maxen_93@mail.ru", "https://vk.com", "1986", "July", "12", "test1", "Moscow", "9", "mot"));
            app.getContactHelper().returnToHomePage();

        }


    }
