package pages;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//import org.testng.Assert;

public class PaginaPrincipal 
{	
	
	@FindBy(xpath = "//input[@class='InputBar__SearchInput-t6v2m1-1 iJaFAt']")
	private WebElement inputFieldBuscar;
	
	@FindBy (xpath="//div[@name='breadcrumb']")
	private WebElement breadcrump;
	
	
	@FindBy(xpath = "//button[@class='InputBar__SearchButton-t6v2m1-2 jRChuZ']")
	private WebElement btnBuscar;
	
	
	public void insertValueFieldBuscar (String valor)
	{
		inputFieldBuscar.sendKeys(valor);
	}
	
	public void clickBtnBuscar()
	{
		this.btnBuscar.click();
	}
	
	public void getBusquedaPrincipalPage(String valor)
	{	this.insertValueFieldBuscar(valor);
		this.clickBtnBuscar();
	}

	public void validarValorBreadcrump (String valorValido)
	{
		String valorBreadcrump = this.breadcrump.getText();
		Assertions.assertTrue(valorBreadcrump.contains(valorValido),valorBreadcrump + " no contiene "+valorValido);
		if (this.breadcrump.getText().contains(valorValido))
		{
			System.out.println("Si Contiene "+ valorValido+" en el breadcrumb");
		}
		else
		{
			System.out.println("No Contiene "+ valorValido +" en el breadcrumb");
		}
		
	}
	
	public PaginaPrincipal(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

	}	
	
	
}
