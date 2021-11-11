package DAOInterfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import DAOImplements.DAODBConnectionImpl;

public interface DAOInterface<T> {
	Connection connection = DAODBConnectionImpl.getInstance().getConnection();
	
	ArrayList<T> find() throws SQLException;
	
	T findById(int id) throws SQLException;

	boolean create (T object) throws SQLException;
	 
	boolean delete (int id) throws SQLException;
	
	boolean update (int id, T object) throws SQLException;
	
}


