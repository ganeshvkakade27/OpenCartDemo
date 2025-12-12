package testBases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
	public static WebDriver driver;
	
	public Logger logger;   // import from log4jcore
	
	public Properties p;   //to get data from properties file
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) throws IOException
	{
		FileReader file=new FileReader("./src//test/resources//config.properties");
		p=new Properties();
		p.load(file);
		
	

		final ChromeOptions chromeOptions = new ChromeOptions();

		
		 chromeOptions.addArguments("guest");
	
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver(chromeOptions);break;
		case "edge":driver=new EdgeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default:System.out.println("Invalid Browser");return;
		
		} 
		
		
		
		//driver=new ChromeDriver();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	@AfterClass
public void tearDown()
{
	driver.close();
	
}

//used to get Randome Strings
public String RandomString()    
{
	String genString=RandomStringUtils.randomAlphabetic(5);
	return genString;
	
}


public String RandomNumber()    
{
	String gennumber=RandomStringUtils.randomNumeric(10);
	return gennumber;	
}

public String alphanum()    
{
	String genString=RandomStringUtils.randomAlphabetic(3);
	String gennumber=RandomStringUtils.randomNumeric(3);

	return(genString+"@"+gennumber);
}

public String captureScreen(String tname) throws IOException 
{
	String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
	TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
	File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);

	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
	File targetFile=new File(targetFilePath);
	sourceFile.renameTo(targetFile);
	return targetFilePath;
}



}
