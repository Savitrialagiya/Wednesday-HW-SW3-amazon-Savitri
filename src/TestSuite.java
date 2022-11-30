import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {

    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatThe30ProductsAreDisplayedOnThePage() {
        //Type "Dell Laptop" in the search box and press enter or click on search Button.
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));

        //Click on the checkbox brand dell on the left side.
        clickOnElement(By.xpath("//span[@class='a-size-base a-color-base' and contains(text(),'Dell')]"));

        //Verify that the  30(May be different) products are displayed on the page.
        int expectedNumber = 24;
        List<WebElement> list = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        int actualNumber = list.size();
        System.out.println("Number of products per page: " + actualNumber);
        Assert.assertEquals(expectedNumber, actualNumber);

        //Print all product names in the console.
        List<WebElement> names = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement name: names) {
            System.out.println(name.getText());
        }

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
