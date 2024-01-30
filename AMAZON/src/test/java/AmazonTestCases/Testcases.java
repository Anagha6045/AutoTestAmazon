package AmazonTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import AutomationCore.BaseClass;
import PageClasses.AmazonHomePage;
import PageClasses.AmazonProductListingPage;
import PageClasses.FlipcartAddtoCart;
import PageClasses.FlipcartHomePage;
import PageClasses.FlipcartProductListingPage;

public class Testcases extends BaseClass {
	WebDriver driver;
	SoftAssert softassert;
	FlipcartHomePage homePage;
	FlipcartProductListingPage listingPage;
    FlipcartAddtoCart addCart;
    AmazonHomePage amazonHome;
    AmazonProductListingPage amazonList;
    
    FileInputStream fis;
    Properties prop;
    
	@BeforeMethod  //
	@Parameters({ "Browser" }) // Parameterization of testNG
	public void intialization(String browser) throws Exception {
		// driver = browserIntialization("Chrome");
		driver = browserIntialization(browser); // Parameterization of testNG
		System.out.println("Before Method");
		softassert = new SoftAssert();
		driver.manage().window().maximize();

		homePage=new FlipcartHomePage(driver);
		listingPage= new FlipcartProductListingPage(driver);
		addCart=new FlipcartAddtoCart(driver);
		amazonHome =new AmazonHomePage(driver);
		amazonList = new AmazonProductListingPage(driver);
		fis = new FileInputStream("C:\\Users\\anagh\\git\\AutoTestAmazon\\AMAZON\\src\\main\\resources\\TestData\\Testdata.properties");
		prop =new Properties();
		prop.load(fis);
		// driver.get("https://www.amazon.in/");

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
		// driver.quit();
	}

	@BeforeSuite
	public void beforesSuitMethod() {
		System.out.println("Before Suit");
	}

	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("BeforeTest");
	}


	@AfterTest
	public void afterTestMethod() {
		System.out.println("AfterTest");
	}

	@AfterSuite
	public void afterSuitMethod() {
		System.out.println("after Suit");
	}

	@Test(priority = 1)
	public void tc01() {
		System.out.println("Testcase1");
		driver.navigate().to("https://selenium.obsqurazone.com/bootstrap-alert.php");

		String value = driver.findElement(By.xpath("(//div[@class='card-header'])[2]")).getText();
		System.out.println(value);

		WebElement element = driver.findElement(By.xpath("(//*[@class='card']//child::div)[2]"));
		String tagname = element.getTagName();
		String actualresult = element.getText();
		System.out.println(actualresult + "-- check");
		// org.testng.Assert.assertEquals(actualresult, "div");
		System.out.println(tagname);

		String attribute_value = driver.findElement(By.xpath("(//div[@class='card']//child::div)[2]"))
				.getAttribute("class");
		System.out.println(attribute_value);

		// driver.findElement(By.id("autoclosable-btn-warning")).click();// one way to
		// enter /click a button
		// driver.findElement(By.id("autoclosable-btn-danger")).submit();// other way to
		// enter /click a button
		driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();
		driver.findElement(By.id("single-input-field")).sendKeys("Hai hello");
		driver.findElement(By.id("button-one")).click();
		driver.findElement(By.id("single-input-field")).clear();
		// check box
		driver.findElement(By.xpath("//a[text()='Checkbox Demo']")).click();
		driver.findElement(By.id("check-box-one")).click();
		driver.findElement(By.id("check-box-two")).click();
		// radio button
		driver.findElement(By.xpath("//a[text()=\"Radio Buttons Demo\"]")).click();
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.xpath("//a[text()='Select Input']")).click();
		// drop down
		WebElement drpdwn = driver.findElement(By.id("single-input-field"));
	
		Select obj1 = new Select(drpdwn);
		obj1.selectByVisibleText("Red");
		obj1.selectByValue("Green");
		// isEnabled
		boolean status = driver.findElement(By.id("button-first")).isEnabled();
		org.testng.Assert.assertEquals(status, true);//hard assertion

		System.out.println(status);
		boolean state = driver.findElement(By.id("button-first")).isDisplayed();
		softassert.assertEquals(state, true);//softassertion
		System.out.println(state);
		// isSelected
		// collections : set, list, arraylist
		List<WebElement> elements = driver.findElements(By.xpath("//li[@class='list-group-item']"));
		System.out.println(elements.size());
		Iterator<WebElement> itr_obj = elements.iterator();
		while (itr_obj.hasNext()) {
			String value1 = itr_obj.next().getText();
			System.out.println(value1);
		}
		softassert.assertAll();

	}

	// Action class and its implementation
	@Test(priority = 2)
	public void drag_Drop_Tc02() {
		driver.navigate().to("https://selenium.obsqurazone.com/index.php");
		driver.navigate().refresh();
		WebElement others_button = driver.findElement(By.id("others"));
		others_button.click();
		WebElement source = driver.findElement(By.xpath("(//div[@id='todrag']//child::span)[1]"));
		WebElement destination = driver.findElement(By.id("mydropzone"));
		Actions action = new Actions(driver);
		
		// action.sendKeys(Keys.ENTER).build().perform();
		// action.sendKeys(others_button, Keys.ENTER).build().perform();
		// .build().perform() is must to perform actions using action class methods.
		// action.contextClick().build().perform();// normal double click on web page
		action.dragAndDrop(source, destination).build().perform();
		// action.doubleClick(others_button).build().perform();

		driver.navigate().to("https://demo.guru99.com/test/guru99home/");
		driver.switchTo().frame("a077aa5e"); //switchTo().frame(String nameorID)
		boolean img_status = driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).isDisplayed();
		System.out.println(img_status);
		driver.switchTo().defaultContent();
	}

	// multiple window handling
	 @Test (priority = 3)
	public void windowHandlingTc03() throws InterruptedException {
		driver.get("https://www.amazon.in/?ref_=nav_signin");
		driver.navigate().refresh();
	//	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 15");
		amazonHome.searchBox().sendKeys(prop.getProperty("amazonProduct"));
		Actions actioncl = new Actions(driver);
		actioncl.sendKeys(Keys.ENTER).build().perform();
		amazonList.scrollTillProduct();
		//driver.findElement(By.xpath("//span[text()='iPhone 14 Plus (128 GB) - Starlight']")).click();
		amazonList.clickOnProduct();
		

		String parent_tab = driver.getWindowHandle(); // Get the handle of the parent window
		Set<String> handles = driver.getWindowHandles();// Get the handles of all the windows that are currently open
														// using the command:
														// which returns the set of handles.
		Iterator<String> it = handles.iterator();
		String parent = it.next();// 1st entry of the set will be parent window
		String childtab = it.next();// next pointed window will be the child window which is saved to the string
									// 'childtab'
		driver.switchTo().window(childtab);

		WebElement AddCartbtn = driver
				.findElement(By.xpath("//input[@id='add-to-cart-button' and @name='submit.add-to-cart']"));
		// Thread.sleep(2000); --- instead of this
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(AddCartbtn));
		driver.switchTo().window(parent_tab);// after performing action on child tab it points back to parent tab
		driver.navigate().refresh();
	}
	 @Test
	 public void amazonAddTem_PomSample()
	 {
		 driver.get("https://www.amazon.in/?ref_=nav_signin");
			driver.navigate().refresh(); 
			
			amazonHome.searchBox().sendKeys(prop.getProperty("amazonProduct"));
			Actions actioncl = new Actions(driver);
			actioncl.sendKeys(Keys.ENTER).build().perform();
			amazonList.scrollTillProduct();
			amazonList.clickOnProduct();
			
			String parent_tab = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> it = handles.iterator();
			String parent = it.next();
			String childtab = it.next();
			driver.switchTo().window(childtab);

			WebElement AddCartbtn = driver
					.findElement(By.xpath("//input[@id='add-to-cart-button' and @name='submit.add-to-cart']"));
			// Thread.sleep(2000); --- instead of this
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.visibilityOf(AddCartbtn));
			driver.switchTo().window(parent_tab);// after performing action on child tab it points back to parent tab
			driver.navigate().refresh();
	 }

	@Test(priority = 4)
	public void tc04() {
		System.out.println("Testcase");
		driver.navigate().to("https://demo.guru99.com/test/newtours/");
		driver.findElement(By.name("userName")).click();
		driver.findElement(By.name("userName")).sendKeys("Anagha@123");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("12234555");
		driver.findElement(By.name("password")).clear();
		// driver.findElement(By.name("submit")).click();
		// driver.quit();
	}

	@Test(priority = 5)

	public void alertsInSelenium() throws InterruptedException {
		driver.navigate().to("https://selenium.obsqurazone.com/javascript-alert.php");
		driver.findElement(By.xpath("(//button[text()='Click me!'])[1]")).click();
		Thread.sleep(2000);
		String message = driver.switchTo().alert().getText();
		System.out.println(message);
		driver.switchTo().alert().accept();// ok clickavum //instead of accept() --dismiss()-cancel

		driver.findElement(By.xpath("(//button[text()='Click me!'])[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		// driver.findElement(By.xpath("//button[text()='Click for Prompt
		// Box']")).click();
		// Alert alert=driver.switchTo().alert();
		// alert.sendKeys("Hai I am Anagha");

	}

	@Test(priority = 6)
	public void handlingTables() throws InterruptedException {
		driver.navigate().to("https://selenium.obsqurazone.com/table-sort-search.php");
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='odd' or @class='even']"));
		System.out.println(rows.size());// assertion
		driver.findElement(By.xpath("//*[@id=\"dtBasicExample_filter\"]/label/input")).sendKeys("Bruno");
		Thread.sleep(2000);
		String name = driver.findElement(By.xpath("(//tr[@class='odd' ]//child::td)[1]")).getText();
		System.out.println(name); // assertion
		// driver.findElement(By.xpath("(//tr[@class='odd' ]//child::td)[1]")).click();
		/*
		 * WebElement wb1=
		 * driver.findElement(By.xpath("(//tr[@class='odd' ]//child::td)[1]"));
		 * JavascriptExecutor jse= (JavascriptExecutor)driver;
		 * jse.executeScript("arguments[0].click();", wb1);
		 */
		// String startdate=driver.findElement(By.xpath("(//tr[@class='odd'
		// ]//child::td)[5]")).getText();
		// System.out.println(startdate);//assertion
		WebElement wb2 = driver.findElement(By.xpath("//a[text()='Table with Pagination']"));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", wb2);
		
		
		
	}

	@Test(priority = 7)
	public void handlingScrollbar() {
		driver.navigate().to("https://selenium.obsqurazone.com/table-sort-search.php");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
	}

	// @Test (priority = 8)
	public void flipCartAddCartItem() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
	
		WebElement searchbar = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
		searchbar.sendKeys("Acer Laptop");
	
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
		driver.findElement(By.partialLinkText("Acer One Intel Core i3 11th Gen 1115G4 - (8 GB/512 GB SSD/Windows 11 Home) AO 14 Z 8-415 Thin and Ligh...")).click();
        
		driver.getWindowHandle();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterate = handles.iterator();
		String parent_tab = iterate.next();
		String child_tab1 = iterate.next();

		driver.switchTo().window(child_tab1);
		WebElement  addtocart = driver.findElement(By.xpath("//button[text()='Add to cart']"));
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		  wait.until(ExpectedConditions.elementToBeClickable(addtocart));
		 
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		
		driver.switchTo().window(parent_tab);
		
		  driver.findElement(By.xpath("//span[text()='Cart']"));
		  action.sendKeys(Keys.ENTER).build().perform();
		 
	}
	@Test 
	 public void addItemflipcart() throws InterruptedException
	 {
			driver.get(prop.getProperty("flipkart"));

			homePage.searchProduct(prop.getProperty("flipkart_pdt1"));
			driver.navigate().back();
			homePage.searchProduct(prop.getProperty("flipkart_pdt2"));
			driver.navigate().back();
			homePage.searchProduct("Acer Laptop");
			listingPage.productSelected().click();
	        
			driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> iterate = handles.iterator();
			String parent_tab = iterate.next();
			String child_tab1 = iterate.next();

			driver.switchTo().window(child_tab1);
			
			addCart.addCart().click();
			addCart.waitCondition();
			
			driver.switchTo().window(parent_tab);
			
	        addCart.cartButtonClick().click();
			
	 }

	@Test
	public void fileUpload() throws AWTException {
		driver.navigate().to("https://www.ilovepdf.com/pdf_to_word");
		String path = "\"D:\\Selenium\\Automation_Testing_Selenium-Class Notes.pdf\"";
		
		StringSelection s = new StringSelection(path);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);// copied to clipbooard
		WebElement element = driver.findElement(By.xpath("//*[@id=\"pickfiles\"]"));
		element.click();
		
		Robot r = new Robot();
		
		r.delay(1000); // wait time
		r.keyPress(KeyEvent.VK_CONTROL);// ctrl+c
		r.keyPress(KeyEvent.VK_V);// ctrl+v
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	@Test(dataProvider = "login_Details")

	public void loginScenario(String username, String password) {
		driver.navigate().to("https://www.facebook.com/?sk=welcome");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		
     //   boolean errortext= driver.findElement(By.xpath("//div[@class='_9ay7']")).isDisplayed();
     //   boolean addpicture=driver.findElement(By.xpath("//span[text()='Add Picture']")).isDisplayed();
		
		List<WebElement> errortext=driver.findElements(By.xpath("//div[@class='_9ay7']"));
		boolean status;
		if(errortext.size()>=1)
		{
			status=true;
		}
		else
		{
			status=false;
		}
		
        if(status==true)
        {
        	String message = driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
    		String expectedmsg="The email address you entered isn't connected to an account. Find your account and log in.";
            System.out.println(message);
        	 Assert.assertTrue(message.equalsIgnoreCase(expectedmsg));
        }
        else if (status==false)
        {
        	String loginValue=driver.findElement(By.xpath("//span[text()='Welcome to Facebook, Surya']")).getText();
        	String loginexpected= "Welcome to Facebook, Surya";
        	Assert.assertTrue(loginValue.equals(loginexpected));
		}
        else
        {
        	System.out.println("Invalid response");
        }
        
	//	Assert.assertEquals(message,expectedmsg);
       // Assert.assertTrue(message.equalsIgnoreCase(expectedmsg));
       
        
		//hard Assert
		
		/*
		 * String expectedurl="https://www.facebook.com/?sk=welcome"; String
		 * actualurl=driver.getCurrentUrl(); org.testng.Assert.assertEquals(actualurl,
		 * expectedurl);
		 */
		 //soft Assert
			/*
			 * String expectedurl="https://www.facebook.com/?sk=welcome"; String actualurl=
			 * driver.getCurrentUrl(); softassert.assertEquals(actualurl, expectedurl);
			 * softassert.assertAll();
			 */

	}

	@DataProvider(name = "login_Details")
	public Object[][] testData() {
		Object[][] login_data = new Object[3][2];
		
		login_data[0][0] = "invalidusernameabcd@gmail.com";
		login_data[0][1] = "qwertyuiop";
		login_data[1][0] = "anaghasurendran6045@gmail.com";
		login_data[1][1] = "surya@testing";
		login_data[2][0] = "invalidusernameanother@gmail.com";
		login_data[2][1] = "asdfghjk";

		return login_data;
	}
	//@Test
	public void table() throws InterruptedException
	{
		driver.get("https://practice.expandtesting.com/tables");
		List<WebElement> table1= driver.findElements(By.xpath("//table[@id='table1']//child::th[@class='header']"));
		System.out.println(table1.size());
		Iterator<WebElement> Iterate=table1.iterator();
		while(Iterate.hasNext())
		{
			System.out.println(Iterate.next().getText());
			
		}
		List<WebElement> tablerow= driver.findElements(By.xpath("//table[@id='table1']//child::tbody//following-sibling::tr"));
		System.out.println(tablerow.size());
		Iterator<WebElement> Iterate2=tablerow.iterator();
		while(Iterate2.hasNext())
		{
			System.out.println(Iterate2.next().getText());
			
		}
		 JavascriptExecutor jse=(JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,1000)", "");
		 Thread.sleep(5000);
		 jse.executeScript("window.scrollBy(0,-250)", "");
		 
	}
	@Test
	public void iframeSample() throws InterruptedException
	{
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		WebElement element	= driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[1]/div/div/div/div[1]/a[2]/span"));
		
		Actions act =new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(element).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		//act.sendKeys(Keys.F11).build().perform();
		
	}
	
}
