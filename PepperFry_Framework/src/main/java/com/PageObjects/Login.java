package com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Base.BaseClass;


public class Login extends BaseClass{
	
	By myAcclink = By.linkText("Login");//
	By Alert = By.xpath("//iframe[starts-with(@name,'notification-frame-')]");
	By Alert_Frame = By.xpath("//iframe[starts-with(@name,'notification-frame-')]");
	By Alert_Close = By.xpath("//span[@class='wewidgeticon we_close icon-large']");
	By User_Name = By.name("user[new]");
	By User_Pass = By.name("password");
	By Submit_Login = By.name("logSubmit");
	
	
	public Login clickMyAcc() {
		 // wait for login link to be visible
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement login = driver.findElement(myAcclink);
		wait.until(ExpectedConditions.visibilityOf(login));
		driver.findElement(myAcclink).click();
		return this;
	}
		
	public Login HandleAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(Alert));
		driver.switchTo().frame(driver.findElement(Alert_Frame));
		driver.findElement(Alert_Close).click();
		driver.switchTo().defaultContent();
		return this;
	}
	
	public HomePage enter(String user, String pwd ) {
		driver.findElement(User_Name).sendKeys(user);
		driver.findElement(User_Pass).sendKeys(pwd);
		driver.findElement(Submit_Login).click();
		driver.switchTo().defaultContent();
		return new HomePage();
	}
	
		

}
