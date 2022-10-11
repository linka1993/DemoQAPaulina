package org.project.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.project.basic.WebDriverPool;

import java.time.Duration;
import java.util.List;

public class MyAssertion {

    WebDriverWait wait = new WebDriverWait(WebDriverPool.getWebDriver(), Duration.ofSeconds(5));

    public void assertValues(String element, WebElement source){
        String sourcetext = source.getText();
        if (!sourcetext.contains(element)){
            throw new NoSuchElementException(String.format("Expected '%s' in '%s' -> Actual '%s'",element, source, sourcetext));
        }
    }


    public void assertValues(Float arg1, Float arg2){
        if (!arg1.equals(arg2)){
            throw new AssertionError(String.format("%s isn't equal %s",arg1, arg2));
        }
    }

    public void assertValuesInList(String title, List<WebElement> listOfElements){
        for(WebElement element : listOfElements){
            assertValues(title,element);
        }
    }

    public void hasClass(WebElement element, String className) {
        String elementClass = element.getAttribute("class");
        if(!elementClass.contains(className)){
            throw new NoSuchElementException(String.format("%s isn't in %s", className, elementClass));
        }
    }

    public void hasNotClass(WebElement element, String className) {
        String elementClass = element.getAttribute("class");
        if(elementClass.contains(className)){
            throw new NoSuchElementException(String.format("%s is in %s", className, elementClass));
        }
    }

    public void biggerValue(Integer biggerValue, Integer smallerValue){
        if(smallerValue>biggerValue){
            throw new AssertionError(String.format("%s is smaller than %s", biggerValue, smallerValue));
        } else if (smallerValue.equals(biggerValue)){
            throw new AssertionError(String.format("Both values %s and %s are the same", biggerValue, smallerValue));
        }
    }

    public boolean notVisible(WebElement element){
        try{
            if(element.isDisplayed()){
                throw new AssertionError(String.format("Element %s is still visible on page",element.getTagName()));
            }

        }catch (NoSuchElementException e){
            return true;

        }
        return true;
    }


}
