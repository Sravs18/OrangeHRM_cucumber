package stepdefenitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRM
{
	public static WebDriver driver;
	
	String empid;

	@Given("i open the browser with url {string}")
	public void i_open_the_browser_with_url(String url)
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		driver=new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);		
	}  
	 
	
	@Then("i should see login page")
	public void i_should_see_login_page() 
	{
		if(driver.findElement(By.id("btnLogin")).isDisplayed())
	    {
	    	System.out.println("Login Page Displayed");
	    }  
	}
	@When("i enter username as {string}")
	public void i_enter_username_as(String uname) 
	{
		   driver.findElement(By.id("txtUsername")).sendKeys(uname); 
	}
	@When("i enter password as {string}")
	public void i_enter_password_as(String pword)
	{
		   driver.findElement(By.id("txtPassword")).sendKeys(pword);
	}
	
	@When("i click login")
	public void i_click_login() 
	{
		driver.findElement(By.id("btnLogin")).click();
	}
	@Then("i should see admin module")
	public void i_should_see_admin_module() 
	{
		if(driver.findElement(By.linkText("Admin")).isDisplayed())
		   {
			  System.out.println("AdminModuleDisplayed");
		   }
	}
	@When("i click logout")
	public void i_click_logout()
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
	    driver.findElement(By.linkText("Logout")).click();
	}
	@When("i close browser")
	public void i_close_browser() 
	{
	    driver.close();
	}
	
	@Then("i should see error message")
	public void i_should_see_error_message() 
	{
	    String errmsg = driver.findElement(By.id("spanMessage")).getText();
	    if(errmsg.toLowerCase().contains("invalid")||errmsg.toLowerCase().contains("empty"))
	    {
	    	System.out.println("System displayed appropriate error message for invalid inputs");
	    }
	    
	}

	@When("i goto add employee page")
	public void i_goto_add_employee_page() 
	{
	   driver.findElement(By.linkText("PIM")).click();
	   driver.findElement(By.linkText("Add Employee")).click();
	}
	
	@When("i enter first name as {string}")
	public void i_enter_first_name_as(String fname)
	{
		driver.findElement(By.id("firstName")).sendKeys(fname); 
	}
	@When("i enter last name as {string}")
	public void i_enter_last_name_as(String lname)
	{
		driver.findElement(By.id("lastName")).sendKeys(lname);
	}
	@When("i click save")
	public void i_click_save() 
	{
	    empid=driver.findElement(By.id("employeeId")).getAttribute("value");
	    driver.findElement(By.id("btnSave")).click();
	}
	
	@Then("i should see registered employee in employee list")
	public void i_should_see_registered_employee_in_employee_list() 
	{
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		driver.findElement(By.id("searchBtn")).click();
		
		WebElement emptable=driver.findElement(By.id("resultTable")); 
		List<WebElement> rows=emptable.findElements(By.tagName("tr"));
		
		boolean result=false;
		
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equals(empid))
			{
				System.out.println("System displayed Registered employee details in Employee list");
				
			}
		}
	}
	
	@When("i go to user page")
	public void i_go_to_user_page() 
	{
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();			
	}
	
	@When("i click add")
	public void i_click_add() 
	{
		driver.findElement(By.id("btnAdd")).click();
	}
	
	
	@Then("i select role as ESS")
	public void i_select_role_as_ess() 
	{
		String role="ESS";
		Select cat=new Select(driver.findElement(By.id("systemUser_userType")));
		cat.selectByVisibleText(role);
	}
	
	@Then("i enter user name as {string}")
	public void i_enter_user_name_as(String uname) 
	{
		driver.findElement(By.id("systemUser_userName")).sendKeys(uname);
	}
	@Then("i enter employee name  as {string}")
	public void i_enter_employee_name_as(String ename)
	
	{
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(ename);
	}
	@Then("i enter password  as {string}")
	public void i_enter_password_as1(String pwd) throws InterruptedException 
	{
		driver.findElement(By.id("systemUser_password")).sendKeys(pwd);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(pwd);
		Thread.sleep(2000);
	}
	
	
	@Then("i click save button")
	public void i_click_save_button() 
	{
	   driver.findElement(By.className("addbutton")).click();
	}
	@Then("i should see registered user in the list")
	public boolean i_should_see_registered_user_in_the_list() 
	{
	
		String uname = "sravs2255";
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(uname);
		driver.findElement(By.id("searchBtn")).click();
	
		WebElement usertable=driver.findElement(By.id("tableWrapper"));
		List<WebElement> rows=usertable.findElements(By.tagName("tr"));
		
		boolean result=false;
		
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equals(uname))
			{
				result= true;
				break;
				
			}
		}
		
	
		return result;
	}

	@Then("i should see Dashboard")
	public boolean i_should_see_dashboard()
	{
	    
		
		{
			if(driver.getCurrentUrl().contains("dashboard"))
			{
				return true;
			}else
			{
				return false;
				
			}
		}
		
	}	





}







