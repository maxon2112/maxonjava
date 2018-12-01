package adressbook.appmanager;

import adressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddNewHelper {
    private FirefoxDriver wd;

    public AddNewHelper(FirefoxDriver wd) {
        this.wd = wd;
    }
        public void gotoaddUser(){
            wd.findElement(By.linkText("add new")).click();
        }

        public void FillUserForm (Contact contact) {
            wd.findElement(By.name("firstname")).click();
            wd.findElement(By.name("firstname")).clear();
            wd.findElement(By.name("firstname")).sendKeys(contact.getFirstname());
            wd.findElement(By.name("lastname")).click();
            wd.findElement(By.name("lastname")).clear();
            wd.findElement(By.name("lastname")).sendKeys(contact.getLastname());
            wd.findElement(By.name("address")).click();
            wd.findElement(By.name("address")).clear();
            wd.findElement(By.name("address")).sendKeys(contact.getAddress());
            wd.findElement(By.name("home")).click();
            wd.findElement(By.name("home")).clear();
            wd.findElement(By.name("home")).sendKeys(contact.getHome());
            wd.findElement(By.name("email")).click();
            wd.findElement(By.name("email")).clear();
            wd.findElement(By.name("email")).sendKeys(contact.getEmail());
            wd.findElement(By.name("homepage")).click();
            wd.findElement(By.name("homepage")).sendKeys(contact.getHomepage());
            wd.findElement(By.name("byear")).click();
            wd.findElement(By.name("byear")).clear();
            wd.findElement(By.name("byear")).sendKeys(contact.getByear());
            wd.findElement(By.name("bday")).click();
            wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[23]")).click();
            new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contact.getBday());
            wd.findElement(By.name("bmonth")).click();
            wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[46]")).click();
            new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contact.getBmonth());
            wd.findElement(By.name("new_group")).click();
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contact.getNew_group());
            wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Group:'])[1]/following::option[2]")).click();
            wd.findElement(By.name("address2")).click();
            wd.findElement(By.name("address2")).clear();
            wd.findElement(By.name("address2")).sendKeys(contact.getAddress2());
            wd.findElement(By.name("phone2")).click();
            wd.findElement(By.name("phone2")).clear();
            wd.findElement(By.name("phone2")).sendKeys(contact.getPhone2());
            wd.findElement(By.name("notes")).click();
            wd.findElement(By.name("notes")).clear();
            wd.findElement(By.name("notes")).sendKeys(contact.getNotes());
            wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]")).click();
        }
            public void returnToHomePage() {
                wd.findElement(By.linkText("home page")).click();




    }
}



