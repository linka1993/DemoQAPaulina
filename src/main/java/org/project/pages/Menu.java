package org.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.project.basic.PageObject;
import org.project.utilities.JavaScript;
import org.project.utilities.MyAssertion;
import org.project.utilities.MyWait;

public class Menu extends PageObject {

    JavaScript js = new JavaScript();
    MyAssertion myAssertion = new MyAssertion();
    MyWait myWait = new MyWait();

    // Define Elements on Page

    @FindBy(xpath = "//li/span[text()='Login']/ancestor::div[@class='element-group']")
    WebElement loginLink;

    @FindBy(xpath = "//li/span[text()='Book Store']/ancestor::div[@class='element-group']")
    WebElement bookStoreLink;

    @FindBy(xpath = "//li/span[text()='Profile']/ancestor::div[@class='element-group']")
    WebElement profileLink;

    @FindBy(css = "div.playgound-header")
    WebElement bookStoreBanner;

    // Define Methods on Page
    public void openBookStorePage(){
        js.scrollToElement(bookStoreLink);
        bookStoreLink.click();
        myAssertion.assertValues("Book Store", bookStoreBanner);
    }

    public void openLoginPage(){
        js.scrollToElement(loginLink);
        bookStoreLink.click();
        myAssertion.assertValues("Login", bookStoreBanner);
    }
    public void openProfilePage(){
        js.scrollToElement(profileLink);
        bookStoreLink.click();
        myAssertion.assertValues("Profile", bookStoreBanner);
    }

    public void checkIfPageLoaded(String page){
        myWait.pollingUntilVisibilityOfElement(1, 10, bookStoreBanner);
        myAssertion.assertValues(page, bookStoreBanner);
    }


}
