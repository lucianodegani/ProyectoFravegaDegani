package test;

import java.util.ArrayList;
import org.junit.Test;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class testBebida
{	
	static String urlAutocomplete = "https://api.openbrewerydb.org/breweries/autocomplete?query=";
	static String urlBebidaId = "https://api.openbrewerydb.org/breweries/";
	
	@Test
	public void testResponsecode()
	{	
		/* ------------------------------------------------------------------------------------------------
		 * 1- Obtener una lista de cervecerías que contengan el texto
		 *  "lagunitas" en su nombre.
		 *  Para ello, se debe ejecutar el siguiente servicio, 
		 *  indicando el texto a buscar en el queryParam "query".
		 *  GET - https://api.openbrewerydb.org/breweries/autocomplete
		 *  ------------------------------------------------------------------------------------------------
		 */
		
		Response resp= getResponse(urlAutocomplete, "lagunitas");
		int code=resp.getStatusCode();
		//resp.getBody().print();
		System.out.println(" Status code is "+code);
		System.out.println(" Response "+resp.getBody().print());
		Assert.assertEquals(code, 200);
		Assert.assertTrue(resp.getBody().print().contains("Lagunitas"));
		JsonPath jsonPath  = resp.jsonPath();
		System.out.println("id: " +jsonPath.get("id").toString());
		System.out.println("names: " +jsonPath.get("name").toString());
				
		ArrayList listaId = jsonPath.get("id");
		ArrayList listaName =  jsonPath.get("name");
		
		/*------------------------------------------------------------------------------------------------------------------------
		 * 2- De la lista de resultados del punto 1, tomar aquellos 
		 * que contengan en la key "name", el valor "Lagunitas Brewing Co".
		 *------------------------------------------------------------------------------------------------------------------------
		 */

		//Obtengo la lista de id que contienen la palabra requerida
		for(int i = 0; i<listaId.size(); i++)
		{	
			System.out.println(listaName.get(i));
			System.out.println(listaId.get(i));
			
			String a= "Lagunitas Brewing Co"; 
			
			if (listaName.get(i).equals(a))
			{	
				System.out.println("id Si contiene - se queda" +listaId.get(i));
			}
			else
			{	
				System.out.println("id no contiene - Remove: " +listaId.get(i));
				listaId.remove(i);
			}
			
		}
		
		/*-------------------------------------------------------------------------------------------------------------------------------------------
		//3- A través del siguiente servicio, obtener el detalle de cada cervecería
		 *  de la lista del punto 2 y tomar solo el que contenga
		 *  "state" = "California". GET - https://api.openbrewerydb.org/breweries/{id}
		 * -------------------------------------------------------------------------------------------------------------------------------------------	
		*/
		for (int i=0; i<listaId.size(); i++)
		{
			resp= getResponse(urlBebidaId, listaId.get(i).toString());
			code=resp.getStatusCode();
			
			Assert.assertEquals(code, 200);
			
			jsonPath  = resp.jsonPath();
			
			if (jsonPath.get("state").equals("California"))
			{
				System.out.println(" Status code is "+code);
				System.out.println(" Response "+resp.getBody().print());
				
				Assert.assertTrue(jsonPath.get("state").equals("California"));
				
				//"id" = 761
				Assert.assertTrue(jsonPath.get("id").equals(761));
				// "name" = "Lagunitas Brewing Co"
				Assert.assertTrue(jsonPath.get("name").equals("Lagunitas Brewing Co"));
				// "street" = "1280 N McDowell Blvd"
				Assert.assertTrue(jsonPath.get("street").equals("1280 N McDowell Blvd"));
				// "phone" = "7077694495		
				Assert.assertTrue(jsonPath.get("phone").equals("7077694495"));
				
			}
			else
			{
				System.out.println(" id no contiene  street california "+ listaId.get(i));
				System.out.println(" street: "+ jsonPath.get("street"));		
			}
		}
	}
	
	public Response getResponse (String urlServicio, String query)
	{		
		System.out.println("Get: "+urlServicio+query);
		return RestAssured.get(urlServicio+query);
			
	}
	
}