package pageclasses;

import basetest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LandingPage extends BaseTest {

    @FindBy(xpath = "//a[text()='Business']")
    WebElement businessLink;


    /* Purpose - Verify the Title of the page
       Creator - Prem
       Date - 13-08-2021
     */

    public void verifyLandingPageTitle(){
        String currentTitle = driver.getTitle();
        Assert.assertEquals("Google",currentTitle);
    }

    public BusinessPage clickBusinessLink(){
        businessLink.click();
        return new BusinessPage(driver);
    }

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
