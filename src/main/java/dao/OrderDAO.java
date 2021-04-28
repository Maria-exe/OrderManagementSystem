package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import bll.ClientBLL;
import bll.ProductBLL;
import connection.ConnectionFactory;
import model.Client;
import model.Orders;
import model.Product;

/**
 * Class that inherits the methods from abstract class AbstractDAO.java and provides their usage for Orders objects
 *
 * @author Tirlea Maria Cristina
 * @since Apr 20, 2021
 */
public class OrderDAO extends AbstractDAO<Orders>{

    protected static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());
    private final static String findStatementString = "SELECT * FROM orders where product_id = ? and client_id = ?" +
            " and amount = ?";
    private final static String selectStatementString = "SELECT * FROM orders ";
    private final static String deleteStatementString = "DELETE * FROM orders where product_id = ? and client_id = ?" +
            " and total_price = ?  and amount = ?";

    /**
     * static method used to find an order in the database table Orders based on multiple fields
     *
     * @param productName name of product that the order was placed for
     * @param clientCnp name of client that made the order
     * @param amount number of products requested
     * @return the found Order object if the search succeeded else null
     */
    public static Orders find(String productName, String clientCnp, int amount) {
        Orders toReturn = null;
        ClientBLL cb = new ClientBLL();
        Client c = cb.findClientByCnp(clientCnp);
        ProductBLL pb = new ProductBLL();
        Product p = pb.findProductByName(productName);
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        if(p != null && c != null) {
            try {
                findStatement = dbConnection.prepareStatement(findStatementString);
                findStatement.setInt(1, p.getId());
                findStatement.setInt(2, c.getId());
                findStatement.setInt(3, amount);

                rs = findStatement.executeQuery();
                rs.next();

                int productID = rs.getInt("product_id");
                int clientID = rs.getInt("client_id");
                double totalPrice = rs.getDouble("total_price");
                int quantity = rs.getInt("amount");
                toReturn = new Orders(productID, clientID, totalPrice, quantity);
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "OrderDAO:find " + e.getMessage());
            } finally {
                ConnectionFactory.close(rs);
                ConnectionFactory.close(findStatement);
                ConnectionFactory.close(dbConnection);
            }
        }
        return toReturn;
    }

    /**
     * Method for fetching all existing orders from the DB
     *
     * @return an ArrayList with all the orders found
     */
    public static ArrayList<Orders> selectAllOrders() {
        ArrayList<Orders> toReturn = new ArrayList<Orders>();

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement selectStatement = null;
        ResultSet rs = null;
        try {
            selectStatement = dbConnection.prepareStatement(selectStatementString);
            rs = selectStatement.executeQuery();
            while(rs.next()) {

                int order_Id = rs.getInt("id");
                int productID = rs.getInt("product_id");
                int clientID = rs.getInt("client_id");
                double totalPrice = rs.getInt("total_price");
                int quantity = rs.getInt("amount");
                toReturn.add(new Orders(order_Id,productID,clientID,totalPrice,quantity));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"OrderDAO:selectAllOrders " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(selectStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * Method for deleting an existing order from the database
     *
     * @param order order to be deleted
     * @return number of rows affected
     */
    public static int delete(Orders order) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deletedStatement = null;

        ResultSet rs = null;
        int deletedId = -1;
        try {
            deletedStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deletedStatement.setInt(1, order.getProduct_ID());
            deletedStatement.setInt(2, order.getClient_ID());
            deletedStatement.setDouble(3, order.getTotal_Price());
            deletedStatement.setInt(4, order.getAmount());

            deletedStatement.executeUpdate();
            rs = deletedStatement.getGeneratedKeys();
            if (rs.next()) {
                deletedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"OrderDAO:findByName " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(deletedStatement);
            ConnectionFactory.close(dbConnection);
        }
        return deletedId;
    }
}
