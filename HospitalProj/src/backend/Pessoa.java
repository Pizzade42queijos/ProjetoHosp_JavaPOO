package backend;

public class Pessoa {
	private String Nome;
	private int Id;
	
	public Pessoa(String nome, int id) {
		setNome(nome);
		setId(id);
	}
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

}
