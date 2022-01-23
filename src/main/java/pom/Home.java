package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

    WebDriver driver;

    By getProtected = By.xpath("//a[@class='get-protected']");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHealthCard() {
        driver.findElement(getProtected).click();
    }
}
