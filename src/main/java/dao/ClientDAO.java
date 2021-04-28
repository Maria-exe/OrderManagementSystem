package dao;


import java.util.logging.Logger;
import model.Client;

/**
 * Class that inherits the methods from abstract class AbstractDAO.java and provides their usage for Client objects
 *
 * @author Tirlea Maria Cristina
 * @since Apr 20, 2021
 */
public class ClientDAO extends AbstractDAO<Client>{

	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	private final static String selectStatementString = "SELECT * FROM client";


}
