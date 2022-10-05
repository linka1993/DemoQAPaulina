package org.project.basic;


import org.junit.jupiter.api.AfterEach;

public class Base {



    @AfterEach
    public void quit() {
        WebDriverPool.getWebDriver().quit();
    }
}
