package DAOImplements;

import java.sql.*;
import java.util.ArrayList;

import Clases.Pais;
import DAOInterfaces.*;

public class DAOPaisImpl implements DAOInterface<Pais> {

	public ArrayList<Pais> find() throws SQLException {
		ArrayList<Pais> paises = new ArrayList<Pais>();
		Statement stm = connection.createStatement();	
		ResultSet rs = stm.executeQuery("SELECT * FROM pais");
		while(rs.next()) {
			Pais pais = new Pais(rs.getInt("id"), rs.getString("nombre"));
			paises.add(pais);
		}
		DAODBConnectionImpl.closeConnection();
		return paises;
	}
	
	public Pais findById(int id) throws SQLException {
		Statement stm = connection.createStatement();
		Pais pais = null;
		ResultSet rs = stm.executeQuery("SELECT * FROM pais WHERE id = " + id);
		if(rs.next()) {
			pais = new Pais(rs.getInt("id"), rs.getString("nombre"));			
		} 
		DAODBConnectionImpl.closeConnection();
		return pais;
	}
	
	public boolean create (Pais pais) throws SQLException {
		Statement stm = connection.createStatement();
		String query = "INSERT INTO pais (nombre) VALUES ('" + pais.getNombre() + "')";
		int result = stm.executeUpdate(query);
		DAODBConnectionImpl.closeConnection();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}
	 
	
	public boolean delete (int id) throws SQLException {
		Statement stm = connection.createStatement();
		String query = "DELETE FROM pais WHERE id = " + id;
		int result = stm.executeUpdate(query);
		DAODBConnectionImpl.closeConnection();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean update (int id, Pais pais) throws SQLException {
	    String query = "UPDATE pais SET nombre = ? WHERE id = ?";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
	    preparedStmt.setString(1, pais.getNombre());
	    preparedStmt.setInt(2, id);

		int result = preparedStmt.executeUpdate();
		
		DAODBConnectionImpl.closeConnection();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	 }
	
	
	
}
