package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TextBox {
    /*
    lunch app API Demos
    click preference
    click default values
    click check box (checked)
    then verify checked
    ===============
    click Edit text preference
    clear text box and write your name
    and verify your name.
    =========================
    click list preference
    and select option 3
    verify option 3 checked
     */
    @Test
            public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "1fd655780409");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\YSMNI\\Desktop\\Apps\\apiDemos.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");

        URL url = new URL("http://127.0.0.1:4723/wd/hub"); //http://localhost:4723/wd/hub
        AndroidDriver<WebElement> driver = new AndroidDriver<>(url, desiredCapabilities);

        Thread.sleep(3000);

        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='4. Default values']").click();
        Thread.sleep(2000);

        driver.findElementByXPath("(//android.widget.LinearLayout)[7]").click();
        Thread.sleep(2000);

       WebElement text = driver.findElementById("android:id/edit");
        Assert.assertTrue(text.isDisplayed());
//        System.out.println(text.getText());
//        text.clear();
//        Thread.sleep(2000);
//        text.sendKeys("boncuk");
//        Thread.sleep(2000);
//        driver.findElementById("android:id/button1").click();
//
//        driver.findElementByXPath("//android.widget.TextView[@text='Edit text preference']").click();
//
//        Assert.assertEquals(text.getText(),"boncuk");

    }
}
