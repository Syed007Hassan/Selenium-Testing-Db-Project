package finalproject;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.seleniumhq.jetty9.security.authentication.LoginAuthenticator;

import com.mysql.cj.jdbc.admin.MiniAdmin;

public class AdminAuthentication {

	public static void main(String[] args) throws InterruptedException, SQLException {
	
		
//		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/");
		driver.get("http://localhost:3000/page-admin");
		Thread.sleep(1000);
		driver.findElement(By.name("Name")).sendKeys("admin");
		driver.findElement(By.name("Pass")).sendKeys("admin");
		
		
		Thread.sleep(1000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);
		
		try {
			String at = driver.findElement(By.className("admin-portal")).getText();
			if (at.equalsIgnoreCase("Admin Portal")) {
				System.out.println("Successfull Login");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Login Failed");
		}


	}

}
