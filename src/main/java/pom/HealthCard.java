package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utlilities.IIFLUtlis;

public class HealthCard {

    WebDriver driver;

    By risingHealthCosts = By.xpath("//h2[text()='Easy Health Insurance !!']/..//p[text()='Rising Health Costs']");
    By nextButton = By.xpath("//button[@class='nextBtn']");

    public HealthCard(WebDriver driver) {
        this.driver = driver;
    }

    public void selectHealCardAndMoveToNextPage() {
        driver.findElement(risingHealthCosts).click();
        IIFLUtlis.waitTillSeconds(2);
        driver.findElement(nextButton).click();
    }
}
