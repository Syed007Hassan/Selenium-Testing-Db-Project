package finalproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;

public class Reservations {

public static void main(String[] args) throws InterruptedException, SQLException {
	
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
//		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
//		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/page-book-table");
		Thread.sleep(1000);

		try {
			Select nop = new Select(driver.findElement(By.id("num")));
			nop.selectByVisibleText("30");
			
			Select day = new Select(driver.findElement(By.id("day")));
			day.selectByVisibleText("18-DEC-22");
			
			Select time = new Select(driver.findElement(By.id("time")));
			time.selectByVisibleText("4:00 PM");
			
			driver.findElement(By.name("fname")).sendKeys("Michel");
			driver.findElement(By.name("lname")).sendKeys("Clark");
			driver.findElement(By.name("phone")).sendKeys("+934388");
			
			
			driver.findElement(By.name("booktablebutton")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		

		Connection con = ConnectionProvider.getCon();
		
		PreparedStatement statement = con.prepareStatement("select * from bookingsmade where CName = ? and CPhone = ? and Date= ? and Time=?");    
  		statement.setString(1, "Michel Clark");
  		statement.setString(2, "+934388");
  		statement.setString(3, "18-DEC-22");
  		statement.setString(4, "1:00 PM");
  		
  		int count =0;
  		
  		ResultSet rs = statement.executeQuery();
  		while(rs.next()) {
  			count=1;
  			System.out.println("Test case passed with successfull Reservation.");
  		}
		
  		if(count == 0) {
  			System.out.println("Test case passed with unsuccessfull Reservation.");
  		}
		
		
		
		
	}

}
