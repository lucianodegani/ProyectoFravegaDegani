package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.PaginaHeladeras;

public class demo extends testBase
{	private PaginaHeladeras pageRefrigerator;
		
	@Test
	public void test() 
	{
		goToURL(driver, "https://www.fravega.com/");
		iniciarPaginas(driver);
		//busco en la pagina principal la palabra Heladera
    	pageRefrigerator.getBusquedaPrincipalPage("heladera");
    	
    	//Click Filtro Heladera
    	pageRefrigerator.clickLinkHeladeras(driver);
    	    	
    	//Click en la Primera Marca
    	pageRefrigerator.clickPrimerMarca(driver);
    	
    	pageRefrigerator.validarFiltroMarcas(driver);
    	
    	pageRefrigerator.validarCantidadElementosLista();
    	    	
    	pageRefrigerator.validarValorBreadcrump("Heladeras");
	}
	
	

	    public void iniciarPaginas(WebDriver driver)
	    {
	    	this.pageRefrigerator = new PaginaHeladeras(driver);
	    	
	    }
	   

}
