package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Calendar {

	WebDriver driver;
	
	@BeforeMethod
	public void startbrowser()
	
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\eclipse-workspace\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test() throws InterruptedException 
	{
		driver.get("https://www.path2usa.com/travel-companions");
		
		driver.manage().window().maximize();
		
//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,200)");



driver.findElement(By.xpath("//input[@id='travel_date']")).click();

WebElement month=driver.findElement(By.xpath(" //table[@class=' table-condensed'] //th[@class='datepicker-switch']"));

while(!month.getText().contains("January"))                                                           //to select  month
{
	driver.findElement(By.xpath("//table[@class=' table-condensed'] //th[@class='next'] ")).click();
}

List<WebElement> dates=driver.findElements(By.className("day"));

for(int i=0;i<dates.size();i++)
{
	
if(dates.get(i).getText().equalsIgnoreCase("25"))
{
		dates.get(i).click();
		break;
}

}



	}}





























