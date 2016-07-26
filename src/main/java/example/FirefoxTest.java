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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;

public class FirefoxTest {
    private WebDriver driver;

    @Test
    public void testEasy() throws IOException {
        driver.get("http://www.bnz-power.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Erik"));
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("screenshots\\firefox.png"));
    }

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
