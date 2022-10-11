package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;
import org.project.basic.Base;
import org.project.pages.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookStoreTest extends Base {



    // Creating objects for pages
    Menu menu = new Menu();
    HomePage homePage = new HomePage();
    BookStorePage bookStorePage = new BookStorePage();
    LoginPage loginPage = new LoginPage();

    ProfilePage profilePage = new ProfilePage();


    String userName = "marietester1";
    String password = "P@ssw0rd1";
    String bookTitle = "JavaScript";

    // Steps
    @Test
    @Order(1)
    @DisplayName("Checking Search Functionality")
    void searchFunctionality(){
        homePage.openPage();
        homePage.checkIfHomeBannerDisplayed();
        homePage.enterBookStore();
        menu.checkIfPageLoaded("Book Store");
        bookStorePage.checkSearchFunctionality(bookTitle);
    }

    @Test
    @Order(2)
    @DisplayName("Checking Login Functionality")
    void loginFlow(){
        homePage.openPage();
        homePage.checkIfHomeBannerDisplayed();
        homePage.enterBookStore();
        menu.checkIfPageLoaded("Book Store");
        bookStorePage.enterLoginPage();
        menu.checkIfPageLoaded("Login");
        loginPage.checkWelcomeLabels();
        loginPage.logIn(userName, password);
        menu.checkIfPageLoaded("Book Store");
        bookStorePage.checkIfUserLoggedIn(userName);

    }

    @Test
    @Order(3)
    @DisplayName("Logging out user")
    void logout(){
        bookStorePage.logOut();
        menu.checkIfPageLoaded("Login");
        menu.openBookStorePage();
        bookStorePage.checkIfUserLoggedOut();
    }

}
