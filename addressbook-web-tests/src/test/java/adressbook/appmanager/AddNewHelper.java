package adressbook.appmanager;

import adressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddNewHelper extends HelperBase {
    public AddNewHelper(FirefoxDriver wd)  {
        super(wd);

    }

        public void FillUserForm (Contact contact) {

            type(By.name("firstname"), contact.getFirstname());
            type(By.name("lastname"), contact.getLastname());
            type(By.name("address"), contact.getAddress());
            type(By.name("home"), contact.getHome());
            type(By.name("email"), contact.getEmail());
            type(By.name("homepage"), contact.getHomepage());
            type(By.name("byear"), contact.getByear());
            xtype(By.name("bmonth"),contact.getBmonth());
            xtype(By.name("bday"),contact.getBday());
            xtype(By.name("new_group"),contact.getNew_group());
            type(By.name("address2"), contact.getAddress2());
            type(By.name("phone2"), contact.getPhone2());
            type(By.name("notes"), contact.getNotes());
            click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
        }
            public void returnToHomePage() {
                click(By.linkText("home page"));



    }
}



