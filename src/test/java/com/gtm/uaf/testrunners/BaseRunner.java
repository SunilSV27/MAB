package test.java.com.gtm.uaf.testrunners;

import com.gtm.uaf.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import org.zaproxy.clientapi.core.ClientApiException;

import java.io.File;
import java.io.IOException;

@Test

@CucumberOptions(features = "src/test/resources/feature",glue = "com.gtm.uaf.steps", plugin = {
        "junit:target/cucumber-report.xml", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "json:target/CucumberReport/cucumber.json", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},tags="")

public class BaseRunner extends AbstractTestNGCucumberTests {
        private static Logger logger = LogManager.getLogger(BaseRunner.class);

        @Parameters({ "browserName", "environment", "enablePentest"})
        @BeforeTest
        public void setEnvDetails(@Optional("Chrome") String browserName, @Optional("qa") String environment, @Optional("false") String enablePentest) {
                String dir = System.getProperty("user.dir") + "\\Reports\\";
                FileUtility.createDirIfNotExists(dir);
                dir = System.getProperty("user.dir") + "\\Reports\\Screenshots\\";
                FileUtility.createDirIfNotExists(dir);
                File file = new File(dir);
                if (file!=null){
                        for (File f : file.listFiles()) {
                                if (f.getName().endsWith(".png")) {
                                        f.delete();
                                }
                        }
                }
                logger.info("Existing Report Cleared");
                PropHolder.setEnvironment(environment);
                PropHolder.setBrowserName(browserName);
                PropHolder.setEnablePentest(enablePentest);
                ExcelHelper.getInstance();
                ConfigHelper.getInstance();
                logger.info("Environment Setup Successful. Browser: " + browserName + ", Environment: " + environment);}

}