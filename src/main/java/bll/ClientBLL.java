package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.EmailValidator;
import bll.validators.ClientAgeValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

/**
 * Class that implements the business logic for model class Client and the methods for accessing the DB through an instance of ClientDAO class
 *
 * @author Tirlea Maria Cristina
 * @since Apr 20, 2021
 */
public class ClientBLL {

	private List<Validator<Client>> validators;
	private ClientDAO clientDAO;


	/**
	 *  Construct that instantiates a ClientDAO object for access to DB
	 */
	public ClientBLL() {
		validators = new ArrayList<Validator<Client>>();
		validators.add(new EmailValidator());
		validators.add(new ClientAgeValidator());
		this.clientDAO = new ClientDAO();
	}

	/**
	 * Method that searches in the database's Client table a client with a specific id
	 *
	 * @param id id of client to search
	 * @return a Client object if the search succeeded else null
	 */
	public Client findClientById(int id) {
		Client st = clientDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The Client with id =" + id + " was not found!");
		}
		return st;
	}

	/**
	 * Method that searches in the database's Client table a client with a specific cnp
	 *
	 * @param cnp cnp of the client to be searched for
	 * @return a Client object if the search succeeded else null
	 */
	public Client findClientByCnp(String cnp) {
		Client st = clientDAO.findByField(cnp);
		if (st == null) {
			throw new NoSuchElementException("The Client with id =" + cnp + " was not found!");
		}
		return st;
	}

	/**
	 * Method for inserting a new client in the database
	 *
	 * @param client client to be inserted
	 * @return number of rows affected
	 */
	public int insertClient(Client client) {
		for (Validator<Client> v : validators) {
			v.validate(client);
		}
		return clientDAO.insert(client);
	}

	/**
	 * Method for updating an existing client from the DB
	 *
	 * @param cnpToUpdate cnp of the client to be updated
	 * @param client client to be updated
	 * @return number of rows affected
	 */
	public int updateClient(String cnpToUpdate, Client client) {
		for (Validator<Client> v : validators) {
			v.validate(client);
		}
		return clientDAO.update(client,cnpToUpdate);
	}

	/**
	 * Method for deleting an exiting client from DB
	 *
	 * @param cnpToDelete cnp of client to be deleted
	 * @return number of rows affected
	 */
	public int deleteClient(String cnpToDelete) {
		return clientDAO.delete(cnpToDelete);
	}

	/**
	 * Method for fetching all existing clients in the database
	 *
	 * @return an ArrayList containing all clients found in the database
	 */
	public ArrayList<Client> existingClients(){
		return (ArrayList<Client>) clientDAO.findAll();
	}
}
