package pageclasses;

import basetest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BusinessPage extends BaseTest {

    String expectedPageTitle = "Google My Business – Drive Customer Engagement on Google";

    public BusinessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = " //div[@class='h-c-header__bar']//a[text()='FAQs']")
    WebElement faqsLink;

    public void verifyPageTitle() {
        Assert.assertEquals(driver.getTitle(), expectedPageTitle);
    }
    public FAQSPage clickOnFAQLink(){
        if(faqsLink.isDisplayed()) {
            faqsLink.click();
        }
        else {
            Assert.assertTrue(false, "FAQ link is not available");
        }
        return new FAQSPage(driver);
    }
}
