package adressbook.tests;

import adressbook.model.GroupData;
import adressbook.model.Groups;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreation extends TestBase {


  @Test
  public void testGroupCreation() throws Exception  {


    app.goTo().groupPage();
    Groups before=app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    assertThat(after.size(), equalTo(before.size() + 1));
    Set<GroupData> after=app.group().all();

    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }


}
