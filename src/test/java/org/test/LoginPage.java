package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
			 
	public LoginPage() {						     // method is to call driver from base class, its a constructor,
		PageFactory.initElements(driver,this);
	}
	
	// for WebElement locator find 
	
	// syntax 
	// @FindBy(locator type="value")
	
	@FindBy(id="email")
	private WebElement txtUsername;
	
	@FindBy(id="pass")
	private WebElement txtPass;
	
	@FindBy(name="login")
	private WebElement login;

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getLogin() {
		return login;
	}
	
	
	
	
	
	
	
	

}
