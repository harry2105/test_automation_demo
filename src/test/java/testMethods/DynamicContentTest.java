package testMethods;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilityFunctions.InitializeDriver;
import utilityFunctions.ScreenShotCapture;

public class DynamicContentTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException{
		InitializeDriver id=new InitializeDriver();		
		 driver=id.getDriver();		
	
	}

	@Test
	public void verifyAvatarsCount() throws IOException{	
		 driver.get("https://the-internet.herokuapp.com/dynamic_content");
		List<WebElement> avtars=driver.findElements(By.xpath("//img[contains(@src,'avatars')]"));
		Assert.assertEquals(avtars.size(), 3);
		Reporter.log("3 avtars are present in the page");
		ScreenShotCapture.capture("Avatars");
	}
	
	
	@Test
	public void verifyWordLength() throws IOException{	
		 driver.get("https://the-internet.herokuapp.com/dynamic_content");
		List<WebElement> content=driver.findElements(By.xpath("//p"));
		boolean flag=false;
		for(WebElement e : content){
			String text=e.getText();
			String[] words=text.split(" ");			
			for(String w: words){
				if(w.length()>=10){
					System.out.println(w);
					Reporter.log("Word with more than 10 character is present");
					flag=true;
					break;
				}
				if(flag==true){
					break;
				}
			}
		}
	}
	
	@Test
	public void verifyForkMeonGitLink() throws IOException{
		driver.findElement(By.xpath("//img[@alt='Fork me on GitHub']")).click();
		String currentUrl=driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://github.com/saucelabs/the-internet");
		ScreenShotCapture.capture("GitHubUrl");
	}

	@AfterTest
	public void cleanUp(){
		driver.close();
	}

}
