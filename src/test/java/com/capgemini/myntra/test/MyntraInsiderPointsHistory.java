package com.capgemini.myntra.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.capgemini.base.Base;
import com.capgemini.pom.LoginPom;
import com.capgemini.pom.MyntraInsiderPom;
import com.capgemini.pom.ProfilePom;

public class MyntraInsiderPointsHistory{
	WebDriver driver;
	ProfilePom p;
	LoginPom login;
	MyntraInsiderPom insider;

	@Parameters({ "Email", "Password","browser","url" })
	@BeforeTest
	
	public void tests(String Email, String Password,String browser,String url) {
	
		driver=Base.startBrowser(browser, url);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		login = new LoginPom(driver);
		p = new ProfilePom(driver);
	
		
		login.enterMail(Email);
		login.password(Password);
		login.loginToMyntra();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.getMessage();
		}
		

	}
	@Test(priority=1)
	public void myntraInsiderPointsHistory() throws InterruptedException {
		p = new ProfilePom(driver);
		insider = new MyntraInsiderPom(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		p.profile();
		insider.myntraInsiderButton();
		insider.myntraInsiderPointsHistory();
		String title = driver.getTitle();

		assertEquals(title, "Myntra Insider - History");
		System.out.println(title);


	}
	

}