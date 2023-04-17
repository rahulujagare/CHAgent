package demo.DemoMaven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearningTest {

	WebDriver driver;

	@Test
	public void methodOne() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://surendrareddy1248.github.io/WebElementsTesting/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String actual = driver.findElement(By.xpath("//*[@id=\'testtext_1\']")).getText();

		Assert.assertEquals(actual, "Sample Text for testing.");

		System.out.println("hello");
		//driver.close();
	}

	@AfterMethod
	public void closeOn() {
		
		System.out.println(System.getProperty("user.dir"));
		driver.close();
	}
}
