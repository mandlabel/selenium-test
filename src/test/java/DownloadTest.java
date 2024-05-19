import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class DownloadTest extends MainTest {

    public List<WebElement> testFindDownloadButtons() {
        List<WebElement> downloadButtons = driver.findElements(By.xpath("//a[contains(@class, 'download') and contains(text(), 'Download')]"));

        System.out.println(downloadButtons.size());
        return downloadButtons;
    }

    @Test
    public void testDownloadFile() {
        LoginPage loginPage = new LoginPage(this.driver);
        HomePage homePage = loginPage.login(this.email, this.pw);
        homePage.goToDownloadPage();
        homePage.downloadMultipleElements(testFindDownloadButtons());
    }
}
