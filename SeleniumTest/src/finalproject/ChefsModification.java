package finalproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChefsModification {

public static void main(String[] args) throws InterruptedException, SQLException {
	
		
//		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/home");
		driver.get("http://localhost:3000/page-admin");
		Thread.sleep(1000);
		driver.findElement(By.name("Name")).sendKeys("admin");
		driver.findElement(By.name("Pass")).sendKeys("admin");
		
		
		Thread.sleep(1000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);
		
		//Choose one of the following 
		
		String at = driver.findElement(By.id("chefsadd")).getText();
//		String at = driver.findElement(By.id("chefsupdate")).getText();
//		String at = driver.findElement(By.id("chefsdelete")).getText();
		
		
		if(at.equalsIgnoreCase("ADD CHEFS")) {
			Thread.sleep(1000);
			driver.findElement(By.id("chefsadd")).click();
			
			driver.findElement(By.name("chefid")).sendKeys("6");
			driver.findElement(By.name("fname")).sendKeys("Asley");
			driver.findElement(By.name("lname")).sendKeys("Andrew");
			driver.findElement(By.name("Toc")).sendKeys("Junior Chef");
			driver.findElement(By.name("shopid")).sendKeys("2");
			Thread.sleep(1000);
			driver.findElement(By.name("modifychefs")).click();
			Thread.sleep(1000);
			
			
			Connection con = ConnectionProvider.getCon();
			
			PreparedStatement statement = con.prepareStatement("select * from chefs where FName = ? and LName = ? and Toc= ?");    
	  		statement.setString(1, "Asley");
	  		statement.setString(2, "Andrew");
	  		statement.setString(3, "Junior Chef");
	  		
	  		int count =0;
	  		
	  		ResultSet rs = statement.executeQuery();
	  		while(rs.next()) {
	  			count=1;
	  			System.out.println("Test case passed with successfull insertion of Chefs.");
	  		}
			
	  		if(count == 0) {
	  			System.out.println("Test case passed with unsuccessfull insertion of Chefs.");
	  		}
			
			
		}
		
		if (at.equalsIgnoreCase("UPDATE CHEFS")) {
			Thread.sleep(1000);
			driver.findElement(By.id("chefsupdate")).click();
			
			driver.findElement(By.name("chefid")).sendKeys("6");
			driver.findElement(By.name("fname")).sendKeys("Asley");
			driver.findElement(By.name("lname")).sendKeys("Andrew");
			driver.findElement(By.name("Toc")).sendKeys("Junior Chef");
			driver.findElement(By.name("shopid")).sendKeys("2");
			Thread.sleep(1000);
			driver.findElement(By.name("modifychefs")).click();
			Thread.sleep(1000);
			
			
            Connection con = ConnectionProvider.getCon();
			
			PreparedStatement statement = con.prepareStatement("select * from chefs where FName = ? and LName = ? and Toc= ?");    
	  		statement.setString(1, "Asley");
	  		statement.setString(2, "Andrew");
	  		statement.setString(3, "Junior Chef");
	  		
	  		int count =0;
	  		
	  		ResultSet rs = statement.executeQuery();
	  		while(rs.next()) {
	  			count=1;
	  			System.out.println("Test case passed with successfull Updation of Chefs.");
	  		}
			
	  		if(count == 0) {
	  			System.out.println("Test case passed with unsuccessfull Updation of Chefs.");
	  		}
			
			
			
		}
		
		if (at.equalsIgnoreCase("DELETE CHEFS")) {
			Thread.sleep(1000);
			driver.findElement(By.id("chefsdelete")).click();
			
			driver.findElement(By.name("chefid")).sendKeys("6");
			Thread.sleep(1000);
			driver.findElement(By.name("modifychefs")).click();
			Thread.sleep(1000);
			
			
            Connection con = ConnectionProvider.getCon();
			
			PreparedStatement statement = con.prepareStatement("select * from chefs where idChefs = ?");    
	  		statement.setString(1, "6");
	  		
	  		
	  		int count =0;
	  		
	  		ResultSet rs = statement.executeQuery();
	  		while(rs.next()) {
	  			count=1;
	  			System.out.println("Test case passed with unsuccessfull Deletion of Chefs.");
	  		}
			
	  		if(count == 0) {
	  			System.out.println("Test case passed with successfull Deletion of Chefs.");
	  		}
			
					
		}
		
			
		}



}
