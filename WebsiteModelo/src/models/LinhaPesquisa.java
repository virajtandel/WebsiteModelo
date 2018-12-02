package models;

public class LinhaPesquisa {

	private int id;
	private String titulo;
	private String orientador;
	private String resumo;
	private String referencias;
	
	public LinhaPesquisa() {
		
	}
	
	public LinhaPesquisa(String titulo, String orientador, String resumo, String referencias) {
		this.titulo = titulo;
		this.orientador = orientador;
		this.resumo = resumo;
		this.referencias = referencias;
	}
	
	public String getReferencias() {
		return referencias;
	}
	public void setReferencias(String referencias) {
		this.referencias = referencias;
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
	public String getOrientador() {
		return orientador;
	}
	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	
}
