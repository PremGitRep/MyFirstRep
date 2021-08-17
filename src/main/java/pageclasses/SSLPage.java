package pageclasses;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.Base64;
import java.util.Set;

public class SSLPage extends BaseTest {

    @FindBy(id = "app-search")
    WebElement searchBox;

    public SSLPage(WebDriver driver) {
        this.driver = driver;
         PageFactory.initElements(driver, this);
    }

    public void serachOnTheBox(String searchKey) {


        System.out.println(driver.getTitle());
        searchBox.sendKeys(searchKey);
        searchBox.sendKeys(Keys.ENTER);

    }
}
