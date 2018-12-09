package adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    protected WebDriver wd;

        public HelperBase(WebDriver wd) {
        this.wd=wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();

    }

    public void type(By locator, String text) {
        click(locator);

                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);

            }


    public void xtype (By locator, String text) {
       // if (isElementPresent(locator)) {
            new Select(wd.findElement(locator)).selectByVisibleText(text);

        }
   // }


    public boolean isElementPresent(By locator){
            try {
                wd.findElement(locator);
                return true;
            }catch (NoSuchElementException ex) {
                return false;

            }
        }


}

