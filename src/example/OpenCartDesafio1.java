package example;
import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class  OpenCartDesafio1{
    FirefoxDriver wd;
    
    @Before
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void RecordAndPlayJunit() {
        wd.get("http://demo.opencart.com/");
        wd.findElement(By.name("search")).click();
        wd.findElement(By.name("search")).clear();
        wd.findElement(By.name("search")).sendKeys("iphone");
        wd.findElement(By.xpath("//span[@class='input-group-btn']/button")).click();
        wd.findElement(By.id("grid-view")).click();
 
        if (!wd.findElement(By.tagName("html")).getText().contains("iPhone")) {
            System.out.println("verifyTextPresent failed1");
        }
 
        wd.findElement(By.linkText("iPhone")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("iPhone")) {
            System.out.println("verifyTextPresent failed2");
        }
        if (!wd.findElement(By.tagName("html")).getText().contains("$123.20")) {
            System.out.println("verifyTextPresent failed3");
        }
    }
    
    @After
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
