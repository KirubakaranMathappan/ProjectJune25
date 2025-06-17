package org.test;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNew extends BaseClass{

	public CreateNew() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getBtnCreate() {
		return btnCreate;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getSurname() {
		return surname;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignup() {
		return signup;
	}

	@FindBy(xpath="(//a[@role='button'])[2]")
	private WebElement btnCreate;
	
	@FindBy(name="firstname")
	private WebElement firstname;
	
	@FindBy(name="lastname")
	private WebElement surname;
	
	@FindBy(xpath="//label[text()='Male']")
	private WebElement gender;
	
	@FindBy(xpath="(//input[@type='text'])[5]")
	private WebElement email;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement signup;
	
	@FindBy(id="day")
	private WebElement date;
	
	@FindBy(id="month")
	private WebElement month;
	
	@FindBy(id="year")
	private WebElement year;

	public WebElement getDate() {
		return date;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
