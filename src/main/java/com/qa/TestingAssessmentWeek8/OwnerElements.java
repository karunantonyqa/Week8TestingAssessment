package com.qa.TestingAssessmentWeek8;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnerElements {
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
	public static WebElement ownderNavSelect;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a/span[2]")
	public static WebElement ownerViewAll;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[2]/td[1]/a")
	public static WebElement ownerEd;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/table[2]/tbody/tr/app-pet-list[1]/table/tbody/tr/td[1]/dl/button[2]")
	public static WebElement deletePet;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/table[2]/tbody/tr/app-pet-list[1]/table/tbody/tr/td[1]/dl/button[3]")
	public static WebElement addPetVisit;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/table[2]/tbody/tr/app-pet-list[1]/table/tbody/tr/td[1]/dl/button[1]")
	public static WebElement editPet;

}
