package org.project.basic;
import org.openqa.selenium.support.PageFactory;

public class PageObject extends WebDriverPool {
    public PageObject() {
        PageFactory.initElements(WebDriverPool.getWebDriver("chrome"), this);
    }
}
