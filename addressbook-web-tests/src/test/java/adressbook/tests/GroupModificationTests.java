package adressbook.tests;

import adressbook.model.GroupData;
import adressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditons() {
        app.goTo().groupPage();
        if (app.group().all().size()==0){
            app.group().create(new GroupData().withName("test1"));
        }

    }
    @Test
    public void testGroupModification(){
       Groups before=app.group().all();
        GroupData modifedGroup = before.iterator().next();


        GroupData group = new GroupData().
                withId(modifedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modify(group);
        Groups after=app.group().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifedGroup).withAdded(group)));
    }


    }

