import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import selenium.configurations.PropertiesManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class GradleSmoke extends BaseTest {
    @Step
    @Test
    public void test() throws IOException {
        System.setProperty(PropertiesManager.getChromeDriver(),PropertiesManager.getChromeDriverPath());
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get(PropertiesManager.getBaseUrl());
        webDriver.findElement(By.name("q")).sendKeys(("grape" + Keys.ENTER));
        WebElement imagesButton = wait.until(presenceOfElementLocated(By.xpath("//a[contains(@data-hveid, 'CAIQAw')]")));
        imagesButton.click();
        WebElement imageOfGrape = wait.until(presenceOfElementLocated(By.xpath("//img[contains(@class, 'rg_i Q4LuWd')]")));
        imageOfGrape.click();
        logger.info("The picture has been opened");
        assertTrue(imageOfGrape.isDisplayed());
        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/java/screenshots/screen.png"));
        webDriver.quit();
    }
}