package Homepage;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import UIActions.uiActionHomepage;

import TestBase.testBase;

public class TC_01 extends testBase
{
	
	
	@BeforeClass
	public void setUp() throws IOException 
	{	
      init();
      log.info(" -------------------  EXECUTION STARTED -------------------------------");
      log.info("1. Open the browser : Opened in crome");
      log.info("2. Enter the URL http://practice.automationtesting.in ");
    }
	
	@Test
	public void verifyAaddToCart() 
	{
		try 
		{
			uiActionHomepage Homepage = new uiActionHomepage(driver);
			Homepage.clickOnShopAndopenHome();
			Homepage.getSliders();
			getScreenShot("TC01_Success");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			getScreenShot("TC01_Failure");
		}
	}
	
	@AfterClass
	public void endTest()
	{
		closeBrowser();
		log.info("---------------------EXECUTION ENDED -------------------------------------");
	}
}

