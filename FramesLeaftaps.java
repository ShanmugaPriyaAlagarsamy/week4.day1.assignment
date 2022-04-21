package week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesLeaftaps {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Take the the screenshot of the click me button of first frame
		driver.switchTo().frame(0);
		WebElement clickMe1 = driver.findElement(By.xpath("//button[@id='Click']"));
		clickMe1.click();
		File source = clickMe1.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/clickme.png");
		FileUtils.copyFile(source, destination);
		driver.switchTo().defaultContent();
		// Find the number of frames
		
		List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
		int sizeofList = frameList.size();
		System.out.println("The number of frames available in the page is: "+sizeofList );
		

	}

}
