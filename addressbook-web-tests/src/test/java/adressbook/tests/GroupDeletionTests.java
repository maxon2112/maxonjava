package adressbook.tests;

import adressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {






  @Test
  public void testGroupDelection()  {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();


  }


}
