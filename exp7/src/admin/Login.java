package admin;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

public class Login
{
	
	public static void main(String[] args)
	{
		new Screen();
		WebDriver d;
		WebDriverWait w;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://admin-portal.experiture.com");
		
		// WebElement e;
		
		// e = d.findElement(By.name("txtEmail"));
		// e.sendKeys("arunavad@experiture.com");
		w = new WebDriverWait(d, Duration.ofSeconds(30));
		
		w.until(ExpectedConditions.elementToBeClickable(By.name("txtEmail"))).sendKeys("arunavad@experiture.com");
		w.until(ExpectedConditions.elementToBeClickable(By.name("txtPassword"))).sendKeys("Mapps123#");
		w.until(ExpectedConditions.elementToBeClickable(By.name("btnLogin"))).click();
		
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		d.switchTo().frame("_iframe-dhtmlOpenAgencyClient");
		w.until(ExpectedConditions.elementToBeClickable(By.id("txtClient"))).sendKeys("new qa team");
		w.until(ExpectedConditions.elementToBeClickable(By.name("btnSearch"))).click();
		
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"obtClientList_ctl00__0\"]/td[1]"))).click();
		
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body[@id='pagebody']/form[@id='form1']/header[@id='exp_header']/div[@class='exptopheader']/a[@id='myheader_burgerMenu']/div[@id='menu-toggle']/div[@id='cross']")))
				.click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='aSTTargets']/i[@class='icon-right-thin-chevron']"))).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='SourcePgs']/a"))).click();
		
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.print(d.getTitle());
		
		// d.quit();
		
	}
	
}
