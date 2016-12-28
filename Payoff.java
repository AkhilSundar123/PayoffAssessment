package Payoff;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;




public class PayoffAssessment {

		public static WebDriver driver;
		
// BrowserSelection method allows to choose the available Browser on the system. Here
// I have used only three browsers Chrome, Firefox and InternetExplorer
		
		private static WebDriver browserSelection() {
			
			
			System.out.println("Enter the Browser FireFox, Chrome, IE");
			Scanner inp = new Scanner(System.in);
			
			String in = inp.nextLine();   // Takes input from the console
			
			// Based on the browser selected by user that driver will be set
			
				switch(in.toLowerCase()){
				
				case "firefox" 	: driver = new FirefoxDriver();
									break;
				case "chrome" 	: driver = new ChromeDriver();
									break;
				case "ie" 		:  driver = new InternetExplorerDriver();
									break;
									
				default : System.out.println("Invalid Input");
							System.exit(0);
							break;
				}
			
			
			return driver;
			
		}

		
		
		public static void main(String[] args) {
			
						
			WebDriver driver = browserSelection();
			
			// Implicitly wait inorder to avoid network delay between steps
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
			
			// /get Endpoint is validated by clicking on the hyperlink 
			
			driver.get("http://httpbin.org/");
			driver.findElement(By.xpath("//*[@id=\"manpage\"]/div/ul[1]/li[5]/a/code")).click();
			String Text = driver.findElement(By.xpath("/html/body/pre")).getText();
			
			// After redirecting to /get page, just for validation if it contains url than it is working
					
			if(driver.getPageSource().contains("http://httpbin.org/get")){
				System.out.println("/get working");
				}
			else{
				System.out.println("/get not working");
				} 
			
			
			driver.navigate().back();
			

			// /form Endpoint is validated by clicking on the hyperlink
			// And after clicking form appears below commands are to fill up the form details
			// And submit button is clicked
			
			driver.findElement(By.xpath("//*[@id=\"manpage\"]/div/ul[1]/li[42]/a/code")).click();
			driver.findElement(By.xpath("/html/body/form/p[1]/label/input")).sendKeys("Akhil Sundar");
			driver.findElement(By.xpath("/html/body/form/p[2]/label/input")).sendKeys("321-265-2606");
			driver.findElement(By.xpath("/html/body/form/p[3]/label/input")).sendKeys("akhil.sundar.123@gmail.com");
			driver.findElement(By.xpath("/html/body/form/fieldset[1]/p[1]/label/input")).click();
			driver.findElement(By.xpath("/html/body/form/fieldset[2]/p[2]/label/input")).click();
			driver.findElement(By.xpath("/html/body/form/p[4]/label/input")).sendKeys("1145AM");
			driver.findElement(By.xpath("/html/body/form/p[5]/label/textarea")).sendKeys("Call Upon Arrival");
			driver.findElement(By.xpath("/html/body/form/p[6]/button")).click();
			
			// After submitting if redirected page contains the URL given below, than it is working 
			
			if(driver.getPageSource().contains("http://httpbin.org/post")){
				System.out.println("/form working");
				}
			else{
				System.out.println("/form not working");
				} 
			
			// Navigating to the home page where it contains different Endpoints
			
			driver.navigate().to("http://httpbin.org/");
			
			
			// /post Endpoint is being validated
			// The element is validated by checking whether it has href or not
			
			
			WebElement post = driver.findElement(By.tagName("a"));
			boolean link = post.getAttribute("href").contains("/post");
			
			
			if(link == true)
			{
			System.out.println("Element is clickable");
			}
			else
			{
			System.out.println("Element is not clickable");
			}
			
						
			
	}



		

}
