package presentation;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import bll.TablePopulationBLL;
import model.Client;
import model.Orders;
import model.Product;
import start.ReceiptGenerator;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that acts on both model and view.
 * It controls the data flow into model object and updates the view whenever data changes.
 * It keeps view and model separate.
 *
 * @author Tirlea Maria Cristina
 * @since Apr 20, 2021
 */
public class Controller {
    private View view;
    public Controller(View view) {
        this.view = view;
        // "Clear" buttons
        this.view.getBtnClearAddProduct().addActionListener(new btnClearListener_AddProductPanel());
        this.view.getBtnClearClientAdd().addActionListener(new btnClearListener_AddClientPanel());
        this.view.getBtnClearOrder().addActionListener(new btnClearListener_OrdersPanel());
        this.view.getBtnClearClientEdit().addActionListener(new btnClearListener_EditClientPanel());
        this.view.getBtnClearEditProduct().addActionListener(new btnClearListener_EditProductPanel());
        // "Add" buttons
        this.view.getBtnAddClient().addActionListener(new btnAddClientListener());
        this.view.getBtnAddProduct().addActionListener(new btnAddProductListener());
        this.view.getBtnAddOrder().addActionListener(new btnPlaceOrderListener());
        // "Delete" buttons
        this.view.getBtnDeleteClient().addActionListener(new btnDeleteClientListener());
        this.view.getBtnDeleteProduct().addActionListener(new btnDeleteProductListener());
        this.view.getBtnDeleteOrder().addActionListener(new btnDeleteOrderListener());
        // "Edit" buttons
        this.view.getBtnEditClient().addActionListener(new btnEditClientListener());
        this.view.getBtnEditProduct().addActionListener(new btnEditProductListener());
        // GenerateReceipt button
        this.view.getBtnReceipt().addActionListener(new btnReceiptListener());
        // List items in table - buttons
        this.view.getBtnViewClients().addActionListener(new btnViewClientsListener());
        this.view.getBtnViewProducts().addActionListener(new btnViewProductsListener());
        //Fetch DB data button
        this.view.getBtnFetchDataFromDB().addActionListener(new btnFetchDataListener());
        populateTables();
    }

    private void populateTables(){
        ClientBLL clientBLL = new ClientBLL();
        String[] h= {"","","","","","",""};
        List<String> headers = TablePopulationBLL.getTableHeader(new Client());
        int i=0;
        for(String header: headers)
            h[i++]=header;
        this.view.getClientsTable().setModel(new DefaultTableModel(
                new Object[][] {
                },
                h
        ) {
            Class[] columnTypes = new Class[] {
                    Integer.class, String.class, String.class, String.class, Integer.class, String.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });

        ProductBLL productBLL = new ProductBLL();
        String[] hp= {"","","","",""};
        List<String> headerProducts = TablePopulationBLL.getTableHeader(productBLL.existingProducts().get(0));
        int j = 0;
        for(String header: headerProducts)
            hp[j++]=header;
        this.view.getProductsTable().setModel(new DefaultTableModel(
                new Object[][] {
                },
                hp
        ) {

        });
    }

    class btnClearListener_AddClientPanel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getAgeSpinner().setValue(0);
            view.getCnp().setText("");
            view.getFname().setText("");
            view.getLname().setText("");
            view.getEmail().setText("");
            view.getPhone().setText("");
        }
    }

    class btnClearListener_EditClientPanel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getAgeSpinnerOld().setValue(0);
            view.getTfCnpOld().setText("");
            view.getTfLastNameOld().setText("");
            view.getTfFirstNameOld().setText("");
            view.getTfEmailOld().setText("");
            view.getTfPhoneOld().setText("");
            view.getAgeSpinnerNew().setValue(0);
            view.getTfCnpNew().setText("");
            view.getTfLastNameNew().setText("");
            view.getTfFirstNameNew().setText("");
            view.getTfEmailNew().setText("");
            view.getTfPhoneNew().setText("");
        }
    }
    class btnClearListener_AddProductPanel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           view.getTfProductCategAdd().setText("");
           view.getTfProductPriceAdd().setText("");
           view.getTfProductNameAdd().setText("");
            view.getTfStock().setText("");
        }
    }

    class btnClearListener_EditProductPanel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getTfProductCategNew().setText("");
            view.getTfProductPriceNew().setText("");
            view.getTfProductNameNew().setText("");
            view.getTfProductCategOld().setText("");
            view.getTfProductPriceOld().setText("");
            view.getTfProductNameOld().setText("");
            view.getTfStockNew().setText("");
            view.getTfStockOld().setText("");
        }
    }
    class btnClearListener_OrdersPanel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCbProductName().setSelectedItem(null);
            view.getCbClientCnp().setSelectedItem(null);
            view.getCbClientName().setSelectedItem(null);
            view.getOrderAmountSpinner().setValue(0);
        }
    }

    class btnEditClientListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientBLL clientBLL = new ClientBLL();
            String cnp = view.getTfCnpOld().getText();
            Client c = clientBLL.findClientByCnp(cnp);
            int ageNew = Integer.parseInt(view.getAgeSpinnerNew().getValue().toString());
            String cnpNew = view.getTfCnpNew().getText();
            String lnameNew = view.getTfLastNameNew().getText();
            String fnameNew = view.getTfFirstNameNew().getText();
            String emailNew = view.getTfEmailNew().getText();
            String phoneNew = view.getTfPhoneNew().getText();
            Client newValues = new Client(cnpNew, fnameNew, lnameNew, ageNew, phoneNew,emailNew);
            if(c != null){
                clientBLL.updateClient(cnp,newValues);
            }
        }
    }

    class btnEditProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ProductBLL productBLL = new ProductBLL();
            String prod_name = view.getTfProductNameOld().getText();
            Product p = productBLL.findProductByName(prod_name);

            String categoryNew = view.getTfProductCategNew().getText();
            double priceNew = Double.parseDouble(view.getTfProductPriceNew().getText());
            int stock = Integer.parseInt(view.getTfStockNew().getText());
            String nameNew = view.getTfProductNameNew().getText();

            Product newValues = new Product(nameNew, priceNew, categoryNew,stock);
            if(p != null){
                productBLL.updateProduct(prod_name,newValues);
            }
        }
    }

    class btnAddClientListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientBLL clientBLL = new ClientBLL();
            int age = Integer.parseInt(view.getAgeSpinner().getValue().toString());
            String cnp = view.getCnp().getText();
            String lname = view.getLname().getText();
            String fname = view.getFname().getText();
            String email = view.getEmail().getText();
            String phone = view.getPhone().getText();
            Client c = new Client(cnp, fname, lname, age, phone,email);
            if(c != null){
                clientBLL.insertClient(c);
            }
        }
    }

    class btnDeleteClientListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientBLL clientBLL = new ClientBLL();
            String cnp = view.getCnp().getText();
            Client c = clientBLL.findClientByCnp(cnp);
            if(c != null){
                clientBLL.deleteClient(c.getCnp());
            }
        }
    }

    class btnAddProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ProductBLL productBLL = new ProductBLL();
            String prod_name = view.getTfProductNameAdd().getText();
            String category = view.getTfProductCategAdd().getText();
            double price = Double.parseDouble(view.getTfProductPriceAdd().getText());
            int stock = Integer.parseInt(view.getTfStock().getText());

            Product p = new Product(prod_name, price, category,stock);
            if(p != null){
                productBLL.insertProduct(p);
            }
        }
    }

    class btnDeleteProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ProductBLL productBLL = new ProductBLL();
            String prod_name = view.getTfProductNameAdd().getText();

            Product p = productBLL.findProductByName(prod_name);
            if(p != null){
                productBLL.deleteProduct(p.getProduct_Name());
            }
        }
    }

    class btnPlaceOrderListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ReceiptGenerator.getInstance().writeInFile("Bill\n");
            ReceiptGenerator.getInstance().writeInFile("Date: " + java.time.LocalDate.now() + "\n");
            ReceiptGenerator.getInstance().writeInFile("Time: " + java.time.LocalTime.now() + "\n\n");
            OrderBLL orderBLL = new OrderBLL();
            ClientBLL clientBLL = new ClientBLL();
            ProductBLL productBll = new ProductBLL();
            String prodName = view.getCbProductName().getSelectedItem().toString();
            String clientCnp = view.getCbClientCnp().getSelectedItem().toString();
            Integer amount = (Integer) view.getOrderAmountSpinner().getValue();
            Product p = productBll.findProductByName(prodName);
            Client c = clientBLL.findClientByCnp(clientCnp);
            System.out.println(p.toString() + c.toString());
            double totalPrice;
            if(c != null && p != null){
                ReceiptGenerator.getInstance().writeInFile("Product: "+ p.getProduct_Name() + "\t"+p.getPrice()+" x"+amount+"\n");
                totalPrice = p.getPrice() * amount;
                ReceiptGenerator.getInstance().writeInFile("\nTotal : "+ totalPrice);
                Orders o = new Orders(p.getId(),c.getId(),totalPrice,amount);
                orderBLL.insertOrder(o);
                productBll.updateProductStock(p.getProduct_Name(),p.getStockCount() - amount);
                System.out.println(p.toString());
            }
        }
    }

    class btnDeleteOrderListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            OrderBLL orderBLL = new OrderBLL();
            String prodName = view.getCbProductName().getSelectedItem().toString();
            String clientCnp = view.getCbClientCnp().getSelectedItem().toString();
            int  amount = (int) view.getOrderAmountSpinner().getValue();
            Orders o = orderBLL.findOrder(prodName,clientCnp,amount);
            if(o != null){
                orderBLL.deleteOrder(o);
            }
        }
    }

    class btnReceiptListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ReceiptGenerator.getInstance().getWriter().close();
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(ReceiptGenerator.getInstance().getFile());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    class btnViewClientsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) view.getClientsTable().getModel();
            ClientBLL clientBLL = new ClientBLL();
            model.getDataVector().removeAllElements();
            ArrayList<Client> clients = clientBLL.existingClients();
            for (int j =0; j<clients.size();j++) {
                List<String> tableRow = TablePopulationBLL.getTableRow(clients.get(j));
                model.addRow(tableRow.toArray());
            }
        }
    }

    class btnViewProductsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) view.getProductsTable().getModel();
            model.getDataVector().removeAllElements();
            ProductBLL productBLL = new ProductBLL();
            ArrayList<Product> products = productBLL.existingProducts();
            for (int j =0; j<products.size();j++) {
                List<String> tableRow = TablePopulationBLL.getTableRow(products.get(j));
                model.addRow(tableRow.toArray());
            }
        }
    }

    class btnFetchDataListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ProductBLL productBLL = new ProductBLL();
            ArrayList<Product> products = productBLL.existingProducts();
            ClientBLL clientBLL = new ClientBLL();
            ArrayList<Client> clients = clientBLL.existingClients();
            for(Client c: clients){
                view.getCbClientCnp().addItem(c.getCnp());
                view.getCbClientName().addItem(c.getFirstName() + c.getLastName());
            }
            for(Product p : products){
                view.getCbProductName().addItem(p.getProduct_Name());
            }
        }
    }
}
