package start;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import bll.ClientBLL;
import model.Client;
import presentation.Controller;
import presentation.View;

/**
 * Main class
 *
 * @author Tirlea Maria Cristina
 * @since Apr 20, 2021
 */
public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) throws SQLException {
		View view = new View();
		Controller controller = new Controller(view);
		view.setVisible(true);
		Client client = new Client("5", "Max", "Brown",26,"0755555444","dummy@address.co");

		ClientBLL ClientBll = new ClientBLL();
		int id = ClientBll.insertClient(client);
		if (id > 0) {
			ClientBll.findClientById(id);
		}
		
		
		// Generate error
		try {
			ClientBll.findClientById(1);
		} catch (Exception ex) {
			LOGGER.log(Level.INFO, ex.getMessage());
		}
	}
	
	

}
