package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.project.basic.Base;
import org.project.pages.BookStorePage;
import org.project.pages.HomePage;
import org.project.pages.LoginPage;
import org.project.pages.ProfilePage;

public class BookStoreTest extends Base {



    // Creating objects for pages
    HomePage homePage = new HomePage();
    BookStorePage bookStorePage = new BookStorePage();
    LoginPage loginPage = new LoginPage();

    ProfilePage profilePage = new ProfilePage();

    String userName = "marietester1";
    String password = "P@ssw0rd1";
    String bookTitle = "JavaScript";

    // Steps


    @Test
    @DisplayName("Checking Login Functionality")
    void loginFlow(){
        homePage.openPage();
        homePage.checkIfHomeBannerDisplayed();
        homePage.enterBookStore();
        bookStorePage.checkIfBookStoreLoaded();
        bookStorePage.enterLoginPage();
        loginPage.checkIfLoginPageLoaded();
        loginPage.checkWelcomeLabels();
        loginPage.logIn(userName, password);
        bookStorePage.checkIfBookStoreLoaded();

    }

    @Test
    @DisplayName("Checking Search Functionality")
    void searchFunctionality(){
        homePage.openPage();
        homePage.checkIfHomeBannerDisplayed();
        homePage.enterBookStore();
        bookStorePage.checkIfBookStoreLoaded();
        bookStorePage.checkSearchFunctionality("JavaScript");
    }

}
