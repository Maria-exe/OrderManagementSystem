package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Product;


/**
 * Class that inherits the methods from abstract class AbstractDAO.java and implements a few specific ones
 */
public class ProductDAO extends AbstractDAO<Product>{
    public ProductDAO() {
        super();
    }

    protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
    private final static String selectStatementString = "SELECT * FROM product";
    private final static String updateStockStatementString = "UPDATE product SET stockCount = ? " +
            "WHERE product_name = ?";


    /**
     * Method used for updating the stock of a product after an order has been placed
     *
     * @param prod_name name od product to be updated
     * @param stock new sock value
     * @return number of rows affected
     */
    public static int updateStock(String prod_name,int stock) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement updateStockStatement = null;
        int updatedId = -1;
        try {
            updateStockStatement = dbConnection.prepareStatement(updateStockStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStockStatement.setInt(1, stock);
            updateStockStatement.setString(2, prod_name);
            updateStockStatement.executeUpdate();

            ResultSet rs = updateStockStatement.getGeneratedKeys();
            if (rs.next()) {
                updatedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:update stock " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStockStatement);
            ConnectionFactory.close(dbConnection);
        }
        return updatedId;
    }

}
