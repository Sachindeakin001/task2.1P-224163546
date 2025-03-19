package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\sachi\\Downloads\\chromedriver-win64\\chromedriver-win64\\selenium-test\\driver\\chromedriver.exe"
        );

        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        sleep(2);

        // Load a webpage in chromium browser.
        driver.get(url);

        // Find the 'firstname' input field and fill it with "Ahsan"
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("Ahsan");

        // Find the 'lastname' input field and fill it with your last name
        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Habib");

        // Find the 'email' input field and fill it with an email
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("ahsan.habib@example.com");

        // Find the 'phone' input field and fill it with your phone number
        WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
        phoneNumber.sendKeys("0489105006");

        // Find the 'password' input field and fill it with a password (but fail the password criteria)
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("short");

        // Find the 'confirm password' input field and fill it with the same password
        WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
        confirmPassword.sendKeys("short");

     // Locate the "Create account" button using data-testid and click to submit
        WebElement createAccountButton = driver.findElement(By.cssSelector("[data-testid='account-action-btn']"));
        createAccountButton.click();


        // Sleep for a while to see the result
        sleep(5);

        // Take screenshot of the current page (after failing password validation)
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File("officeworks_registration_failed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.close();
    }

    public static void chemist_warehouse_registration_page(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\sachi\\Downloads\\chromedriver-win64\\chromedriver-win64\\selenium-test\\driver\\chromedriver.exe"
        );

        WebDriver driver = new ChromeDriver();
        driver.get(url);

        // Fill the registration form for chemist warehouse(adjust field locators accordingly)
        // Find the 'firstname' input field and fill it with "Ahsan"
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Ahsan");

        // Find the 'lastname' input field and fill it with your last name
        WebElement lastname = driver.findElement(By.id("lastname"));
        lastname.sendKeys("Habib");

        // Find the 'email' input field and fill it with your email
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("ahsan.habib@example.com");

//        // Find the 'phone' input field and fill it with your phone number
//        WebElement phone = driver.findElement(By.id("phone"));
//        phone.sendKeys("1234567890");

        // Find the 'password' input field and fill it with a password (but fail the password criteria)
        WebElement pass_confirmation = driver.findElement(By.id("pass_confirmation"));
        pass_confirmation.sendKeys("short");

        // Find the 'confirm password' input field and fill it with the same password
        WebElement pass2 = driver.findElement(By.id("pass2"));
        pass2.sendKeys("short");

        // Locate the "Create account" button and click to submit
     // Locate the "REGISTER" button using id and click to submit
        WebElement registerButton = driver.findElement(By.id("p_lt_ctl10_pageplaceholder_p_lt_ctl00_wAMSReg_register"));
        registerButton.click();


        // Sleep for a while to see the result
        sleep(5);

        // Take screenshot of the current page (after failing password validation)
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File("chemist_warehouse_registration_failed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.close();
    }

    public static void main(String[] args) {
        // Open the OfficeWorks registration page
        officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");

        // Open the Chemist Warehouse registration page
        chemist_warehouse_registration_page("https://www.chemistwarehouse.com.au/login");
    }
}
