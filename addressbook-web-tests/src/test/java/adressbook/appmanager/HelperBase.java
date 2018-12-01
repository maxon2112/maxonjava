package adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    protected FirefoxDriver wd;

    public HelperBase(FirefoxDriver wd) {
        this.wd=wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();

    }

    protected void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    protected void xpath (By locator,By loc,String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
        wd.findElement(By.name("bmonth")).click();
        wd.findElement(loc).click();
        new Select (wd.findElement(locator).sendKeys(text)).selectByVisibleText(text));
    }
        public boolean isAlertPresent(){
            try {
                wd.switchTo().alert();
                return true;
            }catch (NoAlertPresentException e) {
                return false;

            }
        }
    }

