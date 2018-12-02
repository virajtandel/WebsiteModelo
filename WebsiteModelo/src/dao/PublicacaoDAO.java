package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.Connect;
import models.Publicacao;

public class PublicacaoDAO {

private Connection con = null;
	
	public PublicacaoDAO(){
		con = Connect.getConexao();
	}
	
	public void inserirPublicacao(Publicacao pub) throws SQLException {
		String comando = "INSERT INTO publicacoes (titulo, autores, locPublicacao, resumo, link) VALUES (?, ?, ?, ?, ?);";
		PreparedStatement st = con.prepareStatement(comando);
		
		st.setString(1, pub.getTitulo());
		st.setString(2, pub.getAutores());
		st.setString(3, pub.getLocPublicacao());
		st.setString(4, pub.getResumo());
		st.setString(5, pub.getLink());
		
		st.execute();
		con.close();
	}
	
	public void alterarPublicacao(int id, Publicacao pub) throws SQLException {
		String comando = "UPDATE publicacoes SET titulo=?, autores=?, locPublicacao=?, resumo=?, link=? WHERE id=?;";
		PreparedStatement st = con.prepareStatement(comando);
		
		st.setString(1, pub.getTitulo());
		st.setString(2, pub.getAutores());
		st.setString(3, pub.getLocPublicacao());
		st.setString(4, pub.getResumo());
		st.setString(5, pub.getLink());
		st.setInt(6, id);
		
		st.execute();
		con.close();
	}
	
	public void removerPublicacao(int id) throws SQLException {
		String comando = "DELETE FROM publicacoes WHERE id=?;";
		PreparedStatement st = con.prepareStatement(comando);
		
		st.setInt(1, id);
		
		st.execute();
		con.close();
	}
	
	public Publicacao recuperarPublicacao(int id) throws SQLException {
		String comando = "SELECT * FROM publicacoes WHERE id=?;";
		PreparedStatement st = con.prepareStatement(comando);
		Publicacao p = null;
		
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			p = new Publicacao();
			p.setId(rs.getInt("id"));
			p.setTitulo(rs.getString("titulo"));
			p.setAutores(rs.getString("autores"));
			p.setLocPublicacao(rs.getString("locPublicacao"));
			p.setResumo(rs.getString("resumo"));
			p.setLink(rs.getString("link"));
		}
		
		st.close();
		con.close();
		return p;
	}
	
	public ArrayList<Publicacao> getPublicacoes() throws SQLException {
		
		String comando = "SELECT * FROM publicacoes;";
		PreparedStatement st = con.prepareStatement(comando);
		ArrayList<Publicacao> publics = new ArrayList<Publicacao>();
		Publicacao pub = null;
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			pub = new Publicacao();
			
			pub.setId(Integer.parseInt(rs.getString("id")));
			pub.setTitulo(rs.getString("titulo"));
			pub.setAutores(rs.getString("autores"));
			pub.setLocPublicacao(rs.getString("locPublicacao"));
			pub.setResumo(rs.getString("resumo"));
			pub.setLink(rs.getString("link"));
			
			publics.add(pub);
		}
		
		st.close();
		con.close();
		
		return publics;
	}
	
}
