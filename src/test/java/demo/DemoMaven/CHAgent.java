package demo.DemoMaven;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CHAgent {

	@Test
	public void Agent() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://dev.agent.netwell.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("welllife@yopmail.com");

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("Test@123");

		WebElement signin = driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();

		Thread.sleep(5000);

		Actions act = new Actions(driver);
		WebElement desktop = driver.findElement(By.xpath("/html/body"));
		act.moveToElement(desktop).perform();

		WebElement ShowAll = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button/span[1]"));
		act.moveToElement(ShowAll).click().build().perform();

		// click on household
		Thread.sleep(3000);
		act.moveToElement(desktop);

		driver.findElement(
				By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div[1]/div[2]/div/div[1]/div/button/div"))
				.click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div/div[1]/div/div/div[2]/div[1]/div[5]/button"))
				.click();

		Thread.sleep(2000);

		// Adding prospect in agent
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstname.sendKeys("Sam");

		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.sendKeys("Man");

		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("sammantest@yopmail.com");

		WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
		phone.sendKeys("+919890228501");

		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/button[1]/span[1]")).click();

		Thread.sleep(4000);

		Actions act1 = new Actions(driver);
		WebElement pop = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]"));
		act1.moveToElement(pop).perform();

		WebElement ok = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/button/span[1]"));

		act1.moveToElement(ok).click().build().perform();

		// Start enrollment process

		driver.findElement(By.xpath("//*[@id=\"MUIDataTableBodyRow-0\"]/td[6]/div[2]/span/button")).click();
		driver.findElement(By.xpath("//*[@id=\"demo-popup-menu\"]/div[3]/ul/div/li[1]")).click();

		Thread.sleep(3000);
		// switching to enroll portal

		Set<String> handle = driver.getWindowHandles();

		java.util.Iterator<String> it = handle.iterator();
		String parentid = it.next();
		String childid = it.next();

		driver.switchTo().window(childid);

		System.out.println(driver.findElement(By.xpath("//*[@id=\"enrollDiv\"]/div[1]/div[1]")).getText());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		Thread.sleep(3000);
		// Instruction tab

		driver.findElement(By.xpath("//*[@id=\"enrollDiv\"]/div[1]/div[3]/div[1]/div/div[2]/button/span[1]")).click();

		Thread.sleep(4000);

		// setup family
		driver.findElement(By.xpath("//div[@id='mui-component-select-Gender']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='MALE']")).click();
		driver.findElement(By.xpath("//input[@id='date-picker-dialog']")).sendKeys("01/01/1980");
		driver.findElement(By.xpath("//input[@name='postal_code']")).sendKeys("64012");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='MuiButton-label']")).click();

		// View quote
		Thread.sleep(4000);
		JavascriptExecutor jst = (JavascriptExecutor) driver;
		jst.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//span[normalize-space()='Proceed']")).click();

		Thread.sleep(4000);

		// check eligibility
		JavascriptExecutor jst1 = (JavascriptExecutor) driver;
		jst1.executeScript("window.scrollBy(0,1000)");

		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();

		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Submit']")).click();

		/*
		 * List<WebElement> nextButtons =
		 * driver.findElements(By.xpath("//span[normalize-space()='Next']"));
		 * 
		 * // Loop through the pages until we reach the last one while
		 * (nextButtons.size() > 5) { // Click the first "Next" button on the page
		 * nextButtons.get(5).click(); // Wait for the page to load Thread.sleep(2000);
		 * // Find the next set of "Next" buttons on the new page nextButtons =
		 * driver.findElements(By.xpath("//span[normalize-space()='Next']"));
		 * 
		 * driver.findElement(By.xpath("//span[normalize-space()='Submit']")).click();
		 */
		Thread.sleep(3000);

		// Medical info

		driver.findElement(By.xpath("//input[@name='feet']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@name='inches']")).sendKeys("9");
		driver.findElement(By.xpath("//input[@name='weight']")).sendKeys("90");
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();

		JavascriptExecutor jst2 = (JavascriptExecutor) driver;
		jst2.executeScript("window.scrollBy(0,1000)");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		driver.findElement(By.xpath("//div[@id='demo-simple-select']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//li[normalize-space()='English']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Submit']")).click();
		Thread.sleep(3000);
		
		//Select Program
		driver.findElement(By.xpath("//span[@class='MuiButton-label'][normalize-space()='Select Program']")).click();
		
		Thread.sleep(3000);
		//Review choices
		driver.findElement(By.xpath("//span[normalize-space()='PROCEED']")).click();
		
		
		Thread.sleep(3000);
		//set up payment
		driver.findElement(By.xpath("//span[normalize-space()='CREDIT/DEBIT CARD']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='Card_Number']")).sendKeys("4111111111111111");
		driver.findElement(By.xpath("//div[@id='mui-component-select-expiryMonth']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[normalize-space()='Feb']")).click();
		driver.findElement(By.xpath("//div[@id='mui-component-select-expiryYear']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[normalize-space()='2027']")).click();
		driver.findElement(By.xpath("//input[@name='cvv']")).sendKeys("5656");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='MuiButton-label']")).click();
		
		
		Actions Paddress = new Actions(driver);
		WebElement popup = driver.findElement(By.xpath("//input[@name='Street_suite']"));
		popup.sendKeys("159th street");
		Paddress.moveToElement(popup).perform();
		

		WebElement Submit1 = driver.findElement(By.xpath("//span[normalize-space()='Submit']"));

		act1.moveToElement(ok).click().build().perform();
		
		
		

	}
}
