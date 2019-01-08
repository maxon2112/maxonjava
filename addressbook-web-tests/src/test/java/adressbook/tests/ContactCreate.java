package adressbook.tests;

import adressbook.model.Contact;
import adressbook.model.Contacts;
import adressbook.model.GroupData;
import adressbook.model.Groups;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreate extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsJson() throws IOException {
   try( BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/java/resources/contacts.json")))){
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<Contact> contacts = gson.fromJson(json, new TypeToken<List<Contact>>() {
    }.getType());
    return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }
        }
  @Test(dataProvider = "validContactsJson")
  public void testNewUser(Contact contacttt) {
    Contacts before = app.contactt().all();
    app.contactt().create(contacttt);
    Contacts after = app.contactt().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contacttt.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }


    @Test
    public void testNewUserWithPhoto () {
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
