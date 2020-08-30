package br.com.mantis.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportIssuePage {

	private WebDriver driver;

	public ReportIssuePage(WebDriver driver) {
		this.driver = driver;
	}

	public ViewIssuesPage preencheForm(String category, String summary, String description) {
		
		driver.findElement(By.name("category_id")).click();
		{
	      WebElement dropdown = driver.findElement(By.name("category_id"));
	      dropdown.findElement(By.xpath("//option[. = '" + category + "']")).click();
	    }
	    driver.findElement(By.name("category_id")).click();
	    
	    driver.findElement(By.name("summary")).sendKeys("This is Test Features");
	    driver.findElement(By.name("description")).sendKeys("Features Description");
	    
	    clickSubmit();
		
		return new ViewIssuesPage(driver);	
	}
	
	public boolean estaNaPaginaDeReportIssue() {
		Boolean currentUrl = this.driver.getCurrentUrl().endsWith("/bug_report_page.php");
		return currentUrl;
	}
	
	public boolean erroReportIssueCamposObrigatorios() {
		Boolean currentUrl = this.driver.getCurrentUrl().endsWith("/bug_report.php");
		Boolean nameErro = this.driver.getPageSource().contains("APPLICATION ERROR #11");
		return currentUrl || nameErro;
	}
	
	public void clickSubmit() {
		driver.findElement(By.name("report_bug_form")).submit();
	}
	
	public void logout() {
		driver.findElement(By.linkText("Logout")).click();
	}
}
