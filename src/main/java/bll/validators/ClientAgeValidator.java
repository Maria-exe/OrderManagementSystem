package bll.validators;

import model.Client;

/**
 * Class used for checking the age limit of each client inserted in the database system.
 *
 * @author Tirlea Maria Cristina
 * @since Apr 20, 2021
 * @see Client
 */
public class ClientAgeValidator implements Validator<Client> {
	private static final int MIN_AGE = 7;
	private static final int MAX_AGE = 90;

	/**
	 * Checks if the age field of a client has an int value between 7 and 90 and throws an exception if the condition is not met.
	 *
	 * @param client client to validate
	 * @throws IllegalArgumentException exception thrown if validation fails
	 */
	public void validate(Client client) {

		if (client.getAge() < MIN_AGE || client.getAge() > MAX_AGE) {
			throw new IllegalArgumentException("The Client Age limit is not respected!");
		}

	}

}
