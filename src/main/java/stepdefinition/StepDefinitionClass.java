package stepdefinition;

import basetest.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageclasses.BusinessPage;
import pageclasses.FAQSPage;
import pageclasses.LandingPage;
import pageclasses.SSLPage;

public class StepDefinitionClass extends BaseTest {

    LandingPage landingPage;
    @Before
    public void initiateBrowser(){
        landingPage = initiateDriverAndPropertiesFile();
    }
    @After
    public void wrapUp(){
        closeDriver();
    }
    @Given("Google home page is available")
    public void google_home_page_is_available() {
        landingPage.verifyLandingPageTitle();
    }

    @Then("Verify the Title")
    public void verify_the_title() {
        landingPage.verifyLandingPageTitle();
    }
    BusinessPage businessPage;
    @When("User clicks on Business Footer Link")
    public void user_clicks_on_business_footer_link() {
       businessPage = landingPage.clickBusinessLink();
    }

    @Then("Verify the Business Page Title")
    public void verify_the_business_page_title() {
        businessPage.verifyPageTitle();
    }
    FAQSPage faqsPage;
    @Then("Click on FAQs")
    public void click_on_fa_qs() {
       faqsPage = businessPage.clickOnFAQLink();
    }

    @Then("Verify the page has Skillshop footer link")
    public void verify_the_page_has_skillshop_footer_link() {
        faqsPage.verifyPresenceOfSkillShopLink();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    SSLPage sslPage;
    @And("Click on the Skillshop Link")
    public void clickOnTheSkillshopLink() {
        sslPage = faqsPage.clickOnsslLink();
    }

 /*   @And("Search for this words")
    public void searchForThisWords() {
        sslPage.serachOnTheBox();
    }*/

    @And("Search for this words {string}")
    public void searchForThisWords(String searchKey) {
        sslPage.serachOnTheBox(searchKey);

    }
}
