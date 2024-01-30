package PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipcartHomePage 
{
WebDriver driver;
@FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
WebElement searchbox;







  public FlipcartHomePage(WebDriver driver)
  {
	  // TODO Auto-generated constructor stub 
	  this.driver=driver; 
	  PageFactory.initElements(driver, this);//mandatory for page factory //Page Factory is a design technique for reusing the code 
	  }
 







public void searchProduct(String productName) throws InterruptedException
{
	searchbox.clear();
	searchbox.sendKeys(productName);
	Thread.sleep(3000);
	Actions action = new Actions(driver);
	action.sendKeys(Keys.ENTER).build().perform();
	
}

}
