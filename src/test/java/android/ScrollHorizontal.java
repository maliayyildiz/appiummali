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

public class ScrollHorizontal {
    List<WebElement> item;
    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"1fd655780409");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\YSMNI\\Desktop\\Apps\\apiDemos.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,"true");

        URL url = new URL("http://127.0.0.1:4723/wd/hub"); //http://localhost:4723/wd/hub
        AndroidDriver<WebElement> driver = new AndroidDriver<>(url,desiredCapabilities);

        Thread.sleep(5000);
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        Thread.sleep(2000);

        do {
           item = driver.findElementsByXPath("//android.widget.TextView[@text='Visibility']");
            //scroll up
            Dimension dimension = driver.manage().window().getSize();
            int start_x = (int) (dimension.width * 0.5);
            int start_y = (int) (dimension.height * 0.8);
            int end_x = (int) (dimension.width * 0.5);
            int end_y = (int) (dimension.height * 0.2);

            TouchAction touch = new TouchAction(driver);

            touch.press(PointOption.point(start_x, start_y)).
                    waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(end_x, end_y))
                    .release().perform();

        }while(item.size()==0);
        if (item.size()>0){
            item.get(0).click();
        }
    }


}
