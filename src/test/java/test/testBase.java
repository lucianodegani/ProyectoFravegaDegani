package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class testBase 
{
	WebDriver driver;
	
	@Before
	public void abrirDriver()
	    {
	       // driver = getDriver("Firefox");
	        driver = getDriver("google");
	        
	        driver.manage().window().maximize();
	    }
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	 public void goToURL(WebDriver driver, String URL)
	    {
	    	driver.get(URL);
	    	
	    }
	 
	 @After
	 public void cerrarDriver()
		{
	        driver.quit();
	    }
	 
	 public static WebDriver getDriver (String browserName)
	    {	WebDriver driver;
	        switch(browserName) {
	            case "Firefox":
	                System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
	                driver = new FirefoxDriver ();
	                return driver;
	            case "google":
	                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	                ChromeOptions options = new ChromeOptions();
	                options.addArguments("--start-maximized");
	                driver = new ChromeDriver(options);
	                //driver = new ChromeDriver ();
	                return driver;
	            case "edge":
	                System.setProperty("webdriver.edge.driver", "src\\test\\resources\\msedgedriver.exe");
	                driver = new EdgeDriver ();
	                return driver;

	            default:
	                return null;
	        }


	    }

}
