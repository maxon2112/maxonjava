package adressbook.tests;

import adressbook.model.Contact;
import adressbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreate extends TestBase {


  @Test
  public void testNewUser() {


    Contacts before = app.contactt().all();
    File photo = new File("src/test/java/resources/pingvin.png");
    Contact contact = new Contact().withFirstname("max").withLastname("Nemchenko").withPhoto(photo).withAdress("Evropeyscii prosperct").withHome("7981689712").withEmail("maxen_93@mail.ru").
            withHomepage("https://vk.com").withByear("1993").withBmonth("December").withBday("21").withGroup("test1").withAddress2("Saint Peterburg").withPhone2("8").withNotes("mt");
    app.contactt().create(contact);
    Contacts after = app.contactt().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


  }
}