package models;

public class Publicacao {

	private int id;
	private String titulo;
	private String autores;
	private String locPublicacao;
	private String resumo;
	private String link;
	
	public Publicacao() {
		
	}
	
	public Publicacao(String titulo, String autores, String locPublicacao, String resumo, String link) {
		this.titulo = titulo;
		this.autores = autores;
		this.locPublicacao = locPublicacao;
		this.resumo = resumo;
		this.link = link;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public String getLocPublicacao() {
		return locPublicacao;
	}
	public void setLocPublicacao(String loc_publicacao) {
		this.locPublicacao = loc_publicacao;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
