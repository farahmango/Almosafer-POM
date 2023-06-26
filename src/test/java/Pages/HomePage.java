package Pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v109.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath ="/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div/input") WebElement countryFrom ;
	@FindBy(xpath ="/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[3]/div[1]/div/div/input") WebElement countryTo ;
	@FindBy(xpath ="/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[3]/div/div/div[1]/div[1]") WebElement pickDate ;
	@FindBy(className ="DayPicker-Day") List<WebElement> dateDiv ;
	@FindBy(xpath ="/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div/button") WebElement searchButton ;

	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	public void flight_booking(String CountryFrom , String CountryTo) throws InterruptedException {
		Thread.sleep(5000);
		countryFrom.sendKeys(CountryFrom);
		countryTo.sendKeys(CountryTo);
		
		pickDate.click();
		Thread.sleep(3000);
				
		//Date 
		LocalDate currentDate = LocalDate.now();
		// Add two day to the current date
		LocalDate updatedDateFrom = currentDate.plusDays(2);	
		// Add six day to the current date
		LocalDate updatedDateTo = currentDate.plusDays(6);		

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
		// Format the LocalDate object as a string with the specified format
		String formattedDateFrom = updatedDateFrom.format(formatter);
		String formattedDateTo = updatedDateTo.format(formatter);
		
		for(int i =0 ;i< dateDiv.size() ; i++) {
			
			String disabledDate = dateDiv.get(i).getAttribute("aria-disabled");
			String dateValue = dateDiv.get(i).getAttribute("aria-label");
			System.out.println(dateDiv.get(i).getAttribute("aria-disabled"));
			System.out.println(dateDiv.get(i).getAttribute("aria-label"));

			if(disabledDate.contains("false") && dateValue.contains(formattedDateFrom)) {
					System.out.println(disabledDate);
					System.out.println(dateValue);
					Thread.sleep(5000);
					//to solve Stale Element Reference Exception
					 try{
						dateDiv.get(i).click();
					    }
					  catch(Exception e){
						  	System.out.println(e.getMessage());				
					  	}		 
				}
					
			if(disabledDate.contains("false") && dateValue.contains(formattedDateTo)) {
				System.out.println(disabledDate);
				System.out.println(dateValue);
				Thread.sleep(5000);
				//to solve Stale Element Reference Exception
				 try{
					dateDiv.get(i).click();
				     break;
				    }
				  catch(Exception e){
					  	System.out.println(e.getMessage());				
				  	}				
			} 
			
		}
		
		Thread.sleep(3000);
		searchButton.click();
		

	}
	
	
	public void book_flight_based_on_website_lang(String CountryFrom , String CountryTo ) throws InterruptedException {
		
		Thread.sleep(5000);
		countryFrom.sendKeys(CountryFrom);
		Thread.sleep(2000);

		countryTo.sendKeys(CountryTo);
		Thread.sleep(2000);
		searchButton.click();
	}



	
	
}
