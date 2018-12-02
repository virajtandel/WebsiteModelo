package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.Connect;
import models.LinhaPesquisa;

public class LinhaPesquisaDAO {

	private Connection con = null;
	
	public LinhaPesquisaDAO(){
		con = Connect.getConexao();
	}
	
	public void inserirLinhaPesquisa(LinhaPesquisa linha) throws SQLException {
		String comando = "INSERT INTO linhas_pesquisa (titulo, orientador, resumo, referencias) VALUES (?, ?, ?, ?);";
		PreparedStatement st = con.prepareStatement(comando);
		
		st.setString(1, linha.getTitulo());
		st.setString(2, linha.getOrientador());
		st.setString(3, linha.getResumo());
		st.setString(4, linha.getReferencias());
		
		st.execute();
		
		st.close();
		con.close();
	}
	
	public void alterarLinhaPesquisa(int id, LinhaPesquisa linha) throws SQLException {
		String comando = "UPDATE linhas_pesquisa SET titulo=?, orientador=?, resumo=?, referencias=? WHERE id=?;";
		PreparedStatement st = con.prepareStatement(comando);
		
		System.out.println(linha.getOrientador());
		
		st.setString(1, linha.getTitulo());
		st.setString(2, linha.getOrientador());
		st.setString(3, linha.getResumo());
		st.setString(4, linha.getReferencias());
		st.setInt(5, id);
		
		st.execute();
		
		st.close();
		con.close();
	}
	
	public void removerLinhaPesquisa(int id) throws SQLException {
		String comando = "DELETE FROM linhas_pesquisa WHERE id=?;";
		PreparedStatement st = con.prepareStatement(comando);
		
		st.setInt(1, id);
		
		st.execute();
		
		st.close();
		con.close();
	}
	
	public LinhaPesquisa recuperarLinhaPesquisa(int id) throws SQLException {
		String comando = "SELECT * FROM linhas_pesquisa WHERE id=?;";
		PreparedStatement st = con.prepareStatement(comando);
		
		LinhaPesquisa l = null;
		
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			l = new LinhaPesquisa();
			l.setId(rs.getInt("id"));
			l.setTitulo(rs.getString("titulo"));
			l.setOrientador(rs.getString("orientador"));
			l.setResumo(rs.getString("resumo"));
			String refs = rs.getString("referencias");
			if(refs!=null)
				l.setReferencias(refs.replace("$", "\n"));
		}
		
		st.close();
		con.close();
		return l;
	}
	
	public ArrayList<LinhaPesquisa> getLinhasPesquisa() throws SQLException {
		
		String comando = "SELECT * FROM linhas_pesquisa;";
		PreparedStatement st = con.prepareStatement(comando);
		ArrayList<LinhaPesquisa> linhas = new ArrayList<LinhaPesquisa>();
		LinhaPesquisa lin = null;
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			lin = new LinhaPesquisa();
			
			lin.setId(rs.getInt("id"));
			lin.setTitulo(rs.getString("titulo"));
			lin.setOrientador(rs.getString("orientador"));
			lin.setResumo(rs.getString("resumo"));
			String refs = rs.getString("referencias");
			if(refs != null)
				lin.setReferencias(refs.replace("$", "<br>"));
			linhas.add(lin);
		}
		
		st.close();
		con.close();
		
		return linhas;
	}
	
}
