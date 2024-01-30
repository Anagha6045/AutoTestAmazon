package PageClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipcartAddtoCart
{
WebDriver driver;
@FindBy(xpath = "//button[text()='Add to cart']") WebElement addToCart;
@FindBy(xpath = "//span[text()='Cart']") WebElement cartButton;



public FlipcartAddtoCart(WebDriver driver)
{
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}



public WebElement addCart()
{
	return addToCart;
	
}
public WebElement cartButtonClick()
{
	return cartButton;
	
}
public void waitCondition()
{

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	wait.until(ExpectedConditions.elementToBeClickable(addToCart));

}
}
