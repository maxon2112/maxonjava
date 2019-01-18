package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contact;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;



public class AddContactInGroupTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contactt().size() == 0) {
            app.goTo().goToHomePage();
            app.contactt().create(new Contact().withFirstname("Elena").withLastname("Ivanova")
                    .withAdress("Novosibirsk city, Lenina street 5 - 14").WithMobilePhone("89135685945")
                    .withEmail("Ivanova@mail.ru"));
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testAddContactInGroup() {
        app.goTo().goToHomePage();
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contactt();
        Boolean contactInGroup = false;
        Contact contactForTest = null;
        int countGroupOnContactBefor = 0;
        for (Contact contact : contacts) {
            if (contactInGroup == false) {
                for (GroupData group : groups) {
                    if (contactInGroup == false) {
                        Groups contactInGroups = contact.getGroups();
                        if (contactInGroups.size() != 0) {
                            for (GroupData groupContact : contactInGroups) {
                                if (group != groupContact) {
                                    countGroupOnContactBefor = contact.getGroups().size();
                                    contactForTest = contact;
                                    app.contactt().addContactInGroup(contact, group);
                                    contactInGroup = true;
                                }
                            }
                        } else {
                            countGroupOnContactBefor = contact.getGroups().size();
                            contactForTest = contact;
                            app.contactt().addContactInGroup(contact, group);
                            contactInGroup = true;
                        }
                    }
                }
            }
        }
        Contacts after = app.db().contactt();
        for (Contact cont : after) {
            if (cont.getId() == contactForTest.getId()) {
                contactForTest = cont;
                break;
            }
        }
        app.goTo().goToHomePage();
        Assert.assertEquals(contactForTest.getGroups().size(), countGroupOnContactBefor + 1);
    }
}
