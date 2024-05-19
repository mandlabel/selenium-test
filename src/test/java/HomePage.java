import org.openqa.selenium.support.ui.Select;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase {

    private By profileButton = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/a");
    private By logoutButton = By.xpath("//a[@href='https://www.freefileconvert.com/logout']");
    private By overlay = By.xpath("/html/body/div[3]/div[2]/div[1]/div[3]/div[2]/button[1]/p"); // Adjust the XPath if necessary
    private By uploadButton = By.xpath("//input[@type='file' and @name='input_files[]']");
    private By formatDropdown = By.xpath("//*[@id='file-input-form']/div/div[2]/div/select");
    private By formatButton = By.xpath("//*[@id=\"file-input-form\"]/div/div[3]/div/input");
    private By dashboardButton = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/ul/li[1]/a");
    private By toolsMenu = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[2]/a");
    private By splitterOption = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[2]/ul/li[3]/a");
    private By fileUploadButtonForPDFSplitting = By.xpath("//*[@id=\"first_file\"]");
    private By splitRange = By.xpath("//*[@id=\"range\"]");
    private By formElement = By.xpath("//*[@id=\"file-input-form\"]");    

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logout() {
        var overlayElement = this.waitAndReturnElement(overlay);
        if(overlayElement != null) {
            overlayElement.click();
        }

        this.waitAndReturnElement(profileButton).click();
        this.waitAndReturnElement(logoutButton).click();
        return new LoginPage(this.driver);
    }

    public void uploadFile(String filePath) {
        System.out.println("File path: " + filePath);
        
        var overlayElement = this.waitAndReturnElement(overlay);
        if(overlayElement != null) {
            overlayElement.click();
        }

        this.waitAndReturnElement(uploadButton).sendKeys(filePath);
    }

    public void selectFormat(String format) {
        WebElement dropdownElement = this.waitAndReturnElement(formatDropdown);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(format);
    }

    public void readyToConvert() {
        this.waitAndReturnElement(formatButton).click();
    }

    public void goToDownloadPage() {
        var overlayElement = this.waitAndReturnElement(overlay);
        if(overlayElement != null) {
            overlayElement.click();
        }
        this.waitAndReturnElement(profileButton).click();
        this.waitAndReturnElement(dashboardButton).click();
    }

    public void downloadMultipleElements(List<WebElement> list) {
        System.out.println("Downloading " + list.size() + " element...");
        list.forEach(element -> {
            element.click();
        });
    }

    public String getPageTitle() {
        return this.driver.getTitle();
    }

    public void navigateToSplitForm() {
        
        var overlayElement = this.waitAndReturnElement(overlay);
        if(overlayElement != null) {
            overlayElement.click();
        }
        
        this.waitAndReturnElement(toolsMenu).click();
        this.waitAndReturnElement(splitterOption).click();
    }

    public void fileUploadForSplitting(String filePath) {
        this.waitAndReturnElement(fileUploadButtonForPDFSplitting).sendKeys(filePath);
    }

    public void setSplitRange(String range) {
        this.waitAndReturnElement(splitRange).sendKeys(range);
    }

    public void beginSplitting() {
        this.waitAndReturnElement(formElement).submit();
    }

}
