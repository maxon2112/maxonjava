package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class ResetPasswordHelper extends HelperBase {

  public ResetPasswordHelper(ApplicationManager app) {
    super(app);
  }


  public void goToManagePage(){
    wd.findElement(By.linkText("Manage")).click();
  }

  public void goToManageOfUsersPage(){
    wd.findElement(By.linkText("Manage Users")).click();
  }

  public void chooseUser(){

    WebElement webElement = wd.findElement(By.cssSelector("a[href*='manage_user_edit_page.php']:not([href='manage_user_edit_page.php?user_id=1']"));
    //WebElement webElement = wd.findElement(By.cssSelector("a[href='manage_user_edit_page.php?user_id=2']"));
    webElement.click();
  }
  public void resetPassword(){
    wd.findElement(By.cssSelector("input[value='Reset Password']")).click();
  }

  public String getUserName(){
    String username = wd.findElement(By.cssSelector("input[name='username']")).getAttribute("value");
    return username;
  }

  public String getMail(){
    String email = wd.findElement(By.cssSelector("input[name='email']")).getAttribute("value");
    return email;
  }

  public void changePasswordFinish(String resetPasswordLink, String newpassword){
    wd.get(resetPasswordLink);
    type(By.name("password"),newpassword);
    type(By.name("password_confirm"),newpassword);
    click(By.cssSelector("input[value='Update User']"));
  }

}


