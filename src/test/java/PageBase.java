import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;


class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    
    protected WebElement waitAndReturnElement(By locator) {
        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return this.driver.findElement(locator);
        } catch (TimeoutException e) {
            System.out.println("Element not found: " + locator);
            return null;
        }
    }
    
    public String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
        return bodyElement.getText();
    }
   
}
