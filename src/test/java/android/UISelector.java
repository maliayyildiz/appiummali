package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class UISelector {
    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "1fd655780409");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\YSMNI\\Desktop\\Apps\\GestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");

        URL url = new URL("http://127.0.0.1:4723/wd/hub"); //http://localhost:4723/wd/hub
        AndroidDriver<WebElement> driver = new AndroidDriver<>(url, desiredCapabilities);

        Thread.sleep(5000);

       // driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();
//class name
       List<WebElement> buttons = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")");
        System.out.println(buttons.size());

//        for (WebElement button : buttons) {
//            if(button.getText().equals("Test")){
//                System.out.println(button.getText() + "  clicked");
//                button.click();
//                Thread.sleep(3000);
//                break;
//            }
//        }

       // driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(0)").click();

        driver.findElementByAndroidUIAutomator("UiSelector().checkable(false)");
        //if it not exist or visible
        System.out.println( driver.findElementsByAndroidUIAutomator("UiSelector().checkable(true)").size());

        //lets find element wth text using UiSelector
         driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Test\")").click();
//text contains
        //   driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textContains(\"dd\")").click();

        //test startwith
        // driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Te\")").click();

    }
}
