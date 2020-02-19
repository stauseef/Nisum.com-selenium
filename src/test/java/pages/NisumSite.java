package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.support.PageFactory;
import resources.Utilities;

import javax.swing.text.html.CSS;

public class NisumSite extends Utilities {

    @FindBy(linkText = "PAKISTAN")
    public WebElement country;


    @FindBy(css = "NisumAddress")
    public WebElement nisumAddress;

    @FindBy(id = "pills-pakistan")
    public  WebElement mainDivNisum;

    public NisumSite() {

        PageFactory.initElements(driver,this);
    }
    public void clickOnCountryOption() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("block-block-6")));
        country.isDisplayed();
        country.click();
    }





}
