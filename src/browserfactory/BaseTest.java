package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public static String baseURL = "https://magento.softwaretestingboard.com/";

    public void openBrowser(String baseURL){
        driver = new ChromeDriver();
        //launch the url
        driver.get(baseURL);
        //maximise the window
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){
        driver.close();
    }

}
