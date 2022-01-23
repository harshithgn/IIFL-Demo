package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utlilities.IIFLUtlis;

public class SelectAge {
    WebDriver driver;

    String ageInputXPath="//div[@class='number-input']//input[@placeholder='Enter age']";
    By selfCheckBox = By.xpath("//span[text()='Self']/../img");
    By age = By.xpath("//span[text()='Self']/../span/p[@class='age-text']");
    By ageTextBox = By.xpath(ageInputXPath);
    By validationMessage = By.xpath("//snack-bar-container/simple-snack-bar/span");

    public SelectAge(WebDriver driver) {
        this.driver = driver;
    }

    public String enterAgeAndPrintValidationMessage(int ageValue) {
        driver.findElement(selfCheckBox).click();
        IIFLUtlis.waitTillSeconds(2);
        driver.findElement(age).click();
        IIFLUtlis.waitForElementToBePresent(driver, ageTextBox);
        driver.findElement(ageTextBox).sendKeys(String.valueOf(ageValue));
        IIFLUtlis.waitForElementToBePresent(driver, validationMessage);
        IIFLUtlis.waitTillSeconds(2);
        return driver.findElement(validationMessage).getText();
    }
}
