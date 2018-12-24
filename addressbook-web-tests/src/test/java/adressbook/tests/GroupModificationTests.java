package adressbook.tests;

import adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<GroupData> before=app.group().all();
        GroupData modifedGroup = before.iterator().next();


        GroupData group = new GroupData().
                withId(modifedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modify(group);
        List<GroupData> after=app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifedGroup);
        before.add(group);

        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

    }


    }

