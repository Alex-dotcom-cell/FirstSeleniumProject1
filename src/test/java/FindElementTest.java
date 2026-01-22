import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ================= TAG =================
    @Test
    public void findElementByTagName() {

        driver.get("https://ilcarro.web.app");

        WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println(h1.getText());

        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Links count: " + links.size());
    }

    // ================= ID =================
    @Test
    public void findElementById() {

        driver.get("https://ilcarro.web.app");

        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getAttribute("id"));
    }

    // ================= CLASS =================
    @Test
    public void findElementByClassName() {

        driver.get("https://ilcarro.web.app");

        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement description = driver.findElement(By.className("description"));
        System.out.println(description.getText());
    }

    // ================= CSS SELECTOR (DemoWebShop) =================
    @Test
    public void findSameElementsByCssSelector_DemoWebShop() {

        driver.get("https://demowebshop.tricentis.com/");

        // TAG -> input
        WebElement input = driver.findElement(By.cssSelector("input"));
        System.out.println("Input displayed: " + input.isDisplayed());

        // ID -> #small-searchterms
        WebElement searchInput =
                driver.findElement(By.cssSelector("#small-searchterms"));
        System.out.println("Search input id: " + searchInput.getAttribute("id"));

        // CLASS -> .header-logo
        WebElement logo =
                driver.findElement(By.cssSelector(".header-logo"));
        System.out.println("Logo displayed: " + logo.isDisplayed());

        // CLASS -> .cart-label
        WebElement cart =
                driver.findElement(By.cssSelector(".cart-label"));
        System.out.println("Cart text: " + cart.getText());
    }

    // ================= XPATH (DemoWebShop) =================
    @Test
    public void findSameElementsByXpath_DemoWebShop() {

        driver.get("https://demowebshop.tricentis.com/");

        // TAG -> //input
        WebElement input =
                driver.findElement(By.xpath("//input"));
        System.out.println("Input displayed: " + input.isDisplayed());

        // ID -> //input[@id='small-searchterms']
        WebElement searchInput =
                driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        System.out.println("Search input id: " + searchInput.getAttribute("id"));

        // CLASS -> //*[@class='header-logo']
        WebElement logo =
                driver.findElement(By.xpath("//*[@class='header-logo']"));
        System.out.println("Logo displayed: " + logo.isDisplayed());

        // CLASS -> //*[@class='cart-label']
        WebElement cart =
                driver.findElement(By.xpath("//*[@class='cart-label']"));
        System.out.println("Cart text: " + cart.getText());
    }
}