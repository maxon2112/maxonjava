package adressbook.appmanager;

import adressbook.model.Contact;
import adressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
        type(By.name("address"), contact.getAddress());
        type(By.name("home"), contact.getHome());
        type(By.name("email"), contact.getEmail());
        type(By.name("homepage"), contact.getHomepage());
        type(By.name("byear"), contact.getByear());
        xtype(By.name("bmonth"), contact.getBmonth());
        xtype(By.name("bday"), contact.getBday());
        if (creation) {
            xtype(By.name("new_group"), contact.getGroup());
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contact.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

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
            contacts.add(new Contact().withId(id).withFirstname(firstname).withLastname(lastname).withAllEmails(allEmails).
                    withAllPhones(allPhones));
        }
        return contacts;
    }





    public Contact InfoFromEditForm(Contact contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new Contact().withFirstname(firstname).withLastname(lastname).withId(contact.getId()).
                withEmail(email).withEmail2(email2).withEmail3(email3).
                withHome(home).WithMobilePhone(mobile).WithWorkPhone(work);
    }

    public void initContactModificationById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }
}


//table[@id='maintable']/tbody/tr[8]/td[2]



