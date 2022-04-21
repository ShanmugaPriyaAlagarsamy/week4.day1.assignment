package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Servicenow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev102905.service-now.com/");
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("yw%$O7WuMg1V");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incidents");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='Incidents'])[1]")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[text()='New']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("incident.short_description")).sendKeys("Test Incident by Priya");
		String incidentNo = driver.findElement(By.id("incident.number")).getAttribute("value");
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		Thread.sleep(3000);
		//driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[@class='input-group']/input[@placeholder='Search']")).sendKeys(incidentNo + Keys.ENTER);
		
		
		
		
		
		
		
		
		
		
		

	}

}
