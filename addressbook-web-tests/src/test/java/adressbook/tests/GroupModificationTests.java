package adressbook.tests;

import adressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification(){
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().FillGroupForm(new GroupData("test1", "modtest", "ftest"));
        app.getGroupHelper().sumbitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
