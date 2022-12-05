package finalproject;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AdminCheckReservation {

public static void main(String[] args) throws InterruptedException, SQLException {
	
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
//		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
//		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/home");
		driver.get("http://localhost:3000/page-admin");
		Thread.sleep(1000);
		driver.findElement(By.name("Name")).sendKeys("admin");
		driver.findElement(By.name("Pass")).sendKeys("admin");
		
		
		Thread.sleep(1000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.name("date1")).sendKeys("18-DEC-22");
		//driver.findElement(By.name("reservationcheck")).click();
		
		try {
			String at = driver.findElement(By.className("admin-reservation")).getText();
			if (at.equalsIgnoreCase("Admin Reservations")) {
				System.out.println("Successfull displayed all reservations to admin on a specific date");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Failed to display all reservations of customer to admin on a specific date");
		}

	}

}
