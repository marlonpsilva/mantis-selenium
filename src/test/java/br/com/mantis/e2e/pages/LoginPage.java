package br.com.mantis.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
private WebDriver driver;
	
	private static String URL_LOGIN_PAGE = "https://mantis-prova.base2.com.br/login_page.php";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyViewPage realizaLoginCom(String nome, String senha) {
    	driver.get(URL_LOGIN_PAGE);

        WebElement txtNome = driver.findElement(By.name("username"));
        WebElement txtEmail = driver.findElement(By.name("password"));

        txtNome.sendKeys(nome);
        txtEmail.sendKeys(senha);

        txtNome.submit();
                
        return new MyViewPage(driver);
    }
    
	public boolean estaNaPaginaDeLoginComErro(String userName) {
		return this.driver.getCurrentUrl().endsWith("/login_page.php") 
				|| this.driver.getCurrentUrl()
				.endsWith("login_page.php?return=index.php&error=1&username="+
						userName+
						"&secure_session=1&perm_login=0");
	}

}
