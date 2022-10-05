package org.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.project.basic.PageObject;
import org.project.basic.WebDriverPool;
import org.project.utilities.MyWait;


public class HomePage extends PageObject {

    MyWait myWait = new MyWait();
    WebDriver driver = WebDriverPool.getWebDriver();

    // Define Start page
    String URL = "https://demoqa.com/";


     // Define Elements on Page
    @FindBy(css = "div.home-banner")
    WebElement homebanner;


    // Define Methods on Page
    public void openPage(){
        driver.get(URL);
    }

    public void checkIfHomeBannerDisplayed(){
        myWait.pollingUntilVisibilityOfElement(1,15,homebanner);
    }

}
