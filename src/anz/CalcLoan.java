package anz;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalcLoan {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//label[@for='application_type_single']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@title='Number of dependants']/option[1]")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='borrow_type_home']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text'and @aria-describedby='q2q1i1 q2q1i2']")).sendKeys("80000");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text'and @aria-describedby='q2q2i1 q2q2i2']")).sendKeys("10000");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='expenses']")).sendKeys("500");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='homeloans']")).sendKeys("0");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='otherloans']")).sendKeys("100");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text'and @aria-describedby='q3q4i1 q3q4i2']")).sendKeys("0");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='credit']")).sendKeys("10000");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='btnBorrowCalculater']")).click();
		Thread.sleep(3000);
		String msg = driver.findElement(By.xpath("//span[@id='borrowResultTextAmount']")).getText();
		if (msg.contains("$506,000") )
		{ 
		    System.out.println("Successfully validated borrowing estimated amount");
		}else{
		    System.out.println("Please enter all details");
		}
		//System.out.println("The borrowing estimate is :" +" "+msg);
		driver.findElement(By.xpath("//div[@class='borrow__result text--white clearfix']"
		+"/div[@class='box--right']/button[@class='start-over']")).click();
		
		//driver.quit();
		
		
	}

}
