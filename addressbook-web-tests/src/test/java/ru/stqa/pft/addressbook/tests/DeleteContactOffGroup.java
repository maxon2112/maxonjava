package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.Contact;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;




public class DeleteContactOffGroup extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        Boolean AddContactInGroup = false;
        if (app.db().contactt().size() == 0){
            app.goTo().goToHomePage();
            app.contactt().create(new Contact().withFirstname("Elena").withLastname("Ivanova")
                    .withAdress("Novosibirsk city, Lenina street 5 - 14").withHome("89135685945")
                    .withEmail("Ivanova@mail.ru"));
            if (app.db().groups().size() != 0){
                AddContactInGroup = true;
            }else {
                app.goTo().groupPage();
                app.group().create(new GroupData().withName("test1"));
                AddContactInGroup = true;
            }
        }
        if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
            if (app.db().contactt().size() != 0){
                AddContactInGroup = true;
            } else {
                app.goTo().goToHomePage();
                app.contactt().create(new Contact().withFirstname("Elena").withLastname("Ivanova")
                        .withAdress("Novosibirsk city, Lenina street 5 - 14").withHome("89135685945")
                        .withEmail("Ivanova@mail.ru"));
                AddContactInGroup = true;
            }
        }
        if (AddContactInGroup == true){
            Contact contact = app.db().contactt().iterator().next();
            GroupData group = app.db().groups().iterator().next();
            app.contactt().addContactInGroup(contact,group);

        }
    }


    @Test
    public void testDeleteContactOffGroup () {
        app.goTo().goToHomePage();
        Contacts contacts = app.db().contactt();
        Boolean testOK = false;
        Contact contactForTest = null;
        int countGroupBeforTest = 0;
        for (Contact contact: contacts) {
            if (testOK == false) {
                if (contact.getGroups().size() != 0) {
                    countGroupBeforTest = contact.getGroups().size();
                    GroupData group = contact.getGroups().iterator().next();
                    app.contactt().deleteContactOffGroup(contact, group);
                    testOK = true;
                    contactForTest = contact;
                }
            }
        }
        Contacts after = app.db().contactt();
        for (Contact cont: after){
            if (cont.getId() == contactForTest.getId()){
                contactForTest = cont;
                break;
            }
        }
        app.goTo().goToHomePage();
        Assert.assertEquals(contactForTest.getGroups().size(), countGroupBeforTest - 1);
    }
}
