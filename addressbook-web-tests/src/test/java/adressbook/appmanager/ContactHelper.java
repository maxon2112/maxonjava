package adressbook.appmanager;

import adressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

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

    public boolean deleteContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(Contact contact) {
        gotoaddUser();
        FillUserForm(contact,true);
        returnToHomePage();
    }

    public List<Contact> getContactList() {
        List<Contact> contacts = new ArrayList<Contact>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            List<WebElement> cells = element.findElements(By.cssSelector("td"));
            String lastname = cells.get(1).getText();
            String name = cells.get(2).getText();

            Contact contact = new Contact(id, name, lastname, null, null, null, null,null, null, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}

//table[@id='maintable']/tbody/tr[8]/td[2]



