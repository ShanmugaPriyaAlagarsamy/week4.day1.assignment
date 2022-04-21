package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//div[@for='crmsfa']/a")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath(("(//a[contains(@href,'javascript:call_fieldlookup2autocomplete')]/img)[1]"))).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//tr[1]/td[1]/div[1]/a")).click();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.findElement(By.xpath("(//a[contains(@href,'javascript:call_fieldlookup2autocomplete')]/img)[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windowHandles2List = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(windowHandles2List.get(1));
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//tr[1]/td[1]/div/a")).click();
		driver.switchTo().window(windowHandles2List.get(0));
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		System.out.println("The title of the page is: " + title);
		if(title.contains("View Contact"))
		{
			System.out.println("The title of the page contains view contact and verification is successfull");
		}
		else
		{
			System.out.println("The title of the page does not contains view contact and so the verification is not successful");
		}
			
		
		
		
		
		

	}

}
