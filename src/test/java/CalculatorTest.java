import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.Test;  // Correct import for JUnit

import java.net.URL;

public class CalculatorTest {

    @Test  // Ensure the test method is annotated
    public void testCalculatorOperations() throws Exception {

        // Set up the Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App"); // Windows Calculator App
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("deviceName", "WindowsPC");
        capabilities.setCapability("automationName", "Windows");
        capabilities.setCapability("newCommandTimeout", 3600);
        capabilities.setCapability("connectHardwareKeyboard", true);

        // Initialize the WindowsDriver with Appium server URL and capabilities
        WindowsDriver driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);

        // Maximize the Calculator app window
        driver.manage().window().maximize();

        // Perform test actions on the Calculator app
        try {
            // Click on the number "5" button in the calculator
            driver.findElement(By.name("5")).click();

            // Click on the plus (+) button
            driver.findElement(By.name("Plus")).click();

            // Click on the number "3" button
            driver.findElement(By.name("3")).click();

            // Click on the equals (=) button to get the result
            driver.findElement(By.name("Equals")).click();

            // Optional: Retrieve the result text (e.g., "8" if you're adding 5 + 3)
            String result = driver.findElement(By.name("Display is 8")).getText();
            System.out.println("Calculation result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the driver (close the application)
            driver.quit();
        }
    }
}
