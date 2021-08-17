package pageclasses;

import basetest.BaseTest;
import com.sun.source.tree.WhileLoopTree;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class FAQSPage extends BaseTest {

    @FindBy(xpath = "//a[text()='Skillshop']")
    WebElement skillShopLink;

    public FAQSPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyPresenceOfSkillShopLink() {
        try {
            Assert.assertTrue("SkillShopLink is available", skillShopLink.isDisplayed());
        } catch (Exception e) {
            System.out.println(e);
            Assert.assertTrue("SkillShopLink Not Available - " + skillShopLink, false);

        }

    }

    public SSLPage clickOnsslLink() {

        skillShopLink.click();
        String currentWindow = driver.getWindowHandle();
        Set<String> activeWindows = driver.getWindowHandles();
        for (String windows : activeWindows) {
            System.out.println(windows);
            if (!windows.equalsIgnoreCase(currentWindow)) {
                driver.switchTo().window(windows);
                System.out.println(driver.getTitle());
            }
        }
        return new SSLPage(driver);

    }
}
