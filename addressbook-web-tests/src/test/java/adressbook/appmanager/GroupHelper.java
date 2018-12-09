package adressbook.appmanager;

import adressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));


    }

    public void submitGroupCreation() {
        click(By.name("submit"));

    }

    public void FillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());

    }


    public void initGroupCreation() {
      click(By.name("new"));
    }

    public void deleteSelectedGroups() {
      click(By.name("delete"));
    }

    public void selectGroup() {
     click(By.name("selected[]"));
    }


    public void initGroupModification() {
       click(By.name("edit"));}

    public void sumbitGroupModification() {
        click(By.name("update"));}

    public void createGroup(GroupData group) {
        initGroupCreation();
        FillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }
}


