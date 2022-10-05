package tests;

import org.junit.jupiter.api.Test;
import org.project.basic.Base;
import org.project.pages.HomePage;

public class BookStoreTest extends Base {



    // Creating objects for pages
    HomePage homePage = new HomePage();

    // Steps
    @Test
    void checkElement(){
        homePage.openPage();
        homePage.checkIfHomeBannerDisplayed();
    }

}
