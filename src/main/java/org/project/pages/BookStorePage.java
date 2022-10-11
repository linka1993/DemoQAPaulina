package org.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.project.basic.PageObject;
import org.project.utilities.JavaScript;
import org.project.utilities.MyAssertion;
import org.project.utilities.MyWait;

import java.util.List;

public class BookStorePage extends PageObject {

    MyWait myWait = new MyWait();
    JavaScript js = new JavaScript();
    MyAssertion myAssertion = new MyAssertion();


    // Define Elements on Page
    @FindBy(css = "div.playgound-header")
    WebElement bookStoreBanner;

    @FindBy(css = "input#searchBox")
    WebElement searchInput;

    @FindBy(xpath = "//div[@class='rt-tr-group']//div[@class='action-buttons']//a")
    List<WebElement> listOfBooks;

    @FindBy(xpath = "//div[@class='rt-tr-group'][1]//a")
    WebElement firstElementOfList;

    @FindBy(css = "button#login")
    WebElement loginPageButton;

    @FindBy(xpath = "//button[text()='Add To Your Collection']")
    WebElement addToCollection;

    @FindBy(xpath = "//button[text()='Back To Book Store']")
    WebElement backToBookStore;

    @FindBy(xpath = "//span[text()='Profile']//parent::li")
    WebElement profileLink;

    // Define Methods on Page
    public void checkIfBookStoreLoaded(){
        myWait.pollingUntilVisibilityOfElement(1, 10, bookStoreBanner);
        myAssertion.assertValues("Book Store", bookStoreBanner);
    }

    public void checkSearchFunctionality(String title){
        Integer beforeSearching = listOfBooks.size();
        searchInput.sendKeys(title);
        Integer afterSearching = listOfBooks.size();
        myAssertion.biggerValue(beforeSearching, afterSearching);
        myAssertion.assertValuesInList(title, listOfBooks);
        System.out.println("Done");
    }

    public void enterLoginPage(){
        loginPageButton.click();
    }
}
