package AmazonTestCases;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import AutomationCore.BaseClass;

public class Testcases extends BaseClass 
{
	WebDriver driver;
	
	
	@BeforeMethod
	public void intialization() throws Exception
	{
		driver = browserIntialization("Chrome");
	//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
	//	driver.get("https://www.amazon.in/"); 
		
	}
   //@Test
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
	     //check box
	     driver.findElement(By.xpath("//a[text()='Checkbox Demo']")).click();
	     driver.findElement(By.id("check-box-one")).click();
	     driver.findElement(By.id("check-box-two")).click();
	     //radio button
	     driver.findElement(By.xpath("//a[text()=\"Radio Buttons Demo\"]")).click();
	     driver.findElement(By.id("inlineRadio1")).click();
	     driver.findElement(By.xpath("//a[text()='Select Input']")).click();
	     //drop down
	      WebElement drpdwn=driver.findElement(By.id("single-input-field"));
	      Select obj1= new Select(drpdwn);
	      obj1.selectByVisibleText("Red");
	      obj1.selectByValue("Green");
	      //isEnabled
	      boolean status=driver.findElement(By.id("button-first")).isEnabled();
	      System.out.println(status);
	      boolean state=driver.findElement(By.id("button-first")).isDisplayed();
	      System.out.println(state);
	      //isSelected
	      //collections : set, list, arraylist
	     List<WebElement> elements= driver.findElements(By.xpath("//li[@class='list-group-item']"));
	     System.out.println(elements.size());
	     Iterator<WebElement> itr_obj=elements.iterator();
			while(itr_obj.hasNext())
			{
				String value1= itr_obj.next().getText();
				System.out.println(value1);
			}
   
	}
   
   // Action class and its implementation
	//@Test
	  public void drag_Drop_Tc02()
	  { 	   
		 driver.navigate().to("https://selenium.obsqurazone.com/index.php");
         driver.navigate().refresh();
	     WebElement others_button=driver.findElement(By.id("others"));
	     others_button.click();
	     WebElement source = driver.findElement(By.xpath("(//div[@id='todrag']//child::span)[1]"));
	     WebElement destination = driver.findElement(By.id("mydropzone"));
	     Actions action=new Actions(driver);
	   //action.sendKeys(Keys.ENTER).build().perform();
	   //action.sendKeys(others_button, Keys.ENTER).build().perform();
	         //.build().perform() is must to perform actions using action class methods.
	   //action.contextClick().build().perform();// normal double click on web page
	     action.dragAndDrop(source, destination).build().perform(); 
	   //action.doubleClick(others_button).build().perform();
	     
	     driver.navigate().to("https://demo.guru99.com/test/guru99home/");
	     driver.switchTo().frame("a077aa5e");
	     boolean img_status= driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).isDisplayed();
	     System.out.println(img_status);
	     driver.switchTo().defaultContent();
	  }
	  //multiple window handling
	//@Test
	public void windowHandlingTc03() throws InterruptedException
	{
		driver.get("https://www.amazon.in/?ref_=nav_signin");
		driver.navigate().refresh();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 15");
		Actions actioncl =new Actions(driver);
		actioncl.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("(//span[text()='iPhone 15 (128 GB) - Blue' ])[1]")).click();
		
		String parent_tab=driver.getWindowHandle(); //Get the handle of the parent window 
		Set<String> handles= driver.getWindowHandles();//Get the handles of all the windows that are currently open using the command: 
		                                               //which returns the set of handles.
		Iterator<String> it= handles.iterator();
		String parent=it.next();//1st entry of the set will be parent window
		String childtab=it.next();//next pointed window will be the child window which is saved to the string 'childtab'
		driver.switchTo().window(childtab);
		
		
		
		WebElement AddCartbtn= driver.findElement(By.xpath("//input[@id='add-to-cart-button' and @name='submit.add-to-cart']"));
		//Thread.sleep(2000);    --- instead of this
		wait.until(ExpectedConditions.visibilityOf(AddCartbtn));
		driver.switchTo().window(parent_tab);// after performing action on child tab it points back to parent tab
		driver.navigate().refresh();
	}
	//@Test
	public void tc04()
	{
		System.out.println("Testcase");
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
	
	public void alertsInSelenium() throws InterruptedException
	{
		driver.navigate().to("https://selenium.obsqurazone.com/javascript-alert.php");
	    driver.findElement(By.xpath("(//button[text()='Click me!'])[1]")).click();
	    Thread.sleep(2000);
	    String message =driver.switchTo().alert().getText();
	    System.out.println(message);
	    driver.switchTo().alert().accept();//ok clickavum //instead of accept() --dismiss()-cancel
	    
	    driver.findElement(By.xpath("(//button[text()='Click me!'])[2]")).click();
	    Thread.sleep(2000);
	    driver.switchTo().alert().dismiss();
	  //  driver.findElement(By.xpath("//button[text()='Click for Prompt Box']")).click();
	  //  Alert alert=driver.switchTo().alert();
	   // alert.sendKeys("Hai I am Anagha");
	    
	     
	}
	
	//@Test
	public void handlingTables() throws InterruptedException
	{
		driver.navigate().to("https://selenium.obsqurazone.com/table-sort-search.php");
		List <WebElement> rows = driver.findElements(By.xpath("//tr[@class='odd' or @class='even']"));
		System.out.println(rows.size());//assertion
		driver.findElement(By.xpath("//*[@id=\"dtBasicExample_filter\"]/label/input")).sendKeys("Bruno");
	    Thread.sleep(2000);
	    String name= driver.findElement(By.xpath("(//tr[@class='odd' ]//child::td)[1]")).getText();
	    System.out.println(name); //assertion
	   // driver.findElement(By.xpath("(//tr[@class='odd' ]//child::td)[1]")).click();
	  /*  WebElement wb1= driver.findElement(By.xpath("(//tr[@class='odd' ]//child::td)[1]"));
	    JavascriptExecutor jse= (JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].click();", wb1);*/
	   // String startdate=driver.findElement(By.xpath("(//tr[@class='odd' ]//child::td)[5]")).getText();
	   // System.out.println(startdate);//assertion
	    WebElement wb2= driver.findElement(By.xpath("//a[text()='Table with Pagination']"));
	    JavascriptExecutor jse= (JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].click();", wb2);
	}
	
	//@Test
	public void handlingScrollbar()
	{
		driver.navigate().to("https://selenium.obsqurazone.com/table-sort-search.php");
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		
	}
	@Test
	public void flipCartAddCartItem()
	{
		 driver.get("https://www.flipkart.com/");
		 WebElement searchbar =driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
		 searchbar.sendKeys("Acer Laptop");
		 Actions action= new Actions(driver);
	 
		 action.sendKeys(Keys.ENTER).build().perform();
		 driver.findElement(By.partialLinkText("Acer One Intel Core i3 11th Gen 1115G4 - (8 GB/512 GB SSD/Windows 11 Home) AO 14 Z 8-415 Thin and Ligh...")).click();
	     
		 driver.getWindowHandle();
		 
		 Set<String> handles = driver.getWindowHandles();
		 Iterator<String> iterate= handles.iterator();
		  String parent_tab=iterate.next();
		  String child_tab1=iterate.next();
		  
		  driver.switchTo().window(child_tab1);
		  WebElement addtocart= driver.findElement(By.xpath("//button[text()='Add to cart']"));
		
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		  wait.until(ExpectedConditions.elementToBeClickable(addtocart));
		  
		
		  //  driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		  driver.switchTo().window(parent_tab);
		   
		
		  driver.findElement(By.xpath("//span[text()='Cart']"));
		  action.sendKeys(Keys.ENTER).build().perform();
	}
	
	}

