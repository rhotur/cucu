package org.cucumberRunner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utils.ConstantsFile;

public class RunCukesByCompositionTest extends RunCukes{
	
	@BeforeTest
	@Parameters({"Browser", "URL"})
	public WebDriver instantiateWebDriver(String browser, String url){
//		browser1=browser;
		if (browser.equalsIgnoreCase(ConstantsFile.FIREFOX_BROWSER)){
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		}else if (browser.equalsIgnoreCase(ConstantsFile.IE_BROWSER))
		{
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			System.setProperty("webdriver.ie.driver", "src\\test\\java\\org\\utils\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		
			driver.manage().window().setPosition(new Point(0,0));
			java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
			driver.manage().window().setSize(dim);
		}else if (browser.equalsIgnoreCase(ConstantsFile.CHROME_BROWSER))
		{
			System.setProperty("webdriver.chrome.driver", "src\\test\\java\\org\\utils\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase(ConstantsFile.FIREFOX_BROWSER)){
			driver = new FirefoxDriver();
		}
		driver.get(url);
		return driver;
	}
	@Test(groups = "examples-testng", description = "Example of using TestNGCucumberRunner to invoke Cucumber a")
	public void run_cukes (ITestContext istx) throws Throwable  {
		super.RunningOfCukes(OptionsSpecification(istx));
	}
	
	public String[] OptionsSpecification(ITestContext istx){
		String[] Options_Runtime = new String[7];
//		Options_Runtime[0] = "src/test/java/org/features/"+istx.getCurrentXmlTest().getParameter("FeatureName");
		Options_Runtime[0] = "src/test/java/org/features";
		Options_Runtime[1] = "--glue";
		Options_Runtime[2] = "org/stepDefinition1";
		Options_Runtime[3] = "--glue";
		Options_Runtime[4] = "src/main/java/org/cucumberRunner";
		Options_Runtime[5] = "--tags";
		Options_Runtime[6] = istx.getCurrentXmlTest().getParameter("Tags"); //@Ignore,@smoke
		return Options_Runtime;
	}
}
