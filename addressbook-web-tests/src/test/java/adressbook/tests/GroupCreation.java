package adressbook.tests;

import adressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreation extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    app.gotoGroupPage();
    app.initGroupCreation();
    app.FillGroupForm(new GroupData("test1", "test2", "test3"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }


}
