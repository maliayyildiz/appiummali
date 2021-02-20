package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Message {
    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "1fd655780409");
      //  desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\YSMNI\\Desktop\\Apps\\apiDemos.apk");
        desiredCapabilities.setCapability("appPackage", "com.google.android.apps.messaging");
        desiredCapabilities.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");

        URL url = new URL("http://127.0.0.1:4723/wd/hub"); //http://localhost:4723/wd/hub
        AndroidDriver<WebElement> driver = new AndroidDriver<>(url, desiredCapabilities);

        Thread.sleep(3000);

    }
}
