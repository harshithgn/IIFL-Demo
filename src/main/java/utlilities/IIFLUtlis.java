package utlilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class IIFLUtlis {
    public static void click(WebDriver driver, String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void enterText(WebDriver driver, String xpath, String value) {
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public static void waitForElementToBePresent(WebDriver driver, By xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

    public static String getTextFromElement(WebDriver driver, String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public static void waitTillSeconds(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
