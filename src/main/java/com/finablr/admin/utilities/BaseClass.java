package com.finablr.admin.utilities;

import java.lang.reflect.Method;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.finablr.admin.constants.LogConstants;

public class BaseClass {

   public static  WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class);
	 public ExtentHtmlReporter htmlreporter;
	public static ExtentTest extenttest;
	public static ExtentReports extent;


	@BeforeSuite
	public void moduleSetup(ITestContext context) {
		initiateWebdriver(context);
		driver.manage().window().maximize();
		log.info("Browser Maximized");
		driver.get(ReadPropertiesFile.getProperty("URL"));
		log.info("URL fetched from the config file" + ReadPropertiesFile.getProperty("URL"));
		
		 htmlreporter = new ExtentHtmlReporter("extent.html");
		 extent= new ExtentReports();
		extent.attachReporter(htmlreporter);
		
	}
	
	@BeforeTest
	
	public void setExtent()
	{
		htmlreporter=new ExtentHtmlReporter("extentReport.html");
		
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setReportName("Astryve Smoke Testing of Admin Portal");
		htmlreporter.config().setTheme(Theme.DARK);
		
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlreporter);
		
		
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("OS", "WINDOWS 10");
		extent.setSystemInfo("Tester Name", "Dishant");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	
	public void initiateWebdriver(ITestContext context) {
		String os = System.getProperty("os.name").toUpperCase();
		String browser;
		Map<String, String> parameterMap = context.getCurrentXmlTest().getAllParameters();

		if (os.contains("WINDOWS") || os.contains("LINUX") || os.contains("MAC")) {
			if (parameterMap.containsKey("Browser")) {
				browser = parameterMap.get("Browser");
				if (browser.equalsIgnoreCase("chrome")) {
					if (os.contains("WINDOWS")) {
						System.setProperty("webdriver.chrome.driver", ReadPropertiesFile.getProperty("windows_chrome_exe_path"));
					} else if (os.contains("MAC")) {
						System.setProperty("webdriver.chrome.driver", "");
					} else if (os.contains("LINUX")) {
						System.setProperty("webdriver.chrome.driver", "lib/Linux/chromedriver");
					}
					driver = new ChromeDriver();
					//System.out.println("Random String" + ActionMethods.randomestring());
				} 
				
				else if (browser.equalsIgnoreCase("firefox")) {
					if (os.contains("WINDOWS")) {
						System.setProperty("webdriver.gecko.driver", ReadPropertiesFile.getProperty("windows_mozilla_exe_path"));
					} else if (os.contains("MAC")) {
						System.setProperty("webdriver.gecko.driver", "lib/Mac/geckodriver");
					} else if (os.contains("LINUX")) {
						System.setProperty("webdriver.gecko.driver", "lib/Linux/geckodriver");
					}
					driver = new FirefoxDriver();
				} 
				
				else if (browser.equalsIgnoreCase("IE")) {
					if (os.contains("WINDOWS")) {
						System.setProperty("webdriver.ie.driver", ReadPropertiesFile.getProperty("windows_ie_exe_path"));
					} else if (os.contains("LINUX")) {
						System.setProperty("webdriver.ie.driver", "lib/Linux/IEDriverServer");
					}
					driver = new InternetExplorerDriver();
				} 
				
				else if (browser.equalsIgnoreCase("safari")) {
					if (os.contains("MAC")) {
						System.setProperty("webdriver.safari.driver", "lib/Windows/IEDriverServer.exe");
					} 
					driver = new SafariDriver();
				}
			}
		}
	}
	
	

	@BeforeMethod
	public void beforeMethod (Method method) {
		
		log.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
		extenttest = extent.createTest(method.getName());
		log.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	
	/*@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		log.debug("result.getStatus()"+ result.getStatus());
		if (result.getStatus() == ITestResult.FAILURE) {
			log.debug("in failed condition" + result.getName());
			// MarkupHelper is used to display the output in different colors
			extenttest.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			extenttest.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			// To capture screenshot path and store the path of the screenshot in the string
			// "screenshotPath"
			// We do pass the path captured by this method in to the extent reports using
			// "logger.addScreenCapture" method.
			// String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			String screenshotPath = getScreenShot(driver, result.getName());
			// To add it in the extent report
			extenttest.fail("Test Case Failed Snapshot is below " + extenttest.addScreenCaptureFromPath(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			log.debug("in skip condition " + result.getName());
			extenttest.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			log.debug("in success condition " + result.getName());
			extenttest.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}

	// This method is to capture the screenshot and return the path of the
	// screenshot.
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}*/
	
	
	
	@AfterSuite
	public void tearDown() {
		//driver.quit();
		extent.flush();
	}

}
