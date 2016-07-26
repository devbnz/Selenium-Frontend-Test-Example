/**
 * Created by bnz on 10.01.2016.
 *
 * you can download the latest chrome webdriver here:
 * https://sites.google.com/a/chromium.org/chromedriver/downloads
 */
package example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class ChromeTest {
    private WebDriver driver;

    @Test
    public void testEasy() throws Exception {
        driver.get("http://www.bnz-power.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Erik"));
        Thread.sleep(5000);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("chromeYo.png"));
    }

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "driver/chrome/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
