package adressbook.tests;

import adressbook.model.GroupData;
import adressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditons() {
    app.goTo().groupPage();

    if (app.group().all().size()==0){
      app.group().create(new GroupData().withName("test2"));
    }

  }

  @Test
  public void testGroupDelection() {
   Groups before = app.group().all();
   GroupData deleteGroup = before.iterator().next();

    app.group().delete(deleteGroup);
      assertThat(app.group(), equalTo(before.size() - 1));
      Groups after = app.group().all();
      assertThat(after, equalTo(before.without(deleteGroup)));

    }




}

