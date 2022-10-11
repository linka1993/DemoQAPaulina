package org.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.project.basic.PageObject;
import org.project.utilities.MyAssertion;
import org.project.utilities.MyWait;

public class ProfilePage extends PageObject {

    MyWait myWait = new MyWait();
    MyAssertion myAssertion = new MyAssertion();

    // Define Elements on Page
    @FindBy(css = "div.playgound-header")
    WebElement profileBanner;


    // Define Methods on Page
    public void checkIfProfilePageIsLoaded(){
        myWait.pollingUntilVisibilityOfElement(1, 15, profileBanner);
        myAssertion.assertValues("Profile", profileBanner);

    }
}
