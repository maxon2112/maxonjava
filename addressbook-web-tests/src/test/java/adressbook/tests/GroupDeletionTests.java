package adressbook.tests;

import adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditons() {
    app.goTo().groupPage();

    if (app.group().list().size()==0){
      app.group().create(new GroupData("test1", null, null));
    }

  }

  @Test
  public void testGroupDelection() {
    List<GroupData> before = app.group().list();
   int index= before.size()-1;
    app.group().delete(index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);

      Assert.assertEquals(before, after);
    }




}

