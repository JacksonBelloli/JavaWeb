package models;

public class Jogo {
	private int id;
	private String nome;
	private String genero;
	private String descricao;
	private String preco;
	
	
	
	public Jogo() {
		
	}
	public Jogo(int id, String nome, String genero, String descricao, String preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	
}
