package definitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.Google;
import pages.NisumSite;
import resources.Utilities;


import java.io.IOException;


public class Stepdefinitions extends Utilities {
    public static boolean windowMaximize = false;
    public String baseUrl;
    public String nisumAddress;
    public String googleAddress;
    public WebElement mainDiv;


    /*
    This block take you to the Nisum website "Nisum.com"
     */

    @Given("^Go to nisum's website$")
    public void goToNisumSWebsite() throws IOException {

        Utilities.initialization();
        baseUrl = getGlobalValues("baseUrl");
        driver.get(baseUrl);

    }

    /*
            This method is related to section that needs to be performed on UI
     */

    @When("^Select \"([^\"]*)\" From Our offices seciton$")
    public void selectFromOurOfficesSeciton(String country) {
        NisumSite nisumSite = new NisumSite();
        nisumSite.clickOnCountryOption();
        mainDiv = nisumSite.mainDivNisum;


    }

    /*
    In this snippet we are saving address of Karachi office mentioned on website
     */

    @Then("^Save \"([^\"]*)\" office address$")
    public void saveOfficeAddress(String arg0) {
        nisumAddress = mainDiv.findElement(By.cssSelector("span")).getText();
    }

    /*
    This snippet does the other part of task. Over here we are navigating our initiated driver instance
    desired link that is provided by the first variable of Gherkin script
     */
    /* @Params
        website = Desired link to go to
        searchKey = Text needs to be searched
     */
    @When("^Go to \"([^\"]*)\" and Type \"([^\"]*)\"$")
    public void goToAndType(String website, String searchKey) {
        driver.navigate().to(website);
        Google g = new Google();
        g.search(searchKey);

    }

    /*
    Here we are just verifying desired page got loaded
     */

    @Then("^Web page loads$")
    public void webPageLoads() {

        Google g = new Google();
        g.webPageLoadsPage();

    }

    /*
    This belongs to pick Nisum Pakistan's address from recently navigated link
     */
    @And("^pick Nisum Address$")
    public void pickNisumAddress() {
        Google gog = new Google();
        googleAddress = gog.getAddress();

    }

    /*
    This snippet is the core of this code. Here we are asserting both addresses
     */
    @And("^Assert both addresses$")
    public void assertBothAddressess() {
        String nisumAddressSubstr = nisumAddress.substring(6, 36);
        String googleAddressSubstr = googleAddress.substring(11, 41);
        String replaceCharGoogle = googleAddressSubstr.replace("،", ",");
        Assert.assertEquals(nisumAddressSubstr, replaceCharGoogle);

    }
}





