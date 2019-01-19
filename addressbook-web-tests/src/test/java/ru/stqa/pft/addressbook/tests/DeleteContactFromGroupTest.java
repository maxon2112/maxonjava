package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.Contact;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import java.io.File;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



public class DeleteContactFromGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

        if(app.db().groups().size()==0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));


        }
        if(app.db().contactt().size()==0){
            app.goTo().goToHomePage();
            app.contactt().create(new Contact().withFirstname("max").withLastname("Nemchenko").withAdress("Evropeyscii prosperct").withHome("7981689712").withEmail("maxen_93@mail.ru").
                    withHomepage("https://vk.com").withByear("1993").withBmonth("December").withBday("21").withAddress2("Saint Peterburg").withPhone2("8").withNotes("mt"));
        }
    }
    @Test
    public void testContactDeletionFromGroup() {

        Groups groupsBefore= app.db().contactt().iterator().next().getGroups();
        Contacts before=app.db().contactt();
        GroupData groupOut=app.db().groups().iterator().next();
        app.goTo().goToHomePage();
        app.contactt().removeContactFromGroup(before, groupOut.getId());
        Groups groupsAfter= app.db().contactt().iterator().next().getGroups();
        assertThat(groupsAfter, equalTo(groupsBefore.without(groupOut)));
        verifyContactListInUI();
    }

}