package com.test.automation.framework.pagemodel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import com.test.automation.framework.util.Utilities;


public class TestClass {
	protected WebDriver driver;
	protected Utilities util;
	protected Browser browser;
	
	
	public TestClass(){
		initialize();
	}
	
	private void initialize(){
		this.browser = new Browser();
		this.util = new Utilities();			
	}
	
	protected void setDriver(WebDriver driver){
		this.browser.setDriver(driver);
		this.driver=driver;
	}
	
	protected <T> T to(Class<?> pageClass){
		T page = this.browser.to(pageClass);		
		return page;		
	}
	
	protected <T> T at(Class<?> pageClass){
		T page = this.browser.at(pageClass);
		return page;
	}
	
	protected boolean isAt(Class<?> pageClass){
		return this.browser.isAt(pageClass);
	}
	
	protected <T> T getPageObject(Class<?> pageClass){
		T page = this.browser.getPageObject(pageClass);		
		return page;		
	}
	
	@AfterMethod
	public void afterMethod(){
		this.browser.getDriver().manage().deleteAllCookies();
	}

}