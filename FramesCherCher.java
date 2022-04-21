package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesCherCher {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Not A Friendly Topic");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Append");
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame2");
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='animals']"));
		Select dd = new Select(dropDown);
		dd.selectByVisibleText("Big Baby Cat");

	}

}
