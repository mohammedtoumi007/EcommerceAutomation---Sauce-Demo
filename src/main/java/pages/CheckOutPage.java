package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

public class CheckOutPage {
    WebDriver driver;
    WebDriverWait wait;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators
    private final By checkOutButton = By.id("checkout");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By checkOutCompilationMessage = By.cssSelector(".complete-text");

    private String expectedMessage = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

    public CheckOutPage checkOut(String fname, String lname, String pcode){
    driver.findElement(checkOutButton).click();

    // CheckOut information
    wait.until(ExpectedConditions.invisibilityOfElementLocated(firstName));
    driver.findElement(firstName).sendKeys(fname);
    driver.findElement(lastName).sendKeys(lname);
    driver.findElement(postalCode).sendKeys(pcode);
    driver.findElement(continueButton).click();

    // checkOut Overview
    driver.findElement(finishButton).click();
    WebElement message = driver.findElement(checkOutCompilationMessage);
    assertEquals(message.getText(),expectedMessage, "Confirmation message mismatch");

    return this;
    }
}