package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class GearTest extends Utility {
    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }
    @Test
    public void userShouldAddProductSuccessfullyToShoppingCart() throws InterruptedException {
         Thread.sleep(2000);
        //Mouse Hover on Gear Menu
        // Click on Bags
        WebElement gear = driver.findElement(By.xpath("//span[normalize-space()='Gear']"));
        WebElement bags = driver.findElement(By.xpath("//a[@id='ui-id-25']//span[contains(text(),'Bags')]"));
        hoverAndClickOnElements(gear,bags);

        // Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));

        // Verify the text ‘Overnight Duffle’
        String actualMessage = getTextFromElement(By.xpath("//span[@class='base']"));
        verifyingTheText( "Overnight Duffle", actualMessage);

        // Change Qty 3
        By qut1 = By.xpath("//input[@id='qty']");
        sendTextToElement(qut1,"3");

        // Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));

        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String actualMessage1 = getTextFromElement(By.xpath("//div[@class='message-success success message']"));
        verifyingTheText( "You added Overnight Duffle to your shopping cart.", actualMessage1);

        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        Thread.sleep(2000);

        // Verify the product name ‘Overnight Duffle’
        String actualMessage2 = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        verifyingTheText("Overnight Duffle",actualMessage2);

        // Verify the Qty is ‘3’
        String actualMessage3 = getTextFromElement(By.xpath("//span[@class='counter-number']"));
        verifyingTheText("3",actualMessage3);


        // Verify the product price ‘$135.00’
        String actualMessage4 = getTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"));
        verifyingTheText("$135.00",actualMessage4);
        Thread.sleep(2000);

        // Change Qty to ‘5’
        sendTextToElement(By.xpath("//div[@class='control qty']//input[@type='number']"),"5");

      // Click on ‘Update Shopping Cart’ button
      clickOnElement(By.xpath("//button[@name='update_cart_action'][2]"));

        // Verify the product price ‘$225.00
        String actualMessage5 = getTextFromElement(By.xpath("//span[contains(text(),'$225.00')]"));
        verifyingTheText("$225.00",actualMessage5);
        Thread.sleep(200);
    }
    @After
    public void tearDown(){
      closeBrowser();
    }
}
