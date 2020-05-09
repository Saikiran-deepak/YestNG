package com.capgemini.myntra.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.capgemini.base.Base;
import com.capgemini.pom.LoginPom;
import com.capgemini.pom.MyntraInsiderPom;
import com.capgemini.pom.ProfilePom;

public class MyntraInsiderSeeMore {
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
		p.profile();

	}
	@Test()
	public void myntraInsiderSeeMore() {
		insider = new MyntraInsiderPom(driver);
		insider.myntraInsiderButton();
		insider.seeMore();
	String title = driver.getTitle();
		

		assertEquals(title, "Myntra Insider - Myntra Loyalty Program|Fashion Advice,VIP Access,Extra Savings");
		System.out.println(title);
		
	}

}
