package utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        //ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report " + "-" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()).toString()+ ".html");
        reporter.config().setReportName("Sample Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Blog Name", "D M Academy");
        extentReports.setSystemInfo("Author", "Dilip Meghwal");
        return extentReports;
    }
}
