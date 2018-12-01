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
    wb.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
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
    FillUserForm(new Contact("Max", "Nemchenko", "Evropeyscii prosperct", "7981689712", "maxen_93@mail.ru", "https://vk.com", "1993", "December", "21", "test1", "Saint Peterburg", "8", "mt"));
    returnToHomePage();
    logout();
  }







  private void logout() {
    wb.findElement(By.linkText("Logout")).click();
  }

  private void returnToHomePage() {
    wb.findElement(By.linkText("home page")).click();
  }

  private void FillUserForm(Contact contact) {
    wb.findElement(By.name("firstname")).click();
    wb.findElement(By.name("firstname")).clear();
    wb.findElement(By.name("firstname")).sendKeys(contact.getFirstname());
    wb.findElement(By.name("lastname")).click();
    wb.findElement(By.name("lastname")).clear();
    wb.findElement(By.name("lastname")).sendKeys(contact.getLastname());
    wb.findElement(By.name("address")).click();
    wb.findElement(By.name("address")).clear();
    wb.findElement(By.name("address")).sendKeys(contact.getAddress());
    wb.findElement(By.name("home")).click();
    wb.findElement(By.name("home")).clear();
    wb.findElement(By.name("home")).sendKeys(contact.getHome());
    wb.findElement(By.name("email")).click();
    wb.findElement(By.name("email")).clear();
    wb.findElement(By.name("email")).sendKeys(contact.getEmail());
    wb.findElement(By.name("homepage")).click();
    wb.findElement(By.name("homepage")).sendKeys(contact.getHomepage());
    wb.findElement(By.name("byear")).click();
    wb.findElement(By.name("byear")).clear();
    wb.findElement(By.name("byear")).sendKeys(contact.getByear());
    wb.findElement(By.name("bday")).click();
    wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[23]")).click();
    new Select(wb.findElement(By.name("bday"))).selectByVisibleText(contact.getBday());
    wb.findElement(By.name("bmonth")).click();
    wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[46]")).click();
    new Select(wb.findElement(By.name("bmonth"))).selectByVisibleText(contact.getBmonth());
    wb.findElement(By.name("new_group")).click();
    new Select(wb.findElement(By.name("new_group"))).selectByVisibleText(contact.getNew_group());
    wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Group:'])[1]/following::option[2]")).click();
    wb.findElement(By.name("address2")).click();
    wb.findElement(By.name("address2")).clear();
    wb.findElement(By.name("address2")).sendKeys(contact.getAddress2());
    wb.findElement(By.name("phone2")).click();
    wb.findElement(By.name("phone2")).clear();
    wb.findElement(By.name("phone2")).sendKeys(contact.getPhone2());
    wb.findElement(By.name("notes")).click();
    wb.findElement(By.name("notes")).clear();
    wb.findElement(By.name("notes")).sendKeys(contact.getNotes());
    wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]")).click();












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
