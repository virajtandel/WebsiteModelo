package dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import db.Connect;
import models.Integrante;

public class IntegranteDAO {

private Connection con = null;
	
	public IntegranteDAO(){
		con = Connect.getConexao();
	}
	
	public void inserirIntegrante(Integrante integ, InputStream foto, String imgsPath, int a) throws SQLException {
		String comando = "INSERT INTO integrantes (nome, descricao, email, website, tipo) VALUES (?, ?, ?, ?, ?);";
		PreparedStatement st = con.prepareStatement(comando);
		
		st.setString(1, integ.getNome());
		st.setString(2, integ.getDescricao());
		st.setString(3, integ.getEmail());
		st.setString(4, integ.getWebsite());
		st.setInt(5, integ.getTipo());
		
		st.execute();
		
		comando = "SELECT * FROM integrantes WHERE nome='"+integ.getNome()+"';";
		st = con.prepareStatement(comando);
		
		ResultSet rs = st.executeQuery();
		
		String id = "x";
		
		if(rs.next()) {
			id = rs.getInt("id")+"";
		}
		
		try {
			File targetFile = new File(imgsPath+"u_"+id+".png");
			System.out.println(targetFile.getAbsolutePath());
			FileUtils.copyInputStreamToFile(foto, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		st.close();
		con.close();
	}
	public void inserirIntegrante(Integrante integ) throws SQLException {
		String comando = "INSERT INTO integrantes (nome, descricao, email, website, tipo) VALUES (?, ?, ?, ?, ?);";
		PreparedStatement st = con.prepareStatement(comando);
		
		st.setString(1, integ.getNome());
		st.setString(2, integ.getDescricao());
		st.setString(3, integ.getEmail());
		st.setString(4, integ.getWebsite());
		st.setInt(5, integ.getTipo());
		
		st.execute();
		
		st.close();
		con.close();
	}
	
	public void inserirIntegrante(Integrante integ, InputStream foto, String path) throws SQLException {
		String comando = "INSERT INTO integrantes (nome, descricao, email, website, tipo) VALUES (?, ?, ?, ?, ?);";
		PreparedStatement st = con.prepareStatement(comando);
		
		st.setString(1, integ.getNome());
		st.setString(2, integ.getDescricao());
		st.setString(3, integ.getEmail());
		st.setString(4, integ.getWebsite());
		st.setInt(5, integ.getTipo());
		
		st.execute();
		
		comando = "SELECT * FROM integrantes WHERE nome=? AND descricao=? AND tipo=?;";
		st = con.prepareStatement(comando);
		st.setString(1, integ.getNome());
		st.setString(2, integ.getDescricao());
		st.setInt(3, integ.getTipo());
		
		ResultSet rs = st.executeQuery();
		int id = 0;
		
		if(rs.next()) {
			id = rs.getInt("id");
		}
		
		try {
			File targetFile = new File(path+"img/u_"+id+".png");
			System.out.println(targetFile.getAbsolutePath());
			FileUtils.copyInputStreamToFile(foto, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		st.close();
		con.close();
	}
	
	public void alterarIntegrante(int id, Integrante integ, InputStream foto, String path) throws SQLException {
		String comando = "UPDATE integrantes SET nome=?, descricao=?, email=?, website=?, tipo=? WHERE id=?;";
		PreparedStatement st = con.prepareStatement(comando);
		
		st.setString(1, integ.getNome());
		st.setString(2, integ.getDescricao());
		st.setString(3, integ.getEmail());
		st.setString(4, integ.getWebsite());
		st.setInt(5, integ.getTipo());
		st.setInt(6, id);
		
		st.execute();

		comando = "SELECT * FROM integrantes WHERE nome=? AND descricao=? AND tipo=?;";
		st = con.prepareStatement(comando);
		st.setString(1, integ.getNome());
		st.setString(2, integ.getDescricao());
		st.setInt(3, integ.getTipo());
		
		ResultSet rs = st.executeQuery();
		
		int idf = 0;
		
		if(rs.next()) {
			idf = rs.getInt("id");
		}
		
		try {
			File targetFile = new File(path+"u_"+idf+".png");
			System.out.println(targetFile.getAbsolutePath());
			FileUtils.copyInputStreamToFile(foto, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		st.close();
		con.close();
	}
	
	public void alterarIntegrante(int id, Integrante integ) throws SQLException {
		String comando = "UPDATE integrantes SET nome=?, descricao=?, email=?, website=?, tipo=? WHERE id=?;";
		PreparedStatement st = con.prepareStatement(comando);
		
		st.setString(1, integ.getNome());
		st.setString(2, integ.getDescricao());
		st.setString(3, integ.getEmail());
		st.setString(4, integ.getWebsite());
		st.setInt(5, integ.getTipo());
		st.setInt(6, id);
		
		st.execute();
		
		st.close();
		con.close();
	}
	
	public void removerIntegrante(int id) throws SQLException {  //REMOVER FOTO
		String comando = "DELETE FROM integrantes WHERE id=?;";
		PreparedStatement st = con.prepareStatement(comando);
		
		st.setInt(1, id);
		
		st.execute();
		
		st.close();
		con.close();
	}
	
	public Integrante recuperarIntegrante(int id) throws SQLException {
		Integrante i = null;
		String comando = "SELECT * FROM integrantes WHERE id=?;";
		PreparedStatement st = con.prepareStatement(comando);
		
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();

		if(rs.next()) {
			i = new Integrante();
			i.setId(Integer.parseInt(rs.getString("id")));
			i.setNome(rs.getString("nome"));
			i.setDescricao(rs.getString("descricao"));
			i.setEmail(rs.getString("email"));
			i.setWebsite(rs.getString("website"));
			i.setTipo(Integer.parseInt(rs.getString("tipo")));
		}
		System.out.println(i.getNome()+"-z");
		st.close();
		con.close();
		
		return i;
	}
	
	public void removerIntegrante(int id, Integrante integ, InputStream foto, String imgsPath) throws SQLException { //DELETAR FOTO
		String comando = "DELETE FROM integrantes WHERE id=?;";
		PreparedStatement st = con.prepareStatement(comando);
		
		st.setInt(1, id);
		
		st.execute();
		
		st.close();
		con.close();
	}
	
	public ArrayList<Integrante> getIntegrantes(int tipo) throws SQLException {
		
		String comando = "SELECT * FROM integrantes WHERE tipo="+tipo+";";
		PreparedStatement st = con.prepareStatement(comando);
		ArrayList<Integrante> integs = new ArrayList<Integrante>();
		Integrante integ = null;
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			integ = new Integrante();
			
			integ.setId(rs.getInt("id"));
			integ.setNome(rs.getString("nome"));
			integ.setDescricao(rs.getString("descricao"));
			integ.setEmail(rs.getString("email"));
			integ.setWebsite(rs.getString("website"));
			
			integs.add(integ);
		}
		
		st.close();
		
		return integs;
	}
	
}
