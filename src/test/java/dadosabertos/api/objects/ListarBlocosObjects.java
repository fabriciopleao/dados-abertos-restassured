package dadosabertos.api.objects;

import io.restassured.response.Response;

public class ListarBlocosObjects {

	public static ListarBlocosModel consultarBloco(Response response, int bloco) {
		String id = response.jsonPath().getString("dados[" + bloco + "].id");
		String nome = response.jsonPath().getString("dados[" + bloco + "].nome");
		String idLegislatura = response.jsonPath().getString("dados[" + bloco + "].idLegislatura");

		System.out.println("**TEST**\n");
		System.out.println("Status Code: " + response.getStatusCode() + "\n");
		System.out.println("ID: " + id);
		System.out.println("Nome: " + nome);
		System.out.println("ID Legislatura: " + idLegislatura);

		if (id == null || nome == null || idLegislatura == null) {
		System.out.println("\nBloco partidário não encontrado.\n");
			return null;
		}

		return new ListarBlocosModel(id, nome, idLegislatura);
	}

}
