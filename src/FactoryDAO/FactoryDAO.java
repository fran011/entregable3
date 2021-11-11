package FactoryDAO;

import DAOImplements.*;
import Clases.*;
public class FactoryDAO {

	
	public DAODeportistaImpl getDeportista() {
		return new DAODeportistaImpl();
	}
	
	public DAODBConnectionImpl getConnection() {
		return null;
	}
	
	public DAOPaisImpl getPais() {
		return new DAOPaisImpl();
	}
	
	
}
