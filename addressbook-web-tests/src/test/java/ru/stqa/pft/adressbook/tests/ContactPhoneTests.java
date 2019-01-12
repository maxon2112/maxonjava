
package ru.stqa.pft.adressbook.tests;

import ru.stqa.pft.adressbook.model.Contact;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests  extends TestBase{


    @Test

    public void contactPhoneTest() {
        app.goTo().goToHomePage();
        Contact contact = app.contactt().alll().iterator().next();
        Contact contactInfoFromEditForm = app.contactt().InfoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAllEmails(), equalTo(mergeEmail(contactInfoFromEditForm)));
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }



    private String mergePhones(Contact contact) {
        return Arrays.asList(contact.getHome(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> !s.equals("")).
                        map(ContactPhoneTests::cleaned).collect(Collectors.joining("\n"));
    }
        private String mergeEmail(Contact contact) {
            return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                    .stream().filter((s) -> !s.equals("")).
                           collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
