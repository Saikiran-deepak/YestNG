package com.capgemini.myntra.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.capgemini.base.Base;
import com.capgemini.pom.LoginPom;
import com.capgemini.pom.MyntraInsiderPom;
import com.capgemini.pom.MyntraMasterClassInsiderPom;
import com.capgemini.pom.MyntraMasterClassInsiderVideoPom;
import com.capgemini.pom.ProfilePom;

public class MyntraInsiderVideo {

	WebDriver driver;
	ProfilePom p;
	LoginPom login;
	MyntraInsiderPom insider;
	MyntraMasterClassInsiderPom masterclass;
	MyntraMasterClassInsiderVideoPom video;

	@Parameters({ "Email", "Password", "browser", "url" })
	@BeforeMethod
	public void tests(String Email, String Password, String browser, String url) {

		driver = Base.startBrowser(browser, url);

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

	@Test(priority = 1)
	public void playVideo() {
		insider = new MyntraInsiderPom(driver);
		insider.myntraInsiderButton();
		masterclass = new MyntraMasterClassInsiderPom(driver);
		video = new MyntraMasterClassInsiderVideoPom(driver);
		masterclass.masterClassFromCelebStyle();
		masterclass.masterClassFromCelebStyleKnow();
		String title = driver.getTitle();
		assertEquals(title, "Myntra Insider Masterclass: The Best Fashion E-commerce Loyalty Program in India");
		System.out.println(title);
		video.playVideo();
		boolean enable = driver.findElement(By.xpath("//div[@class=\"masterClass-stylist-video\"]")).isEnabled();
		Assert.assertTrue(enable);
		System.out.println(enable);

	}

	@Test(priority=2)
	public void muteVideo() throws InterruptedException {
		video = new MyntraMasterClassInsiderVideoPom(driver);
		masterclass = new MyntraMasterClassInsiderPom(driver);
		insider = new MyntraInsiderPom(driver);
		insider.myntraInsiderButton();
		masterclass.masterClassFromCelebStyle();
		masterclass.masterClassFromCelebStyleKnow();
		video.playVideo();
		Thread.sleep(5000);
		boolean enable = driver.findElement(By.xpath("//button[@title=\"Mute\"]")).isEnabled();
		Assert.assertTrue(enable);
		video.muteVideo();
		System.out.println(enable);

	}

	@Test(priority=3)
	public void unmuteVideo() throws InterruptedException {
		video = new MyntraMasterClassInsiderVideoPom(driver);
		masterclass = new MyntraMasterClassInsiderPom(driver);
		insider = new MyntraInsiderPom(driver);
		insider.myntraInsiderButton();
		masterclass.masterClassFromCelebStyle();
		masterclass.masterClassFromCelebStyleKnow();
		video.playVideo();
		Thread.sleep(5000);
		video.muteVideo();
		Thread.sleep(5000);
		boolean enable = driver.findElement(By.xpath("//button[@title=\"Unmute\"]")).isEnabled();
		Assert.assertTrue(enable);
		video.unMuteVideo();
		System.out.println(enable);

	}

	@Test(priority=4)
	public void pause() throws InterruptedException {
		video = new MyntraMasterClassInsiderVideoPom(driver);
		masterclass = new MyntraMasterClassInsiderPom(driver);
		insider = new MyntraInsiderPom(driver);
		insider.myntraInsiderButton();
		masterclass.masterClassFromCelebStyle();
		masterclass.masterClassFromCelebStyleKnow();
		video.playVideo();
		Thread.sleep(5000);
		boolean enable = driver.findElement(By.xpath("//div[@class=\"vjs-control-bar\"]")).isEnabled();
		Assert.assertTrue(enable);
		video.pauseVideo();
		System.out.println(enable);

	}

	@AfterMethod
	public void clos() {
		driver.quit();
	}

}
