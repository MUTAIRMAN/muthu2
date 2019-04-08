package India.Muthu;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class Selenium {
  WebDriver driver;//webdriver extends SearchContext which has two methods FindElement & Findelements
	
	@Test
	public void muthu()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Muthukumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		// JavascriptExecutor j=(JavascriptExecutor)driver;
			//j.executeScript("argument[0].Scrollintoview();",element);
				 driver.get("https://facebook.com");;
	}
	@Test
  public void f() throws IOException, InterruptedException, AWTException {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Muthukumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 String homePage = "http://www.google"
		 		+ ".com";
	        
		 driver.get(homePage);
		//driver.findElement(By.xpath("//td[(contains(text(),'Bank 2'))]/preceding-sibling::td/a")).click();
		Thread.sleep(2000);
		
		Student s1=new Student(0, "Muthukumar", 52);
		Student s2=new Student(1,"Ram",24);
		
		ArrayList al=new ArrayList();
		al.add(s1);
		al.add(s2);
		
		Collections.sort(al,new AgeComparator());
		
		Iterator itr2=al.iterator();  
		while(itr2.hasNext()){  
		Student st=(Student)itr2.next();  
		System.out.println(st.rollno+" "+st.name+" "+st.age);  
		}  

		
		
		/*driver.findElement(By.name("q")).sendKeys("mut");
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\Muthukumar\\Desktop\\mut.jpeg");

        //Copy file at destination
		FileHandler.copy(SrcFile, DestFile);//import commonio to use FileUtils
		  
		  ///xpath axes
		  ///following,following-sibling,child,ancestor,descendant,text(),contains(),starts-with()
		  ///action is a interface & actions is a class
		//driver.get("http://demo.guru99.com/test/drag_drop.html");					
        
		//Element which needs to drag.    		
        //	WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
         
         //Element on which need to drop.		
         //WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));					
         		
         //Using Action class for drag and drop.		
        // Actions act=new Actions(driver);					
         	
	//Dragged and dropped.		
         //act.dragAndDrop(From, To).build().perform();	
         
       //  Thread.sleep(3000);
         
	 
	// Cell cell = (Cell) row.getCell(0);
	  //                     System.out.println(cell);*/
		
//		Pattern p=Pattern.compile(".*");
//		Matcher m=p.matcher("muthu");
		
//		Boolean b=m.matches();

	//	System.out.println(b);
         
	//  Object j=null;
	  //System.out.println(j.toString());
		
		
					//To close IE by TaskManager

		Thread.sleep(2000);
WebDriverWait w=new WebDriverWait(driver,2000);
WebElement element=driver.findElement(By.xpath("//a"));
w.until(ExpectedConditions.visibilityOf(element));



List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println("Total links are "+links.size());
		
		for(int i=0;i<links.size();i++)
		{
			
			WebElement ele= links.get(i);
			
			String url=ele.getAttribute("href");
			
			verifyLinkActive(url);
			
		}

		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		  Runtime.getRuntime().exec("taskkill /F /IM Chromedriver.exe");

	}
	
	public static void verifyLinkActive(String linkUrl)
	{
        try 
        {
           URL url = new URL(linkUrl);
           
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
           
           httpURLConnect.setConnectTimeout(3000);
           
           httpURLConnect.connect();
           
           if(httpURLConnect.getResponseCode()==200)
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {
           
        }

        }
		
		

		
		  
		  
	}


	 
	 

	

