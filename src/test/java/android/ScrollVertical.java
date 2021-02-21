package android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class ScrollVertical {
    @Test
    public void scroll () throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        // if app alrready installed do not install again NO_reset  ***
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\YSMNI\\Desktop\\Apps\\scroll-dragNdrop.apk");
        desiredCapabilities.setCapability("appPackage", "com.h6ah4i.android.example.advrecyclerview");
        desiredCapabilities.setCapability("appActivity", "com.h6ah4i.android.example.advrecyclerview.launcher.MainActivity");

        URL url = new URL("http://localhost:4723/wd/hub"); //"http://127.0.0.1:4723/wd/hub"
//Android driver class object like driver object we used before
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, desiredCapabilities);

        driver.findElementByXPath("//android.widget.TextView[@text='SWIPE']").click();
        Thread.sleep(3000);
        //normally index should be 4 but it shows 5 (bug ***)
        driver.findElementByXPath("//android.widget.Button[5]").click();
        Thread.sleep(2000);
        List<WebElement> listOfelements = driver.findElementsById("android:id/text1");
        System.out.println(listOfelements.size());
        for (WebElement el : listOfelements) {
            //  System.out.println("getText() =>" +el.getText());
            //   System.out.println("getAttribute() => " +el.getAttribute("text"));

        }
        //scroll right to left
        Thread.sleep(5000);
        Dimension dimension = driver.manage().window().getSize();
        int start_x = (int) (dimension.width*0.9);
        int start_y = (int) (dimension.height*0.5);
        int end_x = (int) (dimension.width*0.1);
        int end_y = (int) (dimension.height*0.5);

        TouchAction touch = new TouchAction(driver);
        touch.press(PointOption.point(start_x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(end_x,end_y)).release().perform();


// scroll left to right
        dimension = driver.manage().window().getSize();
        start_x = (int) (dimension.width*0.1);
        start_y = (int) (dimension.height*0.5);

        end_x = (int) (dimension.width*0.9);
        end_y = (int) (dimension.height*0.5);
//just replace start y   and end y value
        touch = new TouchAction(driver);
        touch.press(PointOption.point(start_x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(end_x,end_y)).release().perform();

    }
}
