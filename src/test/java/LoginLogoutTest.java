import org.junit.Assert;
import org.junit.Test;

public class LoginLogoutTest extends MainTest {

    @Test
    public void testLoginAndLogout() {
        LoginPage loginPage = new LoginPage(this.driver);
        HomePage homePage = loginPage.login(this.email, this.pw);
        Assert.assertTrue(homePage.getBodyText().contains("TesztElek"));

        loginPage = homePage.logout();
        Assert.assertTrue(loginPage.getBodyText().contains("Login"));
    }
}
