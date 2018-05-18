package q2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Q2 {

	
	/*
	Question 2:
		The following exercise does not require user login. Please use ID or class as selectors.
		Steps:
			1. Navigate to https://www.weightwatchers.com/us/
			2. Verify loaded page title matches “Weight Loss Program, Recipes &amp; Help | Weight Watchers”
			3. On the right corner of the page, click on “Find a Meeting”
			4. Verify loaded page title contains “Get Schedules &amp; Times Near You”
			5. In the search field, search for meetings for zip code: 10011
			6. Print the title of the first result and the distance (located on the right of location title/name)
			7. Click on the first search result and then, verify displayed location name matches with the
		name of the first searched result that was clicked.
			8. From this location page, print TODAY’s hours of operation (located towards the bottom of
		the page)
		
		Write an automated test for this scenario using WebDriver.
	*/
	
	
	static WebDriver driver;
    PageElements pageElements;


    @Test
    public void q2() throws Exception {

        //Set web driver and launch browser
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.weightwatchers.com/us/");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        pageElements = new PageElements(driver);

        //Validate titles (steps 2, 3 and 7)
        Assert.assertEquals("Weight Loss Program, Recipes & Help | Weight Watchers",pageElements.validateTitle());
        Assert.assertEquals("Find A Meeting: Get Schedules & Times Near You | Weight Watchers",pageElements.clickFindMeeting());
        String expectedLocation = pageElements.searchByZipCode("10011");
        System.out.println(expectedLocation);
        Assert.assertEquals(expectedLocation,pageElements.validateLocation());
        pageElements.getHoursOfOperation(getCurrentDay());
        driver.close();

    }

    private String getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return new SimpleDateFormat("EEEE",Locale.ENGLISH).format(date.getTime());
    }
    
}
