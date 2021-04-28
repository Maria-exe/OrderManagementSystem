package bll.validators;

import bll.ProductBLL;
import model.Client;
import model.Orders;

import javax.swing.*;

/**
 * Class used for checking if there is enough stock of a product for an order to placed.
 *
 * @author Tirlea Maria Cristina
 * @since Apr 20, 2021
 * @see Orders
 */

public class StockValidator implements Validator<Orders> {
    ProductBLL productBll = new ProductBLL();

    /**
     * Checks if the stockCount field of a product is grater than the amount requested by an order and throws an exception if the condition is not met.
     *
     * @param order order to be validated
     */
    @Override
    public void validate(Orders order) {
        if (order.getAmount() > productBll.findProductById(order.getProduct_ID()).getStockCount() ) {
            JOptionPane.showMessageDialog(null, "Product currently under stock!",
                    "ERROR: out of stock", JOptionPane.INFORMATION_MESSAGE);
            throw new IllegalArgumentException("Product currently under stock!");
        }
    }
}
