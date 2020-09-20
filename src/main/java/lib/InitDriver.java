package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitDriver {

	private static WebDriver driver;

	private InitDriver() {

	}

	public static WebDriver getDriverInstance(String browserName) {

		if(driver==null) {

			if(browserName.contentEquals("CHROME")) {
				System.setProperty("webdriver.chrome.driver", 
						"D:\\Users\\dsingh\\Downloads\\SeleniumBatch3\\chromedriver\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if (browserName.contentEquals("FIREFOX")) {

			}

			return driver;
		}
		else {
			return driver;
		}	
	}
}
