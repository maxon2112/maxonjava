package adressbook;

import org.testng.annotations.Test;

public class GroupCreation extends TestBase{


  @Test
  public void testGroupCreation() throws Exception {

    gotoGroupPage();
    initGroupCreation();
    FillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }


}
