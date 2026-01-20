import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoWebShopFindElementsTest {

    WebDriver driver;

    // BEFORE
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // TEST
    @Test
    public void findTenElementsByDifferentLocators() {

        // ===== TAG NAME (4 элемента) =====
        WebElement tag1 = driver.findElement(By.tagName("body"));
        WebElement tag2 = driver.findElement(By.tagName("div"));
        WebElement tag3 = driver.findElement(By.tagName("a"));
        WebElement tag4 = driver.findElement(By.tagName("input"));

        System.out.println(tag1.getTagName());
        System.out.println(tag2.getTagName());
        System.out.println(tag3.getAttribute("href"));
        System.out.println(tag4.getAttribute("type"));

        // ===== ID (3 элемента) =====
        WebElement id1 = driver.findElement(By.id("small-searchterms"));
        WebElement id2 = driver.findElement(By.id("topcartlink"));
        WebElement id3 = driver.findElement(By.id("newsletter-email"));

        System.out.println(id1.getAttribute("id"));
        System.out.println(id2.getAttribute("id"));
        System.out.println(id3.getAttribute("id"));

        // ===== CLASS NAME (3 элемента) =====
        WebElement class1 = driver.findElement(By.className("header-logo"));
        WebElement class2 = driver.findElement(By.className("search-box"));
        WebElement class3 = driver.findElement(By.className("footer"));

        System.out.println(class1.getText());
        System.out.println(class2.getText());
        System.out.println(class3.getText());
    }

    // AFTER
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}