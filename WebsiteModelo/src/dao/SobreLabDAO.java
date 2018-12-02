package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.Connect;
import models.SobreLab;

public class SobreLabDAO {

	private Connection con = null;
	
	public SobreLabDAO(){
		con = Connect.getConexao();
	}
	
	public SobreLab getSobreLab() throws SQLException {
		
		String comando = "SELECT * FROM sobre_lab;";
		PreparedStatement st = con.prepareStatement(comando);
		SobreLab sobre = new SobreLab();
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			sobre.setNome(rs.getString("nome"));
			sobre.setDescricao(rs.getString("descricao"));
		}
		
		st.close();
		con.close();
		
		return sobre;
	}
	
	public SobreLab alterarSobreLab(String nome, String descricao) throws SQLException {
		
		String comando = "UPDATE sobre_lab SET nome=?, descricao=?;";
		PreparedStatement st = con.prepareStatement(comando);
		SobreLab sobre = new SobreLab();
		
		st.setString(1, nome);
		st.setString(2, descricao);
		
		st.execute();
		
		st.close();
		con.close();
		
		return sobre;
	}
	
}
