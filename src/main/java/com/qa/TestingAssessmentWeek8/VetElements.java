package com.qa.TestingAssessmentWeek8;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VetElements {
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[3]/a")
	public static WebElement vetDropNav;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[3]/ul/li[2]/a/span[2]")
	public static WebElement vetAddNew;
	
	@FindBy(id = "firstName")
	public
	static WebElement vetFirstName;
	
	@FindBy(id = "lastName")
	public
	static WebElement vetLastname;
	
	@FindBy(xpath = "//*[@id=\"specialties\"]")
	public
	static WebElement vetTypeSelectBar;
	
	@FindBy(xpath = "//*[@id=\"specialties\"]/option[1]")
	public static WebElement vetTypeRadiology;
	
	@FindBy(xpath = "//*[@id=\"vet\"]/div[5]/div/button[2]")
	public static WebElement vetSubmit;
	
	public static void enterName(String first, String last) {
		vetFirstName.sendKeys(first);
		vetLastname.sendKeys(last);
		vetTypeSelectBar.click();
		vetTypeRadiology.click();
		vetSubmit.click();
	}
	
	
	
	

}
