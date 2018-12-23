package adressbook.tests;

import adressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDelete extends TestBase {

    @BeforeMethod
    public void ensurePreconditons() {
        if (!app.contactt().editContact()) {

            app.contactt().create(new Contact("Max", "Nemchenko", "Evropeyscii prosperct", "7981689712", "maxen_93@mail.ru", "https://vk.com", "1993", "December", "21", "test1", "Saint Peterburg", "8", "mt"));

        }
    }

   @Test
    public void  DeleteUser() {
        List<Contact> before = app.contactt().list();
       int index = before.size()-1;
       app.contactt().delete(index);
       List<Contact> after = app.contactt().list();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(index);
        Assert.assertEquals(before, after);

    }


}
