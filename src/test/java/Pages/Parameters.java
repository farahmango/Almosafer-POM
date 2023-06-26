package Pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

public class Parameters {
	public SoftAssert myAssert = new SoftAssert();
	public Random myRandom = new Random();
	
	public String [] URLS ={"https://www.almosafer.com/ar","https://www.almosafer.com/en"};
	public  String [] citiesInEnglish ={"Riyadh","Dubai","Jeddah"};
	public String [] citiesInArabic ={"Amman" , "Jeddah"};
	public String DefaultCurrency = "SAR";
	public String ContactNumber = "+966554400000";
	
}
