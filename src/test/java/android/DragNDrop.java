package android;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class DragNDrop {
    @Test
    public void setupDc() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\YSMNI\\Desktop\\Apps\\DragSortDemos.apk");

        URL url = new URL("http://localhost:4723/wd/hub"); //"http://127.0.0.1:4723/wd/hub"
//Android driver class object like driver object we used before
        AndroidDriver<WebElement> driver =  new AndroidDriver<WebElement>(url,desiredCapabilities);
        Thread.sleep(5000);

        driver.findElementByXPath("//android.widget.TextView[@text='DRAG']").click();
        //   navigation
driver.findElementByXPath("//android.widget.Button[@text='DRAGGABLE (BASIC)']").click();

        List<WebElement> elements = driver.findElementsByXPath("//android.widget.TextView");

      //  List<WebElement> elements = driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle");
        WebElement third = elements.get(2);
        WebElement fifth = elements.get(4);
        //appium for touchaction class
        TouchAction action = new TouchAction((MobileDriver)driver);
        //before
        // action.longPress(third).moveTo(fifth).release().perform();

        //drag and drop action script
        action.longPress(ElementOption.element(third)).moveTo(ElementOption.element(fifth)).release().perform();

        System.out.println("Element drag and drop successfully");


    }
}
