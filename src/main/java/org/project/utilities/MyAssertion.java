package org.project.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAssertion {

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
        } else if (smallerValue==biggerValue){
            throw new AssertionError(String.format("Both values are the same", biggerValue, smallerValue));
        }
    }

    // TODO 3 - Asercje dla listy elementów

}
