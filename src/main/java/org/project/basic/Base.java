package org.project.basic;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class Base {

/*    @BeforeEach
    public void init(){ WebDriverPool.getWebDriver("chrome"); }*/
    @AfterAll
    public static void quit() {
        WebDriverPool.getWebDriver().quit();
    }
}
