//import io.appium.java_client.windows.WindowsDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.junit.Test;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import java.net.URL;
//
//public class CalculatorTest {
//
//    @Test  // Ensure the test method is annotated
//    public void testCalculatorOperations() throws Exception {
//        // Set up the Desired Capabilities
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App"); // Windows Calculator App
//        capabilities.setCapability("platformName", "windows");
//        capabilities.setCapability("deviceName", "WindowsPC");
//        capabilities.setCapability("automationName", "windows");
//        capabilities.setCapability("newCommandTimeout", 3600);
//        capabilities.setCapability("connectHardwareKeyboard", true);
//
//        // Initialize the WindowsDriver with Appium server URL and capabilities
//        WindowsDriver driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
//
//        // Maximize the Calculator app window
//        driver.manage().window().maximize();
//
//        // Initialize WebDriverWait with 10 seconds timeout
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//
//        // Perform test actions on the Calculator app
//        try {
//            // Add a small delay to ensure the app is fully loaded
//            Thread.sleep(3000); // Sleep for 3 seconds
//
//            // Log element search attempts
//            System.out.println("Attempting to click on the '5' button...");
//            WebElement number5 = wait.until(ExpectedConditions.elementToBeClickable(By.name("Five")));
//            number5.click();
//            System.out.println("'5' button clicked!");
//
//            System.out.println("Attempting to click on the 'Plus' button...");
//            WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//Button[@Name='Plus']")));
//            plusButton.click();
//            System.out.println("'Plus' button clicked!");
//
//            System.out.println("Attempting to click on the '3' button...");
//            WebElement number3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//Button[@Name='3']")));
//            number3.click();
//            System.out.println("'3' button clicked!");
//
//            System.out.println("Attempting to click on the 'Equals' button...");
//            WebElement equalsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//Button[@Name='Equals']")));
//            equalsButton.click();
//            System.out.println("'Equals' button clicked!");
//
//            // Wait for the result to be visible and fetch it
//            WebElement display = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//Text[@Name='Display is 8']")));
//            String result = display.getText();
//            System.out.println("Calculation result: " + result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            driver.quit();
//        }
//    }
//
//    // Add other tests here with similar changes (using xpath locators)...
//}
