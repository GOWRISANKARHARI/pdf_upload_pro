package process;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PDFDown_ {

    @Test
    public void downloadPDF() throws InterruptedException, IOException, AWTException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://pdf2doc.com/");
        
        WebElement upload = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/label/span"));
        upload.click();
        Thread.sleep(1000);
        
        Robot rb = new Robot();
        StringSelection str = new StringSelection("D:\\eclipse\\assignment_4.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(3000); 
        System.out.println("it is completed....");
        // Optional: Wait to observe upload
        driver.quit();
    }
}
