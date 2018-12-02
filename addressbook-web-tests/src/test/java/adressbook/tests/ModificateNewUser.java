package adressbook.tests;


import adressbook.model.Contact;
import org.testng.annotations.Test;

    public class ModificateNewUser extends TestBase {


        @Test
        public void ModificateNewUser() {


            app.getAddNewHelper().editUserPage();
            app.getAddNewHelper().modificateUserForm(new Contact("Misha", "Prtrov", "Evropeyscii prosperct", "7988834849595", "maxen_93@mail.ru", "https://vk.com", "1986", "July", "12", "test1", "Moscow", "9", "mot"));
            app.getAddNewHelper().returnToHomePage();

        }


    }

