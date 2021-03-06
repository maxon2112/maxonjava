package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.Contact;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);

    }

    public void FillUserForm(Contact contact, boolean creation) {

        type(By.name("firstname"), contact.getFirstname());
        type(By.name("lastname"), contact.getLastname());
        //attach(By.name("photo"), contact.getPhoto());
        type(By.name("address"), contact.getAddress());
        type(By.name("home"), contact.getHome());
        type(By.name("email"), contact.getEmail());
        type(By.name("homepage"), contact.getHomepage());
        //type(By.name("byear"), contact.getByear());
        // xtype(By.name("bmonth"), contact.getBmonth());
        // xtype(By.name("bday"), contact.getBday());
        // if (creation) {
        // xtype(By.name("new_group"), contact.getGroup());
        //  new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contact.getGroup());
        //   } else {
        // Assert.assertFalse(isElementPresent(By.name("new_group")));
        //  }

        type(By.name("address2"), contact.getAddress2());
        type(By.name("phone2"), contact.getPhone2());
        type(By.name("notes"), contact.getNotes());
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }


    public void editUserPage(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void editUserPageById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

    public void returnToHomePage() {

        click(By.linkText("home"));
    }

    public void gotoaddUser() {
        click(By.linkText("add new"));
    }

    public void DeleteCon() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void Alert() {
        wd.switchTo().alert().accept();
    }

    public boolean editContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    private void selectGroup(int index) {
        wd.findElement(By.cssSelector("select[name='to_group'] option[value='" + index + "'")).click();
    }

    public void selectContactById(int id) {

        wd.findElement(By.cssSelector("input[value= '" + id + "']")).click();
    }


    public boolean deleteContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(Contact contact) {
        gotoaddUser();
        FillUserForm(contact, true);
        returnToHomePage();
    }

    public void modify(Contact contact) {

        editUserPageById(contact.getId());
        FillUserForm(contact, false);
        returnToHomePage();
    }

    public void delete(Contact contact) {
        selectContactById(contact.getId());
        DeleteCon();
        Alert();
        returnToHomePage();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            List<WebElement> cells = element.findElements(By.cssSelector("td"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            contacts.add(new Contact().withId(id).withFirstname(firstname).withLastname(lastname));

        }
        return contacts;
    }
//


    public Set<Contact> alll() {
        Set<Contact> contacts = new HashSet<Contact>();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            String allEmails = cells.get(4).getText();
            String address = cells.get(3).getText();
            contacts.add(new Contact().withId(id).withFirstname(firstname).withLastname(lastname).withAllEmails(allEmails).
                    withAllPhones(allPhones).withAdress(address));
        }
        return contacts;
    }


    public Contact InfoFromEditForm(Contact contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new Contact().withFirstname(firstname).withLastname(lastname).withId(contact.getId()).withAdress(address).
                withEmail(email).withEmail2(email2).withEmail3(email3).
                withHome(home).WithMobilePhone(mobile).WithWorkPhone(work);
    }

    public void initContactModificationById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

    public int ContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public void addContactInGroup(Contact contact, GroupData group) {
        selectContactById(contact.getId());
        click(By.xpath("//select[@name='to_group']//option[@value='" + group.getId() + "']"));
        click(By.name("add"));


    }

    public void deleteContactOffGroup(Contact contact, GroupData group) {
        click(By.xpath("//select[@name='group']//option[@value='" + group.getId() + "']"));
        selectContactById(contact.getId());
        click(By.name("remove"));
    }

    public void addToGroup(int beforeGroups) {
        selectGroup(beforeGroups);
        click(By.name("add"));
    }

    public void selectGroupList(int index) {
        wd.findElement(By.cssSelector("select[name='group'] option[value='" + index + "'")).click();
    }

    public void deleteContactFromGroup(Contacts before) {
        selectContact(before.size() - 1);
        click(By.name("remove"));
    }

    public void removeContactFromGroup(Contacts before, int beforeGroups) {
        selectGroupList(beforeGroups);
        deleteContactFromGroup(before);
        returnToHomePage();
    }

    public void addContactToGroup(Contacts before, int beforeGroups) {
        selectContact(before.size() - 1);
        addToGroup(beforeGroups);
        returnToHomePage();
    }


    public void adddGroupSimpleLocators(){
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='import'])[1]/following::input[3]")).click();
        wd.findElement(By.name("to_group")).click();
        wd.findElement(By.name("add")).click();
        wd.findElement(By.linkText("group page \"test1\"")).click();
    }
}


//table[@id='maintable']/tbody/tr[8]/td[2]



