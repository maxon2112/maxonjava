package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NewUser {
  private WebDriver wb;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wb = new FirefoxDriver();
    wb.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wb.get("http://localhost/addressbook/");
    login("admin","secret");
  }

  private void login(String username, String password) {
    wb.findElement(By.name("user")).click();
    wb.findElement(By.name("user")).clear();
    wb.findElement(By.name("user")).sendKeys(username);
    wb.findElement(By.name("pass")).click();
    wb.findElement(By.name("pass")).clear();
    wb.findElement(By.name("pass")).sendKeys(password);
    wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
  }

  @Test
  public void testNewUser() {

    gotoaddUser();
    WriteFirstName("Max");
    WriteLastName("Nemchenko");
    WriteAddress("Evropeyscii prosperct");
    WriteHomeNumber("7");
    WriteEmail("maxen_93@mail.ru");
    WriteHomepage("https://vk.com");
    SelectDateBirthday(new FullDateBirthday("1993", "21", "December"));
    selectGroup("test1");
    WriteAdress2("Saint Peterburg");
    WriteNumber("8");
    WriteNotes("87");
    returnToHomePage();
    logout();
  }







  private void logout() {
    wb.findElement(By.linkText("Logout")).click();
  }

  private void returnToHomePage() {
    wb.findElement(By.linkText("home page")).click();
  }

  private void WriteNotes(String notes) {
    wb.findElement(By.name("notes")).click();
    wb.findElement(By.name("notes")).clear();
    wb.findElement(By.name("notes")).sendKeys(notes);
    wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]")).click();
  }

  private void WriteNumber(String phone2) {
    wb.findElement(By.name("phone2")).click();
    wb.findElement(By.name("phone2")).clear();
    wb.findElement(By.name("phone2")).sendKeys(phone2);
  }

  private void WriteAdress2(String address2) {
    wb.findElement(By.name("address2")).click();
    wb.findElement(By.name("address2")).clear();
    wb.findElement(By.name("address2")).sendKeys(address2);
  }

  private void selectGroup(String new_group) {
    wb.findElement(By.name("new_group")).click();
    new Select(wb.findElement(By.name("new_group"))).selectByVisibleText(new_group);
    wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Group:'])[1]/following::option[2]")).click();
  }


  private void SelectDateBirthday(FullDateBirthday fullDateBirthday) {
    wb.findElement(By.name("bday")).click();
    new Select(wb.findElement(By.name("bday"))).selectByVisibleText(fullDateBirthday.getBday());
    wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[23]")).click();
    wb.findElement(By.name("bmonth")).click();
    new Select(wb.findElement(By.name("bmonth"))).selectByVisibleText(fullDateBirthday.getBmonth());
    wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[46]")).click();
    wb.findElement(By.name("byear")).click();
    wb.findElement(By.name("byear")).click();
    wb.findElement(By.name("byear")).clear();
    wb.findElement(By.name("byear")).sendKeys(fullDateBirthday.getByear());
  }

  private void WriteHomepage(String homepage) {
    wb.findElement(By.name("homepage")).click();
    wb.findElement(By.name("homepage")).sendKeys(homepage);
  }

  private void WriteEmail(String email) {
    wb.findElement(By.name("email")).click();
    wb.findElement(By.name("email")).clear();
    wb.findElement(By.name("email")).sendKeys(email);
  }

  private void WriteHomeNumber(String home) {
    wb.findElement(By.name("home")).click();
    wb.findElement(By.name("home")).clear();
    wb.findElement(By.name("home")).sendKeys(home);

  }

  private void WriteAddress(String address) {
    wb.findElement(By.name("address")).click();
    wb.findElement(By.name("address")).clear();
    wb.findElement(By.name("address")).sendKeys(address);

  }

  private void WriteLastName(String lastname) {
    wb.findElement(By.name("lastname")).click();
    wb.findElement(By.name("lastname")).clear();
    wb.findElement(By.name("lastname")).sendKeys(lastname);
  }

  private void WriteFirstName(String firstname) {
    wb.findElement(By.name("firstname")).click();
    wb.findElement(By.name("firstname")).clear();
    wb.findElement(By.name("firstname")).sendKeys(firstname);
  }

  private void gotoaddUser() {
    wb.findElement(By.linkText("add new")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wb.quit();

    }


  private boolean isElementPresent(By by) {
    try {
      wb.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wb.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


}
