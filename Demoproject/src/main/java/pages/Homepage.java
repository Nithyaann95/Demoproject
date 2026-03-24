package pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class Homepage 
	{
		private WebDriver driver;

		@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']")WebElement admin;
		@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")WebElement logouttab;
		@FindBy(xpath = "//button[@type='submit']")WebElement submitbutton;
		
		
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']")WebElement ManageNewsmoreinfo;

		public Homepage(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this); 
		}
		
		public ManageNewsPage clickOnManageNewsMoreInfo()
		{
			ManageNewsmoreinfo.click();
			return new ManageNewsPage(driver);
		}
		
		
		
		
	    public void clickOnAdminTab() 
	    {
			admin.click();
		}

		public void clickOnLogOut() 
		{
			logouttab.click();
		}

		public boolean isSubmitButtonDisplayed() 
		{
			return submitbutton.isDisplayed();
		}
	}



