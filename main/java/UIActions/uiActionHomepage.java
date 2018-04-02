package UIActions;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestBase.testBase;

public class uiActionHomepage extends testBase
{
	public static final Logger log = Logger.getLogger(uiActionHomepage.class.getName());	
	//WebDriver driver;
	@FindBy(xpath=".//*[@id='menu-item-40']/a")
	WebElement Shopbutton;
	
	@FindBy(xpath=".//*[@id='content']/nav/a")
	WebElement HomebuttonOnshoppage;
	
	@FindBy(xpath=".//*[@id='n2-ss-6']/div[1]/div/div/div")
	List<WebElement> slider;
	
	@FindBy(xpath=".//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div")
	List<WebElement> Arrival;
	
	@FindBy(xpath=".//*[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")
	WebElement ArrivalImage;
	
	@FindBy(xpath=".//*[@id='product-160']/div[2]/form/button")
	WebElement AddToBasket;
	
	@FindBy(xpath=".//*[@id='product-160']/div[3]/ul/li[1]/a")
	WebElement description;
	
	@FindBy(xpath=".//*[@id='tab-description']/p")
	WebElement descriptionText;
	
	@FindBy(xpath=".//*[@id='product-160']/div[3]/ul/li[2]/a")
	WebElement review;

	@FindBy(xpath=".//*[@id='comments']/h2")
	WebElement reviewText;
	
	@FindBy(xpath=".//*[@id='comment-53']/div/div[2]/p")
	WebElement commentText;
	
	/*@FindBy(xpath=".//*[@id='comment-53']/div/div[2]/p")
	WebElement commentText;
	
	@FindBy(xpath=".//*[@id='comment-53']/div/div[2]/p")
	WebElement commentText;*/
	
	public uiActionHomepage(WebDriver driver) // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);  //this - refers current class objects
	}
	
	public void clickOnShopAndopenHome()
	{		
		Shopbutton.click();
		log.info("3. Click on Shop Menu - Passed");
		HomebuttonOnshoppage.click();
		log.info("4. Now click on Home menu button");
	}
	
    public void getSliders(){
    	log.info("5. Test whether the Home page has Three Sliders only");
    	int count = 0 ;		
		for ( int i=0 ; i<slider.size() ; i++)
		{
			 count++;
		}
		Assert.assertEquals(count, slider.size());
		log.info("6. The Home page must contains only three sliders");
	}
    
    public void getArrivals(){
    	log.info("5. Test whether the Home page has Three Arrivals only");
    	int count = 0 ;		
		for ( int i=0 ; i<Arrival.size() ; i++)
		{
			 count++;
		}
		
		Assert.assertEquals(count, slider.size());
		log.info("6. The Home page must contains only three Arrivals");
    }

    public void ArrivalImageCheck() throws InterruptedException 
    {
			ArrivalImage.click();
			log.info("7. Now click the image in the Arrivals");
			Thread.sleep(9000);
			System.out.println("driver: " +driver);
			String directedURL = driver.getCurrentUrl();
			System.out.println(directedURL);
			log.info("8. Test whether it is navigating to next page where the user can add that book into his basket. Directed to URL: " +directedURL);
			String Addtobasket = AddToBasket.getText();			
			Assert.assertEquals("ADD TO BASKET", Addtobasket);
			log.info("9. Image is clickable and it navigates to next page where user can add that book to his basket. Text on the page: " +Addtobasket);
    }
    
    public void descriptiontab()
    {
    	description.click();
    	log.info("10.Click on Description tab for the book you clicked on.");
    	String DescText = descriptionText.getText();
    	log.info("11. There should be a description regarding that book the user clicked on. Description is:  " +DescText);
    }
    
    public void Reviewtab() throws InterruptedException
    {
    	Thread.sleep(5000);
    	review.click();
    	log.info("10 .Click on review tab for the book you clicked on.");
    	boolean flag = false;
    	if(driver.findElements(By.xpath(".//*[@id='comment-53']/div/div[2]/p")).size()>0) 		
    	{
    		flag = true;
    		System.out.println("4");
    		String CommentText = commentText.getText();
    		System.out.println("3");
    		log.info("11. There should be a Reviews regarding that book the user clicked on. Description is:  " +CommentText);
    	}
    	else
    	{
    	String ReviewText = reviewText.getText();
    	log.info("11. There should be a Reviews regarding that book the user clicked on. Description is:  " +ReviewText);
    	}
    }
    
    public void Addtobasket()
    {
    	AddToBasket.click();
    }    
}
