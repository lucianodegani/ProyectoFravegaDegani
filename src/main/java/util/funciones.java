package util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class funciones 
{

	public static WebElement getWebElementByClass (String nameClase, WebDriver driver)
	{
		WebElement wElmt = driver.findElement(By.className(nameClase));
		
		return wElmt;
	}
	
	public static WebElement getWebElementById (String id, WebDriver driver)
	{
		WebElement wElmt = driver.findElement(By.id(id));
		
		return wElmt;
	}
	
	public static WebElement getWebElementByCss (String css, WebDriver driver)
	{
		WebElement wElmt = driver.findElement(By.cssSelector(css));
		
		return wElmt;
	}
	
	public static WebElement getWebElementByXpath (String xPath, WebDriver driver)
	{
		WebElement wElmt = driver.findElement(By.xpath(xPath));
		
		return wElmt;
	}
	
	public static List<WebElement> getWebElementListByXpath (String xPath, WebDriver driver)
	{
		List<WebElement> wElmt = driver.findElements(By.xpath(xPath));
		
		return wElmt;
	}
	
	/*
	 * Funcion que trae solo caracteres no numericos de un string /*
	 */
	public static String getMarca (String marcaConNumero)
	{	char [] c = marcaConNumero.toCharArray();
		String n = "";
		for (int i = 0; i<c.length;i++)
		{	//System.out.println(c);
			if (!Character.isDigit(c[i]))
			{
				n+=c[i];
			}
		}
		
		String[] arrayValor = marcaConNumero.split(" ");
		//return n;
		return arrayValor[0];
	}
		
	public static int getNroMarca (String marcaConNumero)
	{	char [] c = marcaConNumero.toCharArray();
		String n = "";
		for (int i = 0; i<c.length;i++)
		{
			if (Character.isDigit(c[i]))
			{
				n+=c[i];
			}
		}
		return Integer.parseInt(n);
		
	}
}
