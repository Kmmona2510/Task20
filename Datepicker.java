package Task20;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datepicker {

	public static void main(String[] args)   {
		WebDriver driver = new ChromeDriver();     //Launch the driver
		
		String expectedMonth="March";    //get the month
		
		int selectDate=22;          //get the date
				
		driver.navigate().to("https://jqueryui.com/datepicker/");               //laod the url
		
		driver.manage().window().maximize();                     //maximize the window
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));            //use implicitly wait
		 
		WebElement frame= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));          //frame element
		
		driver.switchTo().frame(frame);                                 //switch the frame
		
		driver.findElement(By.id("datepicker")).click();                   //click the date picker
		
		driver.findElement(By.xpath("//a[@title='Next']")).click();            
		
		while(true){                                       //verify the actual month is equals to expected month
		
			String actualMonth	= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

				if(expectedMonth.equals(actualMonth)) {
		
					break;
		
					}
					else {
							driver.findElement(By.xpath("//a[@title='Next']")).click();                       //if its not click the arrow unit expected reach
							}
		
					}
		
				driver.findElement(By.xpath("((//table)[1]//tr//td[//a[text()='"+selectDate+"']])[27]")).click();         //click the selected date 
				
			
			String date = driver.findElement(By.xpath("//a[text()='22']")).getText();           //print the selected date
			
			System.out.println("The Date is :" +date);
			
			driver.close();                   //close the driver

	}

}
