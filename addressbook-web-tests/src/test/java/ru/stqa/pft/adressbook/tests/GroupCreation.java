package ru.stqa.pft.adressbook.tests;

import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreation extends TestBase {

@DataProvider
public Iterator<Object[]> validGroupsJson() throws IOException {
  try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/java/resources/groups.json")))) {
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
    }.getType());
    return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }
}
  @Test(dataProvider = "validGroupsJson")
  public void testGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups before=app.group().all();
    app.group().create(group);
    MatcherAssert.assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after=app.group().all();
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }

  @Test (enabled = false)
  public void testBadGroupCreation() throws Exception  {


    app.goTo().groupPage();
    Groups before=app.group().all();
    GroupData group = new GroupData().withName("test!");
    app.group().create(group);
    MatcherAssert.assertThat(app.group().count(), equalTo(before.size()));
    Groups after=app.group().all();

    assertThat(after, equalTo(before));
  }

}