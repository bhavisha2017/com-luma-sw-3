package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class MenTest extends Utility {

    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        //Mouse Hover on Men Menu
        //Mouse Hover on Bottoms
        // Click on Pants
        WebElement men = driver.findElement(By.xpath("//span[normalize-space()='Men']"));
        WebElement bottoms = driver.findElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        WebElement pants = driver.findElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        hoverAndClickOnElement1(men,bottoms,pants);

        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        WebElement cronusYogaPant = driver.findElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        WebElement size32 = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        hoverAndClickOnElements(cronusYogaPant,size32);

        // Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        WebElement black = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        WebElement addToCart = driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));
        hoverAndClickOnElements(cronusYogaPant,black);
        hoverAndClickOnElements(cronusYogaPant,addToCart);


        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String actualMessage = getTextFromElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals("Error message not displayed", "You added Cronus Yoga Pant to your shopping cart.", actualMessage);

        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //* Verify the text ‘Shopping Cart.’
        String actualMessage1 = getTextFromElement(By.xpath("//span[@class='base']"));
        verifyingTheText("Shopping Cart",actualMessage1);

        //* Verify the product name ‘Cronus Yoga Pant’
        String actualMessage2 = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        verifyingTheText("Cronus Yoga Pant",actualMessage2);

        //* Verify the product size ‘32’
        String actualMessage3 = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        verifyingTheText("32",actualMessage3);

        //* Verify the product colour ‘Black’
        String actualMessage4 = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        verifyingTheText("Black",actualMessage4);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}