package AmazonTestCases;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import AutomationCore.BaseClass;

public class Testcases extends BaseClass 
{
	WebDriver driver;
	@BeforeMethod
	public void intialization() throws Exception
	{
		driver = browserIntialization("Chrome");
	//	driver.get("https://www.amazon.in/"); 
		
	}
   @Test
	public void tc01()
	{
		System.out.println("Testcase1");
		driver.navigate().to("https://selenium.obsqurazone.com/bootstrap-alert.php");
		
		String value=driver.findElement(By.xpath("(//div[@class='card-header'])[2]")).getText();
		System.out.println(value);
		
		WebElement element=driver.findElement(By.xpath("(//*[@class='card']//child::div)[2]"));
		String tagname=element.getTagName();
		System.out.println(tagname);
		
		String attribute_value=driver.findElement(By.xpath("(//div[@class='card']//child::div)[2]")).getAttribute("class");
		System.out.println(attribute_value);
		
		//driver.findElement(By.id("autoclosable-btn-warning")).click();// one way to enter /click a button
	   // driver.findElement(By.id("autoclosable-btn-danger")).submit();// other way to enter /click a button
	     driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();
	     driver.findElement(By.id("single-input-field")).sendKeys("Hai hello");
	     driver.findElement(By.id("button-one")).click();
	     driver.findElement(By.id("single-input-field")).clear();
	     driver.findElement(By.xpath("//a[text()='Checkbox Demo']")).click();
	     driver.findElement(By.id("check-box-one")).click();
	     driver.findElement(By.id("check-box-two")).click();
	     driver.findElement(By.xpath("//a[text()=\"Radio Buttons Demo\"]")).click();
	     driver.findElement(By.id("inlineRadio1")).click();
	     
	     driver.findElement(By.xpath("//a[text()='Select Input']")).click();
	     
	      WebElement drpdwn=driver.findElement(By.id("single-input-field"));
	      
	      Select obj1= new Select(drpdwn);
	     // obj1.selectByVisibleText("Red");
	      obj1.selectByValue("Green");
	      
	      boolean status=driver.findElement(By.id("button-first")).isEnabled();
	      System.out.println(status);
	      boolean state=driver.findElement(By.id("button-first")).isDisplayed();
	      System.out.println(state);
	      
	     List<WebElement> elements= driver.findElements(By.xpath("//li[@class='list-group-item']"));
	     System.out.println(elements.size());
	
	}
	//@Test
	  public void tc02()
	  { System.out.println("Testcase2");
	  //driver.navigate().to("https://www.amazon.in/");
	  driver.navigate().to("https://www.flipkart.com/");
	  driver.navigate().refresh(); driver.navigate().to("https://www.myntra.com/");
	  driver.navigate().back(); driver.navigate().refresh();
	  }
	//@Test
	public void tc03()
	{
		System.out.println("Testcase3");
		driver.navigate().to("https://demo.guru99.com/test/newtours/");
        driver.findElement(By.name("userName")).click();
		driver.findElement(By.name("userName")).sendKeys("Anagha@123");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("12234555");
		driver.findElement(By.name("password")).clear();
		
		//driver.findElement(By.name("submit")).click();
		//driver.quit();
		
	}
	//@Test
	public void tc04()
	{
		System.out.println("Testcase4");
		driver.navigate().to("https://demo.guru99.com/test/newtours/");
       WebElement user_Name=driver.findElement(By.name("userName"));
       WebElement passWord=driver.findElement(By.name("password"));
		user_Name.click();
		user_Name.sendKeys("qwerty");	
		passWord.click();
		passWord.sendKeys("134334546");
		passWord.clear();
		
		}
	//@Test
	public void tc05()
	{
		driver.navigate().to("https://www.google.com/");
		WebElement search_box=driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
		WebElement search_lens=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[3]/div[3]"));
		search_lens.submit();
		//search_box.click();
		//search_box.sendKeys("Java Tutorial Javatpoint");
		//search_box.submit();
		
	}
	//@Test
	public void tc06()
	{
		System.out.println("Testcase1");
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement input_field = driver.findElement(By.id("single-input-field"));
		input_field.click();
		input_field.sendKeys("Hai");
	//	driver.close();//close current window
	//	driver.quit();//close all the tabs
		
	}
	//@Test
	public void alertsInSelenium()
	{
		driver.navigate().to("https://selenium.obsqurazone.com/javascript-alert.php");
	    driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[1]/div/div[2]/button")).click();
	    driver.switchTo().alert().accept();//ok clickavum dismiss()-cancel
	}
}
