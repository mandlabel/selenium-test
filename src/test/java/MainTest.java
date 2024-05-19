import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class MainTest {
    public WebDriver driver;
    public final String email = "";
    public final String pw = "";

    @Before
    public void setup() throws MalformedURLException {

        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory",System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");   
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
        

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.setExperimentalOption("prefs", prefs);

        chromeOptions.addArguments("--enable-features=NetworkServiceInProcess");
        chromeOptions.addArguments("--disable-features=NetworkService");

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        driver.manage().window().maximize();
        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector()); // for local file handling and uploading
       
    }


}
