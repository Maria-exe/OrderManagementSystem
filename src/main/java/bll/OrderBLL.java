package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.StockValidator;
import bll.validators.Validator;
import dao.OrderDAO;
import model.Orders;

/**
 * Class implementing the business logic for model class Order and methods for accessing the DB through an instance of OrderDAO
 */
public class OrderBLL {

    private List<Validator<Orders>> validators;
    private OrderDAO orderDAO;

    /**
     * Constructor that instantiates a OrderDAO object used to access the specific methods for accessing the database data
     */
    public OrderBLL() {
        validators = new ArrayList<Validator<Orders>>();
        validators.add(new StockValidator());
        this.orderDAO = new OrderDAO();
    }

    /**
     * Method used to search the DB for a Order with a certain id
     *
     * @param id id of order to be searched for
     * @return an Orders object if the order is found else null
     */
    public Orders findOrderById(int id) {
        Orders st = orderDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The Order with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     * Method for inserting a new order in the database
     *
     * @param order order to be inserted
     * @return number of rows affected
     */
    public int insertOrder(Orders order) {
        System.out.println(order.toString());
        for (Validator<Orders> v : validators) {
            v.validate(order);
        }
        return orderDAO.insert(order);
    }

    /**
     * Method for deleting an existing order from the database
     *
     * @param order order to be deleted
     * @return number of rows affected
     */
    public int deleteOrder(Orders order) {
        return OrderDAO.delete(order);
    }

    public Orders findOrder(String productName, String clientCnp, int amount) {
        Orders st = OrderDAO.find(productName,clientCnp,amount);
        if (st == null) {
            throw new NoSuchElementException("The Order you searched for was not found!");
        }
        return st;
    }

    /**
     * Method for fetching all existing orders from the DB
     *
     * @return an ArrayList with all the orders found
     */
    public ArrayList<Orders> existingOrders(){
        return OrderDAO.selectAllOrders();
    }
}
