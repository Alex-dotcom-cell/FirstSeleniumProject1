import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindElementByCssSelectorHomework {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.tricentis.com/solutions/speed");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void findSameElementsByCssSelector() {

        // ===== elements previously found by TAG =====
        // tag: h1  -> css: h1
        WebElement header = driver.findElement(By.cssSelector("h1"));
        System.out.println("H1 text: " + header.getText());

        // tag: p -> css: p
        WebElement paragraph = driver.findElement(By.cssSelector("p"));
        System.out.println("Paragraph text: " + paragraph.getText());


        // ===== elements previously found by ID =====
        // id: search-input -> css: #search-input
        WebElement searchInput = driver.findElement(By.cssSelector("#search-input"));
        System.out.println("Search input id: " + searchInput.getAttribute("id"));


        // ===== elements previously found by CLASS =====
        // class: button-primary -> css: .button-primary
        WebElement button = driver.findElement(By.cssSelector(".button-primary"));
        System.out.println("Button text: " + button.getText());

        // class: container -> css: .container
        WebElement container = driver.findElement(By.cssSelector(".container"));
        System.out.println("Container displayed: " + container.isDisplayed());
    }
}