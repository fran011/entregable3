package FactoryDAO;

import DAOImplements.*;
import Clases.*;
public class FactoryDAO {

	
	public DAODeportistaImpl getDeportista() {
		return new DAODeportistaImpl();
	}
	
}
