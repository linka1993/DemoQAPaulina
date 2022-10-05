package org.project.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.project.basic.WebDriverPool;

public class JavaScript {
    private final JavascriptExecutor jsExecutor;

    public JavaScript() {
        jsExecutor = (JavascriptExecutor) WebDriverPool.getWebDriver();
    }

    public void scrollToElement(WebElement element) {
        disallowNullElement(element);
        executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scroll(int x, int y) {
        executeScript("window.scrollBy(arguments[0],arguments[1])", x, y);
    }

    public Object executeScript(String script, Object... arguments) {
        return jsExecutor.executeScript(script, arguments);
    }

    private void disallowNullElement(WebElement element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot execute script because of null element!");
        }
    }
}
