package DelGr;

import adressbook.TestBase;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {






  @Test
  public void testGroupDelection()  {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
  }


}
