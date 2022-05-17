package Scenario1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoAutomation {
	public static void main(String[] args) throws InterruptedException, IOException, AWTException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\Automation\\TestAutomation\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		Robot robot =new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		WebElement admin = driver.findElement(By.xpath("//*[@id=\'menu_admin_viewAdminModule\']/b"));
		WebElement UserMan = driver.findElement(By.xpath("//*[@id=\'menu_admin_UserManagement\']"));
		WebElement Users = driver.findElement(By.xpath("//*[@id=\'menu_admin_viewSystemUsers\']"));
		
		act.moveToElement(admin).build().perform();
		Thread.sleep(3000);
		act.moveToElement(UserMan).build().perform();
		Thread.sleep(3000);
		act.moveToElement(Users).click().build().perform();
		Thread.sleep(3000);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\ScreenShots\\Homepage.png");
		FileUtils.copyFile(src, trg);
		Thread.sleep(3000);
		driver.close();
		
		
	}

}
