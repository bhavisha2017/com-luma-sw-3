package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     *
     * This method will select an element
     */
    public void selectMyAccountOptions(String option){
        driver.findElement(By.linkText(option)).click();
    }
    /**
     * This method will select menu
     */
    public void selectMenu(String menu) {
        driver.findElement(By.linkText(menu)).click();
    }
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {//generic method
        driver.findElement(by).click();
    }
    /**
     *
     *This method will send an element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
    /**
     *
     *This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    /**
     *
     *This method will select an element dropdown
     */
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    /**
     *
     *This method will very the text
     */
    public void verifyingTheText(String expectedMessage, String actualMessage){
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    /**
     *
     * This method will hover over an element
     */
    public void hoverAndClickOnElements(WebElement hoverElement, WebElement clickElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).moveToElement(clickElement).click().build().perform();
    }
    /**
     *
     * This method will hover over an element
     */
    public void hoverAndClickOnElements1(WebElement hoverElement1, WebElement hoverElement2, WebElement clickElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement1).moveToElement(hoverElement2).moveToElement(clickElement).click().build().perform();
    }

    /**
     * This method will clear quantity from element
     */
    public void clearQty(By by)
    {
        driver.findElement(by).clear();
    }
    /**
     * This method will verify text displayed on web page
     */
    public void verifyText(String expectedMessage, By by, String displayMessage) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }
}
