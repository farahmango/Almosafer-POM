package TestScenario;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.reflect.Parameter;

import Pages.HomePage;
import Pages.Parameters;


public class TestCases extends Parameters{

	WebDriver driver  = new ChromeDriver();
//	create an obj from the class it will call the constructor
	HomePage homePage = new HomePage(driver);
	Random myRandom = new Random();

	
	@BeforeTest
	public void beforeTest() {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.almosafer.com/en");
		
	}

	@Test
	public void A_test() throws InterruptedException {
		int random = myRandom.nextInt(citiesInEnglish.length);		
		homePage.flight_booking(citiesInEnglish[random], "Amman");
	}
	
	
	@Test
	public void B_tetst() throws InterruptedException {
		int random = myRandom.nextInt(URLS.length);		

		driver.get(URLS[random]);
		String Url = driver.getCurrentUrl();
		
		if(Url.equals(URLS[0])){
			homePage.book_flight_based_on_website_lang("Amman", "Jeddah");
			
		}else if(Url.equals(URLS[1])) {
			homePage.book_flight_based_on_website_lang("Riyadh", "Dubai");

		}else {
			
			myAssert.assertEquals(
					Url.equals(URLS[0]) || Url.equals(URLS[1]),
					true, "this is to test the website url ");
		}
		
	
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		
	}
	
	
}
