package test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Links {


	WebDriver driver;

	@BeforeMethod
	public void startbrowser()
	
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\\\Hp\\eclipse-workspace\\appium\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test() throws InterruptedException
	{
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
	List<WebElement> element=driver.findElements(By.tagName("a"));     //to get link size
		int count=	element.size();
	System.out.println(count);
	
	
	/*
	 * for(int i=1;i<=count;i++) { String
	 * linkclick=Keys.chord(Keys.CONTROL,Keys.ENTER); //to click on every link
	 * element.get(i).sendKeys(linkclick); }
	 */
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,2000)");
	

	Thread.sleep(3000);
	
	WebElement footerxpath=driver.findElement(By.id("gf-BIG"));
	
List<WebElement> footerlinks=	footerxpath.findElements(By.tagName("a"));   //driver scope get restric ted to footer only
	
	
int totallinkinfooter=	footerlinks.size();
System.out.println(totallinkinfooter);

for(int i=0;i<totallinkinfooter;i++)
{
	String s=Keys.chord(Keys.CONTROL,Keys.ENTER);
	footerlinks.get(i).sendKeys(s);
}
	
Thread.sleep(6000);	

Set<String> windows=driver.getWindowHandles();
                                                                    //fetching title of each and evry page by clicking on link
Iterator<String>it=windows.iterator();

while(it.hasNext())
{
String title=	driver.switchTo().window(it.next()).getTitle();
System.out.println(title);
}
	}
	}
	

