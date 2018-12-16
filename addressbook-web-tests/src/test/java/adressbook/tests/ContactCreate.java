package adressbook.tests;

import adressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreate extends TestBase {


  @Test
  public void testNewUser() {


    List<Contact> before=app.getContactHelper().getContactList();
    app.getContactHelper().gotoaddUser();
    Contact contact = new Contact("Max", "Nemchenko", "Evropeyscii prosperct", "7981689712", "maxen_93@mail.ru", "https://vk.com", "1993", "December", "21", "test1", "Saint Peterburg", "8", "mt");
    app.getContactHelper().FillUserForm(contact,true);
    app.getContactHelper().returnToHomePage();
    List<Contact> after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(contact);
    Comparator<? super Contact> byId=(g1, g2)-> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  }







