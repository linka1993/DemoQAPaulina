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
    Menu menu = new Menu();

    // Define Elements on Page

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

    @FindBy(css = "label#userName-label")
    WebElement userNameLabel;

    @FindBy(css = "label#userName-value")
    WebElement userNameDisplay;

    @FindBy(xpath = "//button[text()='Log out']")
    WebElement logoutButton;

    // Define Methods on Page


    public void checkSearchFunctionality(String title){
        Integer beforeSearching = listOfBooks.size();
        searchInput.sendKeys(title);
        Integer afterSearching = listOfBooks.size();
        myAssertion.biggerValue(beforeSearching, afterSearching);
        myAssertion.assertValuesInList(title, listOfBooks);
    }

    public void checkIfUserLoggedOut(){
        myAssertion.notVisible(userNameLabel);
        myAssertion.notVisible(userNameDisplay);
        loginPageButton.isDisplayed();
    }

    public void enterLoginPage(){
        loginPageButton.click();
    }

    public void checkIfUserLoggedIn(String userName){
        userNameLabel.isDisplayed();
        myAssertion.assertValues(userName, userNameDisplay);
    }

    public void logOut(){
        logoutButton.isDisplayed();
        logoutButton.click();
    }
}

