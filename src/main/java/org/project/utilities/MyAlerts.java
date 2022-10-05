package org.project.utilities;

import org.openqa.selenium.WebDriver;
import org.project.basic.WebDriverPool;

public class MyAlerts  {

    WebDriver driver = WebDriverPool.getWebDriver();
    MyWait myWait = new MyWait();

    public void acceptAlert(){
        myWait.pollingUntilVisibilityOfAlert(1,15);
        driver.switchTo().alert().accept();
    }

}
