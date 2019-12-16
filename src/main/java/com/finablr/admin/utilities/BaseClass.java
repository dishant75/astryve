package com.finablr.admin.utilities;

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
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class);


	@BeforeSuite
	public void moduleSetup(ITestContext context) {
		initiateWebdriver(context);
		driver.manage().window().maximize();
		log.info("Browser Maximized");
		driver.get(ReadPropertiesFile.getProperty("URL"));
		log.info("URL fetched from the config file" + ReadPropertiesFile.getProperty("URL"));
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

	@AfterSuite
	public void tearDown() {
		//driver.quit();
	}

}
