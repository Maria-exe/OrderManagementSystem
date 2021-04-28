package bll;


import bll.validators.Validator;
import dao.ProductDAO;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class that implements the business logic for model class Product and the methods for accessing the DB through an instance of ProductDAO class
 *
 *  @author Tirlea Maria Cristina
 *  @since Apr 20, 2021
 */
public class ProductBLL {

    private List<Validator<Product>> validators;
    private ProductDAO productDAO;

    /**
     * Construct that instantiates a ProductDAO object for access to DB
     */
    public ProductBLL() {
        this.validators = new ArrayList<Validator<Product>>();
        this.productDAO = new ProductDAO();
    }

    /**
     * Method that searches in the database's Product table a product with a specific id
     *
     * @param id id of product to search
     * @return a Product object if the search succeeded else null
     */
    public Product findProductById(int id) {
        Product st =  productDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The Product with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     * Method that searches in the database's Product table a product with a specific name
     *
     * @param productName name of product to be searched for
     * @return the found Product object if the search succeeded else null
     */
    public Product findProductByName(String productName) {
        Product st = productDAO.findByField(productName);
        if (st == null) {
            throw new NoSuchElementException("The Product with productName =" + productName + " was not found!");
        }
        return st;
    }

    /**
     * Method for inserting a new product in the database
     *
     * @param product product to be inserted
     * @return number of rows affected
     */
    public int insertProduct(Product product) {
        for (Validator<Product> v : validators) {
            v.validate(product);
        }
        return productDAO.insert(product);
    }

    /**
     * Method for updating an existing product from the DB
     *
     * @param prodToUpdate name of product to be updated
     * @param product  product to be updated
     * @return number of rows affected
     */
    public int updateProduct(String prodToUpdate, Product product) {
        for (Validator<Product> v : validators) {
            v.validate(product);
        }
        return productDAO.update(product,prodToUpdate);
    }

    /**
     * Method used to update the stock of a product after an order has been placed for that product
     *
     * @param prodToUpdate name of product to be updated
     * @param stock new stock value
     * @return number of rows affected
     */
    public int updateProductStock(String prodToUpdate, int stock) {
        return ProductDAO.updateStock(prodToUpdate,stock);
    }

    /**
     * Method for deleting an exiting product from DB
     *
     * @param prodToDelete  product to be updated
     * @return number of rows affected
     */
    public int deleteProduct(String prodToDelete) {
        return productDAO.delete(prodToDelete);
    }

    public ArrayList<Product> existingProducts(){
        return (ArrayList<Product>) productDAO.findAll();
    }
}


