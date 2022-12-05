package finalproject;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.*;

public class CustomerQuery {

	public static void main(String[] args) throws InterruptedException, SQLException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
//		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/home");
		driver.get("http://localhost:3000/page-contacts");
		Thread.sleep(1000);
		driver.findElement(By.name("fname")).sendKeys("Ben");
		driver.findElement(By.name("lname")).sendKeys("Stokes");
		driver.findElement(By.name("email")).sendKeys("stoksy@gmail.com");
		driver.findElement(By.name("phone")).sendKeys("23234");
		driver.findElement(By.name("message")).sendKeys("Slaughtered Pak in finals");
		
		Thread.sleep(1000);
		driver.findElement(By.name("send")).click();
		Thread.sleep(1000);
		String at = driver.getTitle();
		
		Connection con = ConnectionProvider.getCon();
		
		PreparedStatement statement = con.prepareStatement("select * from contactus where FirstName = ? and LastName = ? and Email= ?");    
  		statement.setString(1, "Ben");
  		statement.setString(2, "Stokes");
  		statement.setString(3, "stoksy@gmail.com");
  		
  		int count =0;
  		
  		ResultSet rs = statement.executeQuery();
  		while(rs.next()) {
  			count=1;
  			System.out.println("Test case passed with successfull insertion.");
  		}
		
  		if(count == 0) {
  			System.out.println("Test case passed with unsuccessfull insertion.");
  		}
  		
  		

		

	}

}
