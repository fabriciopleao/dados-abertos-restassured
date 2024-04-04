package dadosabertos.api.objects;

public class ListarBlocosModel {

	private String id;
	private String nome;
	private String idLegislatura;

	public ListarBlocosModel(String id, String nome, String idLegislatura) {
		this.id = id;
		this.nome = nome;
		this.idLegislatura = idLegislatura;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getIdLegislatura() {
		return idLegislatura;
	}

}
