package sqa.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;

public class AutoTest {
	static WebDriver driver;
	@BeforeClass
	public static void InitTest() {
		System.setProperty("webdriver.edge.driver","D:\\eclipse-workspace\\edu.sqa\\WebContent\\driver\\msedgedriver91.exe");
		driver = new EdgeDriver();
		driver.navigate().to("http://192.168.191.132:8080/edu.sqa/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void testLogin() {
		WebElement btnLogin = driver.findElement(By.xpath("/html/body/div/div/div[2]/a[2]/button"));
		Actions action = new Actions(driver);
		
	}
}
