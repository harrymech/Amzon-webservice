package com.inetBanking.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String baseUrl =readconfig.getApplicationURL();
	public String userName = ReadConfig.getUserName();
	public String password = ReadConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
	
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j2.properties");
		
		if(br.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
			
			} else if(br.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
				driver= new FirefoxDriver();
			}
		
		driver.get(baseUrl);
		
	}
	
	@AfterClass
	public void tearDown() {
	driver.quit();
	}

}
