package process;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class PdfToDocConverterTest {

    @Test
    public void testPdfToDocConversion() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to PDF to DOC conversion website
            driver.get("https://pdf2doc.com/");

            // Wait for the upload label to become clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement uploadLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/label")));

            // Click the upload button
            System.out.println("Clicking upload button...");
            uploadLabel.click();

            // Wait for dialog to appear
            Thread.sleep(2000);

            // Check file exists before running AutoIt
            File file = new File("C:\\Users\\GOWRISANKAR\\OneDrive\\Pictures\\Doc2.pdf");
            if (!file.exists()) {
                System.out.println("File does not exist. Please check the path.");
                return;
            }

            // Run AutoIt script to handle file dialog
            System.out.println("Running AutoIt script...");
            Runtime.getRuntime().exec("D:\\eclipse\\demo1.exe");
            System.out.println("completed.....");
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the browser
            driver.quit();
        }
    }
}
