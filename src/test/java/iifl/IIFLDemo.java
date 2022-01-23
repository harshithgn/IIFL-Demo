package iifl;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.HealthCard;
import pom.Home;
import pom.SelectAge;
import utlilities.IIFLUtlis;
import utlilities.Reports;

import java.util.concurrent.TimeUnit;

import static utlilities.Reports.extentReports;

public class IIFLDemo {

    Home home;
    HealthCard healthCard;
    SelectAge selectAge;

    public static WebDriver driver;

    @BeforeClass
    public static void loadExtentReports() {
        Reports.createAndSetupExtentReports();
    }

    @BeforeMethod
    public static void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\Practice\\IIFL\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ExtentTest generic = extentReports.createTest("Generic");
        generic.info("Browser Launched");
    }

    @Test
    public void validateAge() {
        Reports.validationTest = extentReports.createTest("Validate Age");

        //Hit URL
        driver.get("https://iifl-diy.demo.riskcovry.com/user/home");
        Reports.validationTest.info("Navigated to IIFL Home page");

        IIFLUtlis.waitTillSeconds(3);

        home = new Home(driver);
        home.navigateToHealthCard();

        IIFLUtlis.waitTillSeconds(2);

        healthCard = new HealthCard(driver);
        healthCard.selectHealCardAndMoveToNextPage();

        IIFLUtlis.waitTillSeconds(2);

        selectAge = new SelectAge(driver);
        String validationMessage = selectAge.enterAgeAndPrintValidationMessage(200);

        Reports.validationTest.fail(validationMessage);
        System.out.println(validationMessage);

        IIFLUtlis.waitTillSeconds(4);

        driver.close();
    }

    @AfterMethod
    public static void tearUp() {
        extentReports.flush();
    }
}
