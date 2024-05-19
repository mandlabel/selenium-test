
import org.junit.Assert;
import org.junit.Test;

import java.io.File;


public class FileConversionTest extends MainTest {

    @Test
    public void testFileConversion() {
        LoginPage loginPage = new LoginPage(this.driver);
        HomePage homePage = loginPage.login(this.email, this.pw);


        // Get the absolute path to the file in the project directory
        File uploadFile = new File("src/test/resources/test.txt");

        // Upload the file
        homePage.uploadFile(uploadFile.getAbsolutePath());
        homePage.selectFormat("pdf");
        homePage.readyToConvert();
  
        homePage.goToDownloadPage();
        Assert.assertTrue(homePage.getBodyText().contains("sample_pdf.pdf"));
    }
}
