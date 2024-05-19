import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class SplitPDFTest extends MainTest {
    @Test
    public void testPdfSplitting() {
        LoginPage loginPage = new LoginPage(this.driver);
        HomePage homePage = loginPage.login(this.email, this.pw);

        homePage.navigateToSplitForm();
        Assert.assertTrue(homePage.getBodyText().contains("Online & free tool to split a PDF file into multiple pages."));

        File uploadFile = new File("src/test/resources/sample_pdf.pdf");
        homePage.fileUploadForSplitting(uploadFile.getAbsolutePath());

        Assert.assertTrue(homePage.getBodyText().contains("sample_pdf.pdf"));

        homePage.setSplitRange("1-2");
        homePage.beginSplitting();

        homePage.goToDownloadPage();
        Assert.assertTrue(homePage.getBodyText().contains("sample_pdf.pdf"));
    }
}
