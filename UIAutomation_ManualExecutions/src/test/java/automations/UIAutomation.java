package automations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import io.github.bonigarcia.wdm.WebDriverManager;

public class UIAutomation {
	
	
	public static void main (String args[]) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://blazedemo.com/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();

	String title = driver.getTitle();
	System.out.println("Title of the page is :" +title);
	
	
	Select departurecity = new Select(driver.findElement(By.name("fromPort")));
	departurecity.selectByVisibleText("Boston");
	
	Select destinationcity = new Select(driver.findElement(By.name("toPort")));
	destinationcity.selectByVisibleText("Dublin");
	driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
	
	String airline = driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).getText();
	System.out.println("airline is :" +airline);
	if(airline.equalsIgnoreCase("United Airlines"))
	{
		driver.findElement(By.xpath("//input[@value='Choose This Flight']")).click();
		
	}
	
	Boolean purchaseflightpage = driver.findElement(By.xpath("//input[@value='Purchase Flight']")).isDisplayed();
	if(purchaseflightpage == true)
	{
		driver.findElement(By.name("inputName")).sendKeys("sneha");
		driver.findElement(By.name("address")).sendKeys("street 129");
		driver.findElement(By.name("city")).sendKeys("Boston");
		driver.findElement(By.name("state")).sendKeys("Massachusetts");
		driver.findElement(By.name("zipCode")).sendKeys("672009");
		Select CardType = new Select(driver.findElement(By.id("cardType")));
		CardType.selectByVisibleText("American Express");
		
		driver.findElement(By.name("creditCardNumber")).sendKeys("1234567890");
		driver.findElement(By.name("creditCardMonth")).sendKeys("10");
		driver.findElement(By.name("creditCardYear")).sendKeys("2023");
		driver.findElement(By.name("nameOnCard")).sendKeys("Ksneha");
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		Boolean confirmationpage = driver.findElement(By.xpath("//h1[contains(text(),'Thank you for your purchase today!')]")).isDisplayed();
		if(confirmationpage==true) {
		String Id = driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
		if(!Id.isEmpty())
		{
			System.out.println("Confirmation Id is created successfully " +Id);
		}
		
		driver.close();
		
		}
		
		}
	
	
	}

}
