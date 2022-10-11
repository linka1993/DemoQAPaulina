package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.project.basic.Base;
import org.project.basic.PageObject;
import org.project.basic.WebDriverPool;
import org.project.utilities.JavaScript;
import org.project.utilities.MyWait;

import java.time.Duration;


public class HomePage extends PageObject {

    MyWait myWait = new MyWait();
    WebDriver driver = WebDriverPool.getWebDriver();
    JavaScript js = new JavaScript();
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Define Start page
    String URL = "https://demoqa.com/";


     // Define Elements on Page
    @FindBy(css = "div.home-banner")
    private WebElement homebanner;

    @FindBy(xpath = "//h5[text()='Book Store Application']/ancestor::div[contains(@class,'top-card')]")
    WebElement bookStoreCard;


    // Define Methods on Page
    public void openPage(){
        driver.get(URL);
    }

    public void checkIfHomeBannerDisplayed(){
        myWait.pollingUntilVisibilityOfElement(1,15,homebanner);
    }

    public void enterBookStore(){
        js.scrollToElement(bookStoreCard);
        bookStoreCard.click();
    }

}
