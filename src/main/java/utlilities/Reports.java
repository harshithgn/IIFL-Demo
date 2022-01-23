package utlilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reports {

    public static ExtentReports extentReports;
    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentTest validationTest;


    public static void createAndSetupExtentReports() {
        String testReportDate = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss-a").format(new Date());
        File f = new File(String.format("%s/reports/%s", System.getProperty("user.dir"), testReportDate));
        f.mkdir();

        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(String.format("%s/reports/%s/%s.html", System.getProperty("user.dir"), testReportDate, testReportDate));
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setDocumentTitle("IIFL");
        extentSparkReporter.config().setReportName("Select Age in IIFL");
        extentReports.attachReporter(extentSparkReporter);
    }
}
