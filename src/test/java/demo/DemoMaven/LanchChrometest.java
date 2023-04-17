package demo.DemoMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanchChrometest {

	@org.testng.annotations.Test
	public void methodA() {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.agent.netwell.com/login");
		
	}
	
	@BeforeMethod
	public void MethodTwo() {
		
		System.out.println("Hello world");
	}
}
