package model;
/**
 * Class that models the Orders table from the database
 *
 * @author Tirlea Maria Cristina
 * @since Apr 20, 2021
 */
public class Orders {
    private Integer id;
    private Integer product_ID;
    private Integer client_ID;
    private Double total_Price;
    private Integer amount;

    public Orders(Integer id, Integer product_ID, Integer clientID, Double totalPrice, Integer amount) {
        this.id = id;
        this.product_ID = product_ID;
        this.client_ID = clientID;
        this.total_Price = totalPrice;
        this.amount = amount;
    }

    public Orders(Integer product_ID, Integer clientID, Double totalPrice, Integer amount) {
        this.product_ID = product_ID;
        this.client_ID = clientID;
        this.total_Price = totalPrice;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_ID() {
        return this.product_ID;
    }

    public void setProduct_ID(Integer product_ID) {
        this.product_ID = product_ID;
    }

    public Integer getClient_ID() {
        return client_ID;
    }

    public void setClient_ID(Integer client_ID) {
        this.client_ID = client_ID;
    }

    public Double getTotal_Price() {
        return total_Price;
    }

    public void setTotal_Price(Double total_Price) {
        this.total_Price = total_Price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", productID=" + product_ID + ", clientID=" + client_ID + ", totalPrice=" + total_Price + ", amount=" + amount + "]";
    }
}
