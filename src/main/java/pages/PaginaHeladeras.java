package pages;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;
import util.funciones;
//import org.testng.Assert;

public class PaginaHeladeras extends PaginaPrincipal 
{
	private String nameMarca;
	private int contValoresSi;
	private int valTotalElementosFiltro;
	
	@FindBy (className="ant-pagination-next")
	private WebElement btnNextPage;
	
	@FindBy (xpath="//li[@name='totalResult']")
	private WebElement totalResult;
	
	//@FindBy(xpath = "//h4[contains(.,'Heladeras (')]")
	private WebElement filtroLblHeladera;
		
	//@FindBy (xpath="//input[@name='checkboxBrand']")
	@FindBy (xpath="//li[@name='brandAggregation']")
	private List<WebElement> marcas;
	
	@FindBy (xpath="//article[@class='PieceLayout-orsj2a-0 PieceLayout__ResponsiveLayout-orsj2a-3 GKcLt']")
	private List<WebElement> grillaResultadoMarca;
	
	@FindBy (xpath="//li[@class=' ant-pagination-next']")
	private WebElement btnNexpPage;
	
	
	
	
	public WebElement getWebElementByName (String value, WebDriver driver)
	{
		WebElement wEByName = driver.findElement(By.name(value));
		return wEByName;
	}
	
	
	public void clickLinkHeladeras(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		filtroLblHeladera=driver.findElement(By.xpath("//h4[contains(.,'Heladeras (')]"));
		this.filtroLblHeladera.click();
		
	}
	
	public void clickPrimerMarca (WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Presiono el link del filtro de las heladeras
					
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0, 350)", "");
		
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		this.nameMarca = funciones.getMarca(this.marcas.get(0).getText());
		this.marcas.get(0).click();
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		char [] c = this.totalResult.getText().toCharArray();
		String n = "";
		for (int i = 0; i<c.length;i++)
		{
			if (Character.isDigit(c[i]))
			{
				n+=c[i];
			}
		}
		
		this.valTotalElementosFiltro = Integer.parseInt(n);
	}
	
	public void clickNexPage ()
	{
		this.btnNextPage.click();
		
	}
	
	public void validarFiltroMarcas (WebDriver driver)
	{
		
			grillaResultadoMarca = funciones.getWebElementListByXpath("//article[@class='PieceLayout-orsj2a-0 PieceLayout__ResponsiveLayout-orsj2a-3 GKcLt']",driver);
			for (WebElement valGrilla: this.grillaResultadoMarca)
			{	//Obtengo el valor del texto de cad una de las cards de la grilla
				if (valGrilla.getText().contains(this.nameMarca))
				{
					//True - entonces sumo uno a los valores positivos
					this.contValoresSi++;
					System.out.println("Nro de heladera de la grilla:"+contValoresSi);
					System.out.println(valGrilla.getText());
					
					
				}
			}
		try 
		{
			boolean finalLista = true;
			while (this.btnNextPage.isEnabled() && finalLista)
			
			
			{	this.btnNextPage.click();
				
				grillaResultadoMarca = funciones.getWebElementListByXpath("//article[@class='PieceLayout-orsj2a-0 PieceLayout__ResponsiveLayout-orsj2a-3 GKcLt']",driver);
				for (WebElement valGrilla: grillaResultadoMarca)
				{	//Obtengo el valor del texto de cada una de las cards de la grilla
					Assertions.assertTrue(valGrilla.getText().contains(this.nameMarca));
					if (valGrilla.getText().contains(nameMarca))
					{
						//True - entonces sumo uno a los valores positivos
						this.contValoresSi++;
						System.out.println("Nro de heladera de la grilla:"+contValoresSi);
						System.out.println(valGrilla.getText());
						
						
					}
				}
				try {
					driver.findElement(By.xpath("//li[@class='ant-pagination-disabled ant-pagination-next']"));
					finalLista = false;
					} 
				catch (NoSuchElementException e) {
					finalLista = true;
				}
				
			}
		
			System.out.println(contValoresSi);
		}
		catch (StaleElementReferenceException e)
		{
			System.out.println("Capturo error");
			System.out.println(contValoresSi);
			
		}		
	}
	
	public void validarCantidadElementosLista ()
	{
		Assertions.assertEquals(contValoresSi, this.valTotalElementosFiltro);
		if (this.valTotalElementosFiltro ==this.contValoresSi)
		{
			System.out.println("Hay Igual Cantidad");
		}
		else
		{
			System.out.println("Hay Incongruncias");
		}
		
	}
	
	public PaginaHeladeras(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

}
