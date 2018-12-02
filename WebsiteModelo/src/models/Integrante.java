package models;

public class Integrante {
	
	private int id;
	private String nome;
	private String descricao;
	private String email;
	private String website;
	private int tipo;
	
	public Integrante() {
		
	}
	
	public Integrante(String nome, String descricao, String email, String website, int tipo) {
		this.nome = nome;
		this.descricao = descricao;
		this.email = email;
		this.website = website;
		this.tipo = tipo;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
