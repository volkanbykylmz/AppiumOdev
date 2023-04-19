package hepsiburada;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static AppiumDriver<MobileElement> appiumDriver;
    protected boolean localAndroid = true;
    //private Logger logger = LoggerFactory.getLogger(getClass());
    Logger logger= LogManager.getLogger(BaseTest.class);

    @BeforeScenario
    public void setUp() throws MalformedURLException {
        if (localAndroid){
            logger.info("Android testi basliyor.");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appium:package", "com.pozitron.hepsiburada");
            desiredCapabilities.setCapability("appium:activity", "com.hepsiburada.ui.startup.SplashActivity");
            desiredCapabilities.setCapability("appium:version", "9");
            desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
            desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
            desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
            desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
            desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
            appiumDriver = new AndroidDriver(new URL("http://localhost:8200/wd/hub"),desiredCapabilities);

        }else {
            logger.info("İos testi basliyor.");
        }

    }

    @AfterScenario
    public void afterSenaryo(){
        appiumDriver.quit();
    }
}
