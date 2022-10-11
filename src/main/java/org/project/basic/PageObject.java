package org.project.basic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject extends WebDriverPool{

    //public WebDriver driver = getWebDriver();
    public PageObject() {
        PageFactory.initElements(getWebDriver(), this);
    }
}
