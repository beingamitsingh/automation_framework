package framework;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;

public class Driver {
    
    public static void get(String url) {
        open(url);
    }

    public static String getCurrentUrl() {
        return null;
    }

    public static String getTitle() {
        return null;
    }

    public static ElementsCollection findElements(String elementName) {
        ElementsCollection elements = null;
        ArrayList<String> objectData = Harness.allObjects.get(elementName);

        try {
            switch (objectData.get(0)) {
                case "ID":
                    elements = $$(By.id(objectData.get(1)));
                    break;
                case "ClassName":
                    elements = $$(By.className(objectData.get(1)));
                    break;
                case "LinkText":
                    elements = $$(By.linkText(objectData.get(1)));
                    break;
                case "CSS_Selector":
                    elements = $$(By.cssSelector(objectData.get(1)));
                    break;
                case "TagName":
                    elements = $$(By.tagName(objectData.get(1)));
                    break;
                case "Name":
                    elements = $$(By.name(objectData.get(1)));
                    break;
                case "PartialLinkText":
                    elements = $$(By.partialLinkText(objectData.get(1)));
                    break;
                case "Xpath":
                    elements = $$(By.xpath(objectData.get(1)));
                    break;
                default:
                    System.out.println("Wrong locator-type selected in data sheet -" + objectData.get(0));
                    break;
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return elements;
    }

    public static SelenideElement findElement(String elementName) {
        SelenideElement element = null;
        ArrayList<String> objectData = Harness.allObjects.get(elementName);

        try {
            switch (objectData.get(0)) {
                case "ID":
                    element = $(By.id(objectData.get(1)));
                    break;
                case "ClassName":
                    element = $(By.className(objectData.get(1)));
                    break;
                case "LinkText":
                    element = $(By.linkText(objectData.get(1)));
                    break;
                case "CSS_Selector":
                    element = $(By.cssSelector(objectData.get(1)));
                    break;
                case "TagName":
                    element = $(By.tagName(objectData.get(1)));
                    break;
                case "Name":
                    element = $(By.name(objectData.get(1)));
                    break;
                case "PartialLinkText":
                    element = $(By.partialLinkText(objectData.get(1)));
                    break;
                case "Xpath":
                    element = $(By.xpath(objectData.get(1)));
                    break;
                default:
                    System.out.println("Wrong locator-type selected in data sheet -" + objectData.get(0));
                    break;
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public static String getPageSource() {
        return null;
    }

    public static void close() {

    }

    public static void quit() {

    }

    public static Set<String> getWindowHandles() {
        return null;
    }

    public static String getWindowHandle() {
        return null;
    }

    public static TargetLocator switchTo() {
        return null;
    }

    public static Navigation navigate() {
        return null;
    }

    public static Options manage() {
        return null;
    }

    public static WebElement getElement(String elementName) {
        WebElement webElement = null;
        ArrayList<String> objectData = Harness.allObjects.get(elementName);

        try {
            switch (objectData.get(0)) {
                case "ID":
                    webElement = $(By.id(objectData.get(1)));
                    break;
                case "ClassName":
                    webElement = $(By.className(objectData.get(1)));
                    break;
                case "LinkText":
                    webElement = $(By.linkText(objectData.get(1)));
                    break;
                case "CSS_Selector":
                    webElement = $(By.cssSelector(objectData.get(1)));
                    break;
                case "TagName":
                    webElement = $(By.tagName(objectData.get(1)));
                    break;
                case "Name":
                    webElement = $(By.name(objectData.get(1)));
                    break;
                case "PartialLinkText":
                    webElement = $(By.partialLinkText(objectData.get(1)));
                    break;
                case "Xpath":
                    webElement = $(By.xpath(objectData.get(1)));
                    break;
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return webElement;
    }

}
