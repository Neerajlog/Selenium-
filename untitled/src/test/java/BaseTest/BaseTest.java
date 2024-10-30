package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.URL;
import java.util.HashMap;

public class BaseTest {

    public WebDriver driver;
    public String urlenv = "";
    public String envProd = "www";
    public String envPreProd = "beta";
    public String envUat = "demo";
    public String baseurl = ".bajajfinservhealth.in";
    public boolean mweb;
    public boolean webgrid;

    @BeforeSuite
    @Parameters({"env", "webConfig"})
    public void setUP(String env, String webConfig) {
        mweb = webConfig.equalsIgnoreCase("m-web");

        if (env.equalsIgnoreCase("prod")) urlenv = envProd;
        else if (env.equalsIgnoreCase("PreProd")) urlenv = envPreProd;
        else if (env.equalsIgnoreCase("uat")) urlenv = envUat;
    }

    public void disableChromeImages(ChromeOptions options) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("images", 2);
        map.put("profile.default_content_setting_values.notifications", 2);
        map.put("profile.default_content_setting_values.geolocation", 2);
        options.setExperimentalOption("prefs", map);
    }

    public void openBrowserInMWeb(ChromeOptions options) {
        HashMap<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        options.addArguments("--incognito", "--headless","--no-sandbox", "--disable-dev-shm-usage");
    }

    public void openBrowserInDWeb(ChromeOptions options) {
        options.addArguments("window-size=1200x600", "--headless","--incognito", "--no-sandbox", "--disable-dev-shm-usage");
    }

    public void openBrowser() {
        System.out.println("Opening web browser...");
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBrowserVersion("121");
            disableChromeImages(chromeOptions);
                if (mweb) {
                    openBrowserInMWeb(chromeOptions);
                } else {
                    openBrowserInDWeb(chromeOptions);
                }
                driver=new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
            }
         catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigateUrl(){
        driver.get("https://"+envProd+".entrata.com/");
    }

    @AfterMethod
    public void Browserclose(){
        driver.quit();
    }
}
