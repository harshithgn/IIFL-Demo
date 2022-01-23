package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utlilities.Reports;

public class Home {

    WebDriver driver;

    By getProtected = By.xpath("//a[@class='get-protected']");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHealthCard() {
        driver.findElement(getProtected).click();
        Reports.validationTest.info("Clicked on Get Protected in the Home Page");
    }
}
