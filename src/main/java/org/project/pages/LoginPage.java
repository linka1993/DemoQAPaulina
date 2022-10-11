package org.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.project.basic.PageObject;
import org.project.utilities.JavaScript;
import org.project.utilities.MyAssertion;
import org.project.utilities.MyWait;

public class LoginPage extends PageObject {

    MyWait myWait = new MyWait();
    MyAssertion myAssertion = new MyAssertion();
    JavaScript js = new JavaScript();


    // Define Elements on Page
    @FindBy (css = "div h2")
    WebElement welcomeSign;

    @FindBy(css ="div h5")
    WebElement welcomeLabel;

    @FindBy(css = "input#userName")
    WebElement userNameInput;

    @FindBy(css = "input#password")
    WebElement passwordInput;

    @FindBy(css = "button#login")
    WebElement loginButton;

    @FindBy(css = "button#newUser")
    WebElement newUserButton;


    // Define Methods on Page

     public void checkWelcomeLabels(){
         myAssertion.assertValues("Welcome,", welcomeSign);
         myAssertion.assertValues("Login in Book Store", welcomeLabel);
     }

     public void logIn(String userName, String password){
         userNameInput.sendKeys(userName);
         passwordInput.sendKeys(password);
         js.scrollToElement(loginButton);
         loginButton.click();
     }

}
