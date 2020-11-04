package devices;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DeviceCapability {

    public DesiredCapabilities getCapabilitySettings() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "HUAWEI");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0" );
        capabilities.setCapability(MobileCapabilityType.UDID,"5MG7N18905001179" );
        capabilities.setCapability("appPackage", "com.dstarlab.icommunicator");
        capabilities.setCapability("appActivity", "org.thoughtcrime.securesms.RoutingActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        return capabilities;
  }
}
