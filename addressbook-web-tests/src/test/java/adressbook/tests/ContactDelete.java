package adressbook.tests;

import adressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDelete extends TestBase {


    @Test
    public void  DeleteUser() {

        if (! app.getContactHelper().deleteContact()){

            app.getContactHelper().createContact(new Contact("Max", "Nemchenko", "Evropeyscii prosperct", "7981689712", "maxen_93@mail.ru", "https://vk.com", "1993", "December", "21", "test1", "Saint Peterburg", "8", "mt"));

        }
        List<Contact> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().DeleteCon();
        app.getContactHelper().Alert();
        app.getContactHelper().returnToHomePage();
        List<Contact> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }
}
