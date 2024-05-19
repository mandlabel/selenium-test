import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    private By emailField = By.xpath("//*[@id=\"app-layout\"]/div/div[2]/div/div/div/form/div[1]/div/input");
    private By passwordField = By.xpath("//*[@id=\"app-layout\"]/div/div[2]/div/div/div/form/div[2]/div/input");
    private By loginButton = By.xpath("//*[@id=\"app-layout\"]/div/div[2]/div/div/div/form/div[4]/div/button");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.freefileconvert.com/login");
    }

    public HomePage login(String email, String password) {
        this.waitAndReturnElement(emailField).sendKeys(email);
        this.waitAndReturnElement(passwordField).sendKeys(password);
        this.waitAndReturnElement(loginButton).click();
        return new HomePage(this.driver);
    }
}
