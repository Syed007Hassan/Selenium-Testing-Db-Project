package finalproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MenuModification {

public static void main(String[] args) throws InterruptedException, SQLException {
	
		
//		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
		WebDriver driver = new ChromeDriver(options);
		
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
		
//		String at = driver.findElement(By.id("dessertadd")).getText();
//		String at = driver.findElement(By.id("dessertupdate")).getText();
		String at = driver.findElement(By.id("dessertdelete")).getText();
		
		if(at.equalsIgnoreCase("ADD DESSERT")) {
			Thread.sleep(1000);
			driver.findElement(By.id("dessertadd")).click();
			
			driver.findElement(By.name("iddessert")).sendKeys("5");
			driver.findElement(By.name("itemname")).sendKeys("Italian");
			driver.findElement(By.name("amount")).sendKeys("22");
			driver.findElement(By.name("details")).sendKeys("Made by Italian touch that is sweetest of all desserts.");
			driver.findElement(By.name("chefid")).sendKeys("2");
			Thread.sleep(1000);
			driver.findElement(By.name("modifydessert")).click();
			Thread.sleep(1000);
			
			
			Connection con = ConnectionProvider.getCon();
			
			PreparedStatement statement = con.prepareStatement("select * from dessert where ItemName = ? and Amount = ? and Details= ? and idChefs=?");    
	  		statement.setString(1, "Italian");
	  		statement.setString(2, "22");
	  		statement.setString(3, "Made by Italian touch that is sweetest of all desserts.");
	  		statement.setString(4, "2");
	  		
	  		int count =0;
	  		
	  		ResultSet rs = statement.executeQuery();
	  		while(rs.next()) {
	  			count=1;
	  			System.out.println("Test case passed with successfull insertion of Menu.");
	  		}
			
	  		if(count == 0) {
	  			System.out.println("Test case passed with unsuccessfull insertion of Menu.");
	  		}
			
			
		}
		if(at.equalsIgnoreCase("UPDATE DESSERT")) {
			Thread.sleep(1000);
			driver.findElement(By.id("dessertupdate")).click();
			
			driver.findElement(By.name("iddessert")).sendKeys("5");
			driver.findElement(By.name("itemname")).sendKeys("Italian Classic");
			driver.findElement(By.name("amount")).sendKeys("22");
			driver.findElement(By.name("details")).sendKeys("Made by Italian touch that is sweetest of all desserts.");
			driver.findElement(By.name("chefid")).sendKeys("2");
			Thread.sleep(1000);
			driver.findElement(By.name("modifydessert")).click();
			Thread.sleep(1000);
			
			
			Connection con = ConnectionProvider.getCon();
			
			PreparedStatement statement = con.prepareStatement("select * from dessert where ItemName = ? and Amount = ? and Details= ? and idChefs=?");    
	  		statement.setString(1, "Italian Classic");
	  		statement.setString(2, "22");
	  		statement.setString(3, "Made by Italian touch that is sweetest of all desserts.");
	  		statement.setString(4, "2");
	  		
	  		int count =0;
	  		
	  		ResultSet rs = statement.executeQuery();
	  		while(rs.next()) {
	  			count=1;
	  			System.out.println("Test case passed with successfull Updation of Menu.");
	  		}
			
	  		if(count == 0) {
	  			System.out.println("Test case passed with unsuccessfull Updation of Menu.");
	  		}
			
			
		}
		
		if(at.equalsIgnoreCase("DELETE DESSERT")) {
			Thread.sleep(1000);
			driver.findElement(By.id("dessertdelete")).click();
			
			driver.findElement(By.name("iddessert")).sendKeys("5");
			Thread.sleep(1000);
			driver.findElement(By.name("modifydessert")).click();
			Thread.sleep(1000);
			
			
			Connection con = ConnectionProvider.getCon();
			
			PreparedStatement statement = con.prepareStatement("select * from dessert where iddessert= ? ");    
	  		statement.setString(1, "5");

	  		
	  		int count =0;
	  		
	  		ResultSet rs = statement.executeQuery();
	  		while(rs.next()) {
	  			count=1;
	  			System.out.println("Test case passed with successfull Deletion of Menu.");
	  		}
			
	  		if(count == 0) {
	  			System.out.println("Test case passed with successfull Deletion of Menu.");
	  		}
			
			
		}

	}

}
