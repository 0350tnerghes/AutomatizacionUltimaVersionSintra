package mine.stepdefs;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import mine.pages.PagesFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import mine.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;

@Slf4j

public class HomePageSteps {

    @Given("the user is on the home page")
    public void theUserNavigateAtHomePage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides the url");
        HomePage homePage = pf.getHomePage();
        homePage.navigateTo(HomePage.pageUrl);
        //throw new io.cucumber.java.PendingException();
    }

    @And("the user click English language display")
    public void clickLanguageButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user move the mouse on the <language> button");
        HomePage homePage = pf.getHomePage();
        homePage.selectLanguage();
        //throw new PendingException();
    }

    @Then("The user changed the language at HomePage successfully")
    public void theHomePageEnglish() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The home page load in English language");
        HomePage homePage = pf.getHomePage();
        homePage.waitForPageLoad();
        String currentLanguage = PagesFactory.getInstance().getDriver().findElement(By.xpath("//span[contains(text(), 'EN')]")).getText();
        Assert.assertEquals("The language didn´t changed", "EN", currentLanguage);
    }

    @Then("The HomePage did not loaded")
    public void theHomePageDidNotLoaded() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The home page load in English language");
        HomePage homePage = pf.getHomePage();
        homePage.waitForPageLoad();
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not Home Page", HomePage.pageUrl, currentUrl);
    }

    @When("The user select <location> from radio button")
    public void selectLocation() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user select <location> from radio button");
        HomePage homePage = pf.getHomePage();
        homePage.waitForPageLoad();
        homePage.clickLocation();
    }

    @Then("Location is displayed in grey color at the top right and Location area is contracted while Department area is shown")
    public void locationIsDisplayed() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user select <location> from radio button");
        HomePage homePage = pf.getHomePage();
        String currentLocation = PagesFactory.getInstance().getDriver().findElement(By.xpath("//mat-panel-description[contains(text(),'Santa Cruz de Tenerife')]")).getText();
        Assert.assertEquals("Failed to select location", "Santa Cruz de Tenerife", currentLocation);
    }


    @Then("Location is not displayed in grey color at the top right and Location area is not contracted while Department area is shown")
    public void locationSelectedError() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user select <location> from radio button");
        HomePage homePage = pf.getHomePage();
        Boolean estaMenuDesplegado;
       // Assert.assertTrue("Error", homePage.estaMenuDesplegado);
    }
}


