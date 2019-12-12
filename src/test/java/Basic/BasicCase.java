package Basic;

import Utilits.YamlReader;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class BasicCase {
    public WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    private String SysPath = "src/config/SystemConfig";
    private YamlReader yamlReader = new YamlReader();
    private String chromedriver = yamlReader.sysGetObj(SysPath, "Settings", "Chrome", "webdriver");
    private String firefoxdriver = yamlReader.sysGetObj(SysPath, "Settings", "Firefox", "webdriver");
    private String path = yamlReader.sysGetObj(SysPath, "Settings", "Chrome", "path");
    private String crx = yamlReader.sysGetObj(SysPath, "Settings", "Chrome", "crx");
    private String serverUrl = yamlReader.sysGetObj(SysPath, "Settings", "Server", "url");

    /**This method respond for driver. You can change the driver or configurate him from this method, but for choosen type, you should go to TestNG.xml and change the "value"
     * to change the driver.
     *
     *  <parameter name="driverName" value="Iphone X"></parameter>*/
    @BeforeClass
    @Parameters("driverName")
    public void driverStart(String driverName) {
        ChromeDriverService service = new ChromeDriverService.Builder().
                usingDriverExecutable(new File(chromedriver)).
                usingAnyFreePort().
                build();
        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.gecko.driver",firefoxdriver);
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        switch(driverName)
        {
            case "Chrome":
//                options.addArguments("--window-size=5,5");
                chromeOptions.addArguments("start-maximized");
//                options.addExtensions(new File("D:\\Programs\\Extension\\8.2.6_0.crx"));
                driver = new ChromeDriver(service,chromeOptions);
                break;

            case "Iphone X":
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "iPhone X");
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                driver = new ChromeDriver(service,chromeOptions);
                break;

            case "Firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeClass
    public abstract void set_Up();

    @AfterClass
    public void driverQuit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
