package Task20;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Guviregistration {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();   //Launch the Browser
		
		driver.get("https://www.guvi.in/");   //load the Url
		
		driver.manage().window().maximize();     //Maximize the window  
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));    //Use wait 
		
		driver.findElement(By.linkText("Sign up")).click();    //Click the signup button
		
		driver.findElement(By.id("name")).sendKeys("Mohana");     //send the values to the fullname field
		
		driver.findElement(By.id("email")).sendKeys("monamoorthi13@gmail.com");        //send email to the email field
		
		driver.findElement(By.id("password")).sendKeys("Guvi@123");                   //send password to the pasword field
		
		driver.findElement(By.id("mobileNumber")).sendKeys("7200968670");    //send the mobile number
		
		driver.findElement(By.id("signup-btn")).click();    //click the Signup button
		
			WebElement profile = driver.findElement(By.id("profileDrpDwn"));      //select the elements in dropdown box
	
			Select selectProfile =new Select(profile);    //using select class
	
			selectProfile.selectByVisibleText("Student");                       
	
			WebElement	Degree = driver.findElement(By.id("degreeDrpDwn"));
		
			Select  selectDegree = new Select(Degree);
			
			selectDegree.selectByVisibleText("B.E. / B.Tech. Computer Science");        //select the elements in field
			
			driver.findElement(By.id("year")).sendKeys("2015");       //send the values to the year field
			
			driver.findElement(By.id("details-btn")).click();              //click the submit button
			
			String title = driver.getTitle();                                   //to verification get title
			
			System.out.println("Verify After registrartion the title of the Webpage is:"  +title);
			
			driver.navigate().to("https://www.guvi.in/");             //navigate to the homepage
			
			driver.findElement(By.linkText("Login")).click();              //click the login button
			
			driver.findElement(By.id("email")).sendKeys("kmmona2510@gmail.com");          //give the emailid as mentioned in registration
			
			driver.findElement(By.id("password")).sendKeys("Mona@123");         //give the password as mentioned in the registration
			
			driver.findElement(By.id("login-btn")).click();      //click login button
			
			String actualTitle= driver.getTitle();     
			
		String expectedTitle ="GUVI | Login";     
			
			if(actualTitle.equals(expectedTitle)) {            //verify that the page loged in correct webpage
														
			System.out.println("The page landed in Correct Website:"  +actualTitle);
				}
			else {
				System.out.println("The page not landed in correct website");
				}
			
			
			driver.close();             //close the tab
		
	

	}

}
