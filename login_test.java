package Spendflo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class login_test {
	
	public WebDriver driver;
	
	//Initializes_Chrome_driver
	
	@Before
		
		public void init() throws InterruptedException, AWTException {
			System.setProperty("webdriver.chrome.driver", "D://auto//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
		
			driver.get("https://test.spendflo.com");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			System.out.println("zooming");
			Robot robot = new Robot();
			System.out.println("About to zoom Out");
				for (int i = 0; i < 2; i++) {
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_SUBTRACT);
					robot.keyRelease(KeyEvent.VK_SUBTRACT);
				}
		
		}

//Main_Spendflo_Login 
	
	@Test
	
		public void signin() throws InterruptedException, IOException, AWTException {
	
		
        	// Sign-in_Page_of_Spendflo
			driver.get("https://test.spendflo.com/account/login");
			Thread.sleep(2000);
			//User_asked_to_enter_mailId
			WebElement UserName = driver.findElement(By.xpath("//input[@data-test-id='input-email']"));
			UserName.sendKeys("rishi@spendflo.com");
			UserName.sendKeys(Keys.RETURN);
			Thread.sleep(2000);
			//After_Email_Success_Continue_button_to_be_pressed_Click_enter
			//driver.findElement(By.xpath("//input[@data-test-id='input-email']")).click();
			Thread.sleep(1000);
			//Enter_User_Password
			WebElement PassWord = driver.findElement(By.xpath("//input[@name=\"password\"]");
			PassWord.sendKeys("Rishi@2121");
			PassWord.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			//Save_Click_enter
			driver.findElement(By.xpath("//input[@name=\"password\"]")).click();
			Thread.sleep(2000);
			@SuppressWarnings("unused")
			//Screenshot
				WebElement Submit = driver.findElement(By.xpath("/html/body"));
				File SignUp = Submit.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(SignUp, new File("D:\\AutomationImages\\SingIn.png"));
				Thread.sleep(1000);		
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(3000);
				
				//Dashboard_Screenshot
				File Dashboard = Submit.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(Dashboard, new File("D:\\AutomationImages\\Dashboard\\Dashboard.png"));
				Thread.sleep(2000);
			}

	@After
	
			public void close()
			
				{
				driver.close();
				}
	}
	
	

