package iifl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.HealthCard;
import pom.Home;
import pom.SelectAge;
import utlilities.IIFLUtlis;

import java.util.concurrent.TimeUnit;

public class IIFLDemo {

    Home home;
    HealthCard healthCard;
    SelectAge selectAge;

    public static WebDriver driver;

    @BeforeMethod
    public static void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\Practice\\IIFL\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void validateAge() {
        //Hit URL
        driver.get("https://iifl-diy.demo.riskcovry.com/user/home");

        IIFLUtlis.waitTillSeconds(3);

        home = new Home(driver);
        home.navigateToHealthCard();

        IIFLUtlis.waitTillSeconds(2);

        healthCard = new HealthCard(driver);
        healthCard.selectHealCardAndMoveToNextPage();

        IIFLUtlis.waitTillSeconds(2);

        selectAge = new SelectAge(driver);
        System.out.println(selectAge.enterAgeAndPrintValidationMessage(200));

        IIFLUtlis.waitTillSeconds(5);

        driver.close();
    }
}
