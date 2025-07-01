package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import constants.Constants;

import utilities.FileuploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement uname;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement pword;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//parent::li/a")
	WebElement moreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	WebElement newbtn;
	@FindBy(xpath = "//input[@id='category']")
	WebElement category;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement selectgrp;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement uploadbtn;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement savebtn;
	@FindBy(xpath = "//div[contains(@class, 'alert') and contains(@class, 'success')]")
	WebElement alertmsg;

	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void moreInfoManageCategory() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, moreinfo);

	}

	public void newButton() {
		newbtn.click();
	}

	public void categoryInformation(String catgry) {
		category.clear();
		category.sendKeys(catgry);
	}

	public void selectGroup() {
		selectgrp.click();

	}

	public void fileUpload() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, uploadbtn);
		FileuploadUtility fileuploadutility = new FileuploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(uploadbtn, Constants.IMAGE);
	}

	public void saveCategoryInformations() {

		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, savebtn);
	}

	public boolean isAlertMessageIsDisplayed() {
		return alertmsg.isDisplayed();
	}
}