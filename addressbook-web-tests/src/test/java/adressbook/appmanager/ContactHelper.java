package adressbook.appmanager;

import adressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);

    }

    public void FillUserForm(Contact contact) {

        type(By.name("firstname"), contact.getFirstname());
        type(By.name("lastname"), contact.getLastname());
        type(By.name("address"), contact.getAddress());
        type(By.name("home"), contact.getHome());
        type(By.name("email"), contact.getEmail());
        type(By.name("homepage"), contact.getHomepage());
        type(By.name("byear"), contact.getByear());
        xtype(By.name("bmonth"), contact.getBmonth());
        xtype(By.name("bday"), contact.getBday());
        xtype(By.name("new_group"), contact.getNew_group());
        type(By.name("address2"), contact.getAddress2());
        type(By.name("phone2"), contact.getPhone2());
        type(By.name("notes"), contact.getNotes());
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }



    public void editUserPage() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void modificateUserForm(Contact contact){

            type(By.name("firstname"), contact.getFirstname());
            type(By.name("lastname"), contact.getLastname());
            type(By.name("address"), contact.getAddress());
            type(By.name("home"), contact.getHome());
            type(By.name("email"), contact.getEmail());
            type(By.name("homepage"), contact.getHomepage());
            type(By.name("byear"), contact.getByear());
            xtype(By.name("bmonth"), contact.getBmonth());
            xtype(By.name("bday"), contact.getBday());
            type(By.name("address2"), contact.getAddress2());
            type(By.name("phone2"), contact.getPhone2());
            type(By.name("notes"), contact.getNotes());
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='mt'])[1]/following::input[1]"));


        }


    public void ChoseDelete() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]"));

    }
    public void Alert() {
        wd.switchTo().alert().accept();
    }
}

//table[@id='maintable']/tbody/tr[8]/td[2]



