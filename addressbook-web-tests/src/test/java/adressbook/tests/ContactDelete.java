package adressbook.tests;

import adressbook.model.Contact;
import org.testng.annotations.Test;

public class ContactDelete extends TestBase {


    @Test
    public void  DeleteUser() {

        if (! app.getContactHelper().deleteContact()){

            app.getContactHelper().createContact(new Contact("Max", "Nemchenko", "Evropeyscii prosperct", "7981689712", "maxen_93@mail.ru", "https://vk.com", "1993", "December", "21", "test1", "Saint Peterburg", "8", "mt"));

        }
        app.getContactHelper().ChoseDelete();
        app.getContactHelper().Alert();

    }


}
