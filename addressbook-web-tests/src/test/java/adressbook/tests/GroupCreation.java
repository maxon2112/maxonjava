package adressbook.tests;

import adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreation extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {


    app.getNavigationHelper().gotoGroupPage();
    //List<GroupData> before=app.getGroupHelper().getGroupList();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);

  }


}
