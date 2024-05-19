import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PageTitleTest extends MainTest {
    @Test
    public void testPageTitle() {
        LoginPage loginPage = new LoginPage(this.driver);
        HomePage homePage = loginPage.login(this.email, this.pw);

        assertEquals("File Converter - video converter, audio converter, image converter, eBook converter", homePage.getPageTitle());
    }   
}
