package Homepage;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestBase.testBase;
import UIActions.uiActionHomepage;

public class TC_08 extends testBase
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
		try {
			uiActionHomepage Homepage = new uiActionHomepage(driver);
			
			getScreenShot("TC08_Success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getScreenShot("TC08_Failure");
		}
	}
	
	@AfterClass
	public void endTest()
	{
		closeBrowser();
		log.info("---------------------EXECUTION ENDED -------------------------------------");
	}

}
