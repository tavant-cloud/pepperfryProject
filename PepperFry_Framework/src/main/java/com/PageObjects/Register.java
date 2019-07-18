package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Base.BaseClass;

public class Register extends BaseClass {
	
	/**Web Elements*/
	By Register=By.xpath("//a[@id='registerPopupLink']//b[contains(text(),'Register')]");
    By emailID = By.name("email");
    By mobileID = By.name("mobile");
    By firstnameID = By.name("firstname");
    By lastnameID = By.name("lastname");
    By passwordID = By.id("password1-mreg");
    By genderRadio = By.xpath("//span[contains(text(),'Male')]");
    By signupID = By.id("formSubmit-popup_reg_form");
    By AlertAd=By.xpath("//iframe[starts-with(@name,'notification-frame-')]");
    By Adclose=By.xpath("//span[@class='wewidgeticon we_close icon-large']");
    
    public Register clickRegister() {
		 // wait for login link to be visible
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement register = driver.findElement(Register);
		wait.until(ExpectedConditions.visibilityOf(register));
		driver.findElement(Register).click();
		return this;
	}
		
	public Register HandleAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(AlertAd));
		driver.switchTo().frame(driver.findElement(AlertAd));
		driver.findElement(Adclose).click();
		driver.switchTo().defaultContent();
		return this;
	}
	
	public HomePage registrationDetails(String email, String mobile, String fname, String lname, String pwd ) {
		driver.findElement(emailID).sendKeys(email);
		driver.findElement(mobileID).sendKeys(mobile);
		driver.findElement(firstnameID).sendKeys(fname);
		driver.findElement(lastnameID).sendKeys(lname);
		driver.findElement(passwordID).sendKeys(pwd);
		driver.findElement(genderRadio).click();
		
		driver.findElement(signupID).click();
		driver.switchTo().defaultContent();
		return new HomePage();
	}

}
