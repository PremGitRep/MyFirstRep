package basetest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageclasses.LandingPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public Properties prop;
    String rootDirectory = System.getProperty("user.dir");

    public LandingPage initiateDriverAndPropertiesFile() {
        prop = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(rootDirectory + "//src//main//java//utilities//GlobalValues.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", rootDirectory + "//src//main//java//drivers//chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        } else {

            System.out.println("check");
        }
        return new LandingPage(driver);
    }

    /*
    Purpose : To Close the driver
    Creator : Prem
    Date_Created: 13-08-2021
    */

    public void closeDriver() {
        driver.close();
    }

}
