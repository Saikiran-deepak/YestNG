package com.capgemini.myntra.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.capgemini.base.Base;
import com.capgemini.pom.AddressPagePom;
import com.capgemini.pom.EssentialsPom;
import com.capgemini.pom.LoginPom;
import com.capgemini.pom.MyntraBagPom;
import com.capgemini.pom.MyntraCreditPom;
import com.capgemini.pom.MyntraCreditTopUpPom;
import com.capgemini.pom.PaymentPagePom;
import com.capgemini.pom.ProfilePom;

public class EndToEndCoupons extends Base {

	LoginPom login;
	MyntraCreditPom credit;
	MyntraCreditTopUpPom topup;
	PaymentPagePom payment;
	ProfilePom p;
	EssentialsPom coupons;
	MyntraBagPom bagp;
	AddressPagePom add;

	@Parameters({ "Email", "Password", "browser", "url" })
	@BeforeTest

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

	}

	@Parameters({ "Coupon" })
	@Test
	public void Test(String Coupon) throws InterruptedException {
		login = new LoginPom(driver);
		p = new ProfilePom(driver);
		coupons = new EssentialsPom(driver);
		add = new AddressPagePom(driver);
	

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		p.SelectEssentials();

		p.selectBodycare();

		coupons.selectProduct();
		coupons.clickAddToBag();
		coupons.selectProductSize();
		bagp = new MyntraBagPom(driver);
		bagp.clickOnBagIcon();
		bagp.clickOnAddCoupons();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bagp.addCoupons(Coupon);
		bagp.applyAfterAddingCoupon();
		bagp.placeOrder();
		add.selectAddress();
		PaymentPagePom payment = new PaymentPagePom(driver);
		payment.selectPaymentOrder();
		payment.selectPhonePe();
		payment.payNow();
//		payment.sendOTP();
//		String actual = payment.OTPSentToNumber();
//		String expected="SENDING OTP";
//		Assert.assertEquals(actual, expected);

	}

}