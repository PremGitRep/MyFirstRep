package seleniumgrid.testng.check;

import io.cucumber.java.hu.De;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class SeleniumGridCheck {

    RemoteWebDriver driver;
    @BeforeClass()
    @Parameters({"browserType"})
    public void desiredCapabilities(String browserType) throws MalformedURLException {
        DesiredCapabilities dr;
        if (browserType.equals("firefox")) {
            dr = DesiredCapabilities.firefox();
            dr.setBrowserName("firefox");
            dr.setPlatform(Platform.WINDOWS);

        } else if (browserType.equals("iexplore")) {
            dr = DesiredCapabilities.internetExplorer();
            dr.setBrowserName("iexplore");
            dr.setPlatform(Platform.WINDOWS);
        } else {
            String rootDirectory = System.getProperty("user.dir");
            String hubURL = "http://localhost:4444/wd/hub";
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.WINDOWS);
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", rootDirectory + "//src//main//java//drivers//chromedriver.exe");
            options.merge(cap);
            System.out.println("Check");
            driver = new RemoteWebDriver(new URL(hubURL), options);

            driver.manage().window().maximize();
        }


    }


    @Test
    public void launchGoogle() {
        driver.get("https://www.google.com");
    }
}
