package model;

/**
 * Class that models the Product table from the database
 * @author Tirlea Maria Cristina
 * @since Apr 20, 2021
 */
public class Product {
    private Integer id;
    private String product_Name;
    private Double price;
    private String category;
    private Integer stockCount;

    public Product(Integer id, String product_Name, Double price, String category, Integer stockCount) {
        this.id = id;
        this.product_Name = product_Name;
        this.price = price;
        this.category = category;
        this.stockCount = stockCount;
    }

    public Product(String product_Name, Double price, String category, Integer stockCount) {
        this.product_Name = product_Name;
        this.price = price;
        this.category = category;
        this.stockCount = stockCount;
    }

    public Product() {

    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", productName=" + product_Name + ", category=" + category+ ", price=" + price + ", stockCount=" + stockCount + "]";
    }
}
