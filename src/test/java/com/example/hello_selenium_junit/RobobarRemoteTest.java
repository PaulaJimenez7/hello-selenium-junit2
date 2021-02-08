package com.example.hello_selenium_junit;

// Generated by Selenium IDE
        import static org.hamcrest.CoreMatchers.is;
        import static org.hamcrest.core.IsNot.not;
        import static org.junit.jupiter.api.Assertions.assertEquals;
        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxOptions;
        import org.openqa.selenium.remote.RemoteWebDriver;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.Dimension;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.Alert;
        import org.openqa.selenium.Keys;
        import java.util.*;
        import java.net.MalformedURLException;
        import java.net.URL;

public class RobobarRemoteTest{
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() throws MalformedURLException{
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444"), chromeOptions);

        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void robobar() {

        driver.get("http://10.250.13.1:3000/");
        WebElement roboresult = new WebDriverWait(driver,7)
                .until(driver -> driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")));
        vars.put("total", driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText());
        assertEquals(vars.get("total").toString(), "€0.00");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > td .input-group-append > .btn")).click();
        vars.put("total", driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText());
        assertEquals(vars.get("total").toString(), "€1.25");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td .input-group-append > .btn")).click();
        vars.put("total", driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText());
        assertEquals(vars.get("total").toString(), "€3.25");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(3) .input-group-append > .btn")).click();
        vars.put("total", driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText());
        assertEquals(vars.get("total").toString(), "€6.25");
        driver.findElement(By.cssSelector(".btn-success")).click();
        WebElement robresult = new WebDriverWait(driver,7)
                .until(driver -> driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(3)")));
        vars.put("precio", driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(3)")).getText());
        assertEquals(vars.get("precio").toString(), "€1.25");
        vars.put("precioBeer", driver.findElement(By.cssSelector(".ng-scope:nth-child(2) >.ng-binding:nth-child(3)")).getText());
        assertEquals(vars.get("precioBeer").toString(), "€2.00");
        vars.put("precioWine", driver.findElement(By.cssSelector(".ng-scope:nth-child(3) > .ng-binding:nth-child(3)")).getText());
        assertEquals(vars.get("precioWine").toString(), "€3.00");
        driver.findElement(By.id("ageInput")).click();
        driver.findElement(By.id("ageInput")).sendKeys("25");
        driver.findElement(By.cssSelector(".btn-success")).click();
        WebElement roresult = new WebDriverWait(driver,7)
                .until(driver -> driver.findElement(By.xpath("/html/body/robo-robobar/div/div[2]/robo-success/div[1]/h2")));
        vars.put("total-bebidas", driver.findElement(By.xpath("/html/body/robo-robobar/div/div[2]/robo-success/div[1]/h2")).getText());
        assertEquals(vars.get("total-bebidas").toString(), "3 drinks");
    }
}