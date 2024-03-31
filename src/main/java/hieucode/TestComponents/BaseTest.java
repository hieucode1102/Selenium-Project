package hieucode.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import hieucode.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException {
		// properties class

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
				"\\src\\main\\java\\hieucode\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nohop\\Desktop\\chromedriver.exe");
			 this.driver = new ChromeDriver();
			
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			//Firefox
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			//Edge
			System.setProperty("webdriver.edge.driver", "C:\\Users\\nohop\\Documents\\edgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		driver = initializeDriver();
		this.landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
