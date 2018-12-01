package com.example.tests;

import adressbook.TestBase;
import org.testng.annotations.Test;

public class NewUser extends TestBase {









  @Test
  public void testNewUser() {

    gotoaddUser();
    FillUserForm(new Contact("Max", "Nemchenko", "Evropeyscii prosperct", "7981689712", "maxen_93@mail.ru", "https://vk.com", "1993", "December", "21", "test1", "Saint Peterburg", "8", "mt"));
    returnToHomePage();
    logout();
  }


}




