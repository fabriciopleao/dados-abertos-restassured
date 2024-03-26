package dadosabertos.api.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ListarBlocosTest {

	private String id;
	private String nome;
	private String idLegislatura;

	Response response;
	
	@BeforeEach
	public void setUp() {
		RestAssured.baseURI = "https://dadosabertos.camara.leg.br/api/v2";
		response = RestAssured.get("/blocos");
		
		// Selecione o bloco nos conchetes, Ex: [0], [1], [2]...
		id = response.jsonPath().getString("dados[0].id");
		nome = response.jsonPath().getString("dados[0].nome");
		idLegislatura = response.jsonPath().getString("dados[0].idLegislatura");
	}


	@Test
	public void testConsultarBloco() {
		assertEquals(200, response.getStatusCode());
		assertEquals("584", id);
		assertEquals("Federação Brasil da Esperança - Fe Brasil", id);
		assertEquals("57", id);
		
		System.out.println("Status Code: " + response.getStatusCode() + "\n");
		System.out.println("ID: " + id);
		System.out.println("Nome: " + nome);
		System.out.println("ID Legislatura: " + idLegislatura);
	}
}
