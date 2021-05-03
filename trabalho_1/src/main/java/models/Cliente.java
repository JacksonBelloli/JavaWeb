package models;

public class Cliente {
	private String nome;
	private String data_nasc;
	private String pais;
	private String estado;
	private String cidade;
	private String endereco;
	private String email;
	
	public Cliente(String nome, String data_nasc, String pais, String estado, String cidade, String endereco,
			String email) {
		super();
		this.nome = nome;
		this.data_nasc = data_nasc;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.endereco = endereco;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
