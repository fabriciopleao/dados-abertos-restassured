package dadosabertos.api.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dadosabertos.api.objects.ListarBlocosModel;
import dadosabertos.api.objects.ListarBlocosObjects;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ListarBlocosTest {

	private ListarBlocosModel bloco;
	Response response;

	@BeforeEach
	public void setUp() {
		RestAssured.baseURI = "https://dadosabertos.camara.leg.br/api/v2";
		response = RestAssured.get("/blocos");
	}

	@Test
	public void testConsultarBlocoExistente() {
		
		// Informe o bloco desejado: 0, 1, 2 ...
		bloco = ListarBlocosObjects.consultarBloco(response, 0);
		
		assertEquals(200, response.getStatusCode());
		assertNotNull(bloco);
		assertEquals("584", bloco.getId());
		assertEquals("Federação Brasil da Esperança - Fe Brasil", bloco.getNome());
		assertEquals("57", bloco.getIdLegislatura());

	}

	@Test
	public void testConsultarBlocoInexistente() {
		bloco = ListarBlocosObjects.consultarBloco(response, 1000);
		assertNull(bloco);

	}

}
