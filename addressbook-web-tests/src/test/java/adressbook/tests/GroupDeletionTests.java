package adressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {






  @Test
  public void testGroupDelection()  {
    app.gotoGroupPage();
    app.selectGroup();
    app.deleteSelectedGroups();
    app.returnToGroupPage();
  }


}
