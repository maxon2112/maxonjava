package adressbook.tests;

import adressbook.model.Contact;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest  extends TestBase{

  @Test
     public void testContactPhones() {
      app.goTo(). goToHomePage();
      Contact contact =app.contactt().alll().iterator().next();
      Contact contactInfoFromEditForm = app.contactt().infoFromEditForm(contact);

      assertThat(contact.getHome(), equalTo(cleaned(contactInfoFromEditForm.getHome())));
      assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
      assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
  }

      public String cleaned(String phone){
          return phone.replaceAll("\\s","").replaceAll("[-()]","");
      }

}
