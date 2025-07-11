package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	/*@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	WebElement newbtn;
	@FindBy(xpath = "//input[@id='category']")
	WebElement category;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement selectgrp;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement uploadbtn;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement savebtn;
	@FindBy(css="button[name='create']")
	WebElement alertmsg;*/
	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement newlist;
	@FindBy(xpath = "//input[@id='category']")
	WebElement category;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement group;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement image;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
	@FindBy(css="button[name='create']")
	WebElement alertmsg;
	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	public ManageCategoryPage newlist() {
		newlist.click();
		return this;
	}

	public ManageCategoryPage  categoryInformation(String catgry) {
		category.clear();
		category.sendKeys(catgry);
		return this;
	}

	public ManageCategoryPage selectGroup() {
		group.click();
		return this;

	}

	public ManageCategoryPage  fileUpload() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver,image);
		FileuploadUtility fileuploadutility = new FileuploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(image, Constants.IMAGE);
		return this;
	}

	public ManageCategoryPage  saveCategoryInformations() {

		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver,  save);
		return this;
	}

	public boolean isAlertMessageIsDisplayed() {
		return alertmsg.isDisplayed();
	}
}