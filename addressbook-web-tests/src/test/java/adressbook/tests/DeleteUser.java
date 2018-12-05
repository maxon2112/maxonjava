package adressbook.tests;

import org.testng.annotations.Test;

public class  DeleteUser extends TestBase {


    @Test
    public void  DeleteUser() {


        app.getContactHelper().ChoseDelete();
        app.getContactHelper().Alert();

    }


}

