package com.capgemini.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPagePom {
	
	public PaymentPagePom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="cardNumber")
	WebElement number;
	public void enterCardNumber() {
		number.click();
	}
	@FindBy(id="cardName")
	WebElement name;
	public void enterNameOnCard() {
		name.click();
	}
	
	@FindBy(id="expiryMonth")
	WebElement expmonth;
	public void expiryMonth() {
		expmonth.click();
	}
	@FindBy(xpath="//option[text()='FEB']")
	WebElement month;
	public void selectExpiryMonth() {
		month.click();
	}
	
	@FindBy(id="expiryYear")
	WebElement expyear;
	public void expiryYear()
	{
		expyear.click();
	}
	@FindBy(xpath="//option[text()='2023']")
	WebElement year;
	public void selectExpiryYear()
	{
		year.click();
	}
	@FindBy(id="cvv")
	WebElement cv;
	public void enterCVV()
	{
		cv.click();
	}
	@FindBy(id="action-card")
	WebElement pay;
	public void paynow()
	{
		pay.click();
	}
	//upi paymrnt for credits
	@FindBy(xpath="//span[text()='PHONEPE/GOOGLE PAY/BHIM UPI']")
	WebElement upi;
	public void selectUPI()
	{
		upi.click();
	}
	//To select phone pay in credits
	@FindBy(xpath="//span[text()='PhonePe']")
	WebElement phonepe;
	public void selectPhonePe() {
		phonepe.click();
	}
	// To click pay button in credits
	@FindBy(xpath="//button[text()='PAY NOW']")
	WebElement paybut;
	public void payInCoupons() {
		phonepe.click(); 
	}
	@FindBy(id="action-upi")
	WebElement paynow;
	public void payNow() {
		paynow.click();
	}

	//to pay to buy product
	@FindBy(xpath="//span[text()='PHONEPE/GOOGLE PAY/BHIM UPI']")
	WebElement paytype;
	public void selectPaymentOrder() {
		paytype.click();
	}
	//Select payment type to buy prodyct
	@FindBy(xpath="//span[text()='PHONEPE/GOOGLE PAY/BHIM UPI']")
	WebElement payty;
	public void selectPaymentType() {
		payty.click();
	}
	
	//Final mayment sending opt
	@FindBy(xpath="//button[@id=\"onboardingFormSubmitBtn\"]")
	WebElement otp;
	public void sendOTP() {
		otp.click();
	}
	//Final mayment otp sent to mobile number
	@FindBy(xpath="//input[@placeholder=\"Enter 5 digit OTP\"]")
	WebElement otpsent;
	public String OTPSentToNumber() {
		 return otp.getText();
			}
	
}
