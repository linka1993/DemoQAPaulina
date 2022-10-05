package org.project.basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.project.utilities.EventCapture;

public class WebDriverPool {
    static WebDriver driver;
    static WebDriver driverDecorated;

    public static WebDriver getWebDriver(String driverName) {
        switch(driverName.toLowerCase()) {
            case "chrome":
                driver = getChromeDriver();
                break;
            case "firefox":
                //driver = getFirefoxDriver();
                break;
            case "edge":
                //driver = getEdgeDriver();
                break;
            default:
                throw new NoSuchElementException("Wrong WebDriver name");
        }

        WebDriverListener listener = new EventCapture();
        driverDecorated = new EventFiringDecorator(listener).decorate(driver);

        driverDecorated.manage().window().maximize();
        return driverDecorated;
    }

    public static WebDriver getWebDriver() {
        return driverDecorated;
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

}
