package presentation;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

/**
 * Class that creates the user interface
 *
 * @author Tirlea Maria Cristina
 * @since Apr 20, 2021
 */
public class View  extends JFrame {
    private JTextField cnp;
    private JTextField fname;
    private JTextField lname;
    private JTextField phone;
    private JTextField email;
    private JTextField tfCnpOld;
    private JTextField tfFirstNameOld;
    private JTextField tfLastNameOld;
    private JTextField tfPhoneOld;
    private JTextField tfEmailOld;
    private JTextField tfCnpNew;
    private JTextField tfFirstNameNew;
    private JTextField tfLastNameNew;
    private JTextField tfPhoneNew;
    private JTextField tfEmailNew;
    private JTable clientsTable;
    private final JPanel ordersPanel = new JPanel();
    private JComboBox cbProductName;
    private JComboBox cbClientName;
    private JTextField tfProductNameAdd;
    private JTextField tfProductCategAdd;
    private JTextField tfProductPriceAdd;
    private JTable productsTable;
    private JTextField tfProductNameOld;
    private JTextField tfProductCategOld;
    private JTextField tfProductPriceOld;
    private JTextField tfProductNameNew;
    private JTextField tfProductCategNew;
    private JTextField tfProductPriceNew;
    private JSpinner ageSpinner;
    private JButton btnClearClientAdd;
    private JButton btnAddClient;
    private JButton btnDeleteClient;
    private JSpinner ageSpinnerOld;
    private JSpinner ageSpinnerNew;
    private JButton btnClearClientEdit;
    private JButton btnEditClient;
    private JButton btnViewClients;
    private JSpinner orderAmountSpinner;
    private JButton btnClearOrder;
    private JButton btnAddOrder;
    private JButton btnDeleteOrder;
    private JComboBox cbClientCnp;
    private JButton btnReceipt;
    private JButton btnClearAddProduct;
    private JButton btnAddProduct;
    private JButton btnDeleteProduct ;
    private JButton btnClearEditProduct;
    private JButton btnEditProduct;
    private JButton btnViewProducts;
    private JTextField tfStockOld;
    private JLabel lblStockOld;
    private JTextField tfStockNew;
    private JLabel lblStockNew;
    private JTextField tfStock;
    private JLabel lblStockOld_1;
    private JButton btnFetchDataFromDB;

    /**
     * Create the application.
     */
    public View() {
        getContentPane().setBackground(new Color(143, 188, 143));
        initialize();
    }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        this.setBounds(100, 100, 859, 596);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setToolTipText("Client");
        tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 13));
        tabbedPane.setBounds(6, 0, 833, 546);

        getContentPane().add(tabbedPane);

        JPanel clientPanel = new JPanel();
        tabbedPane.addTab("Clients", null, clientPanel, null);
        tabbedPane.setBackgroundAt(0, new Color(216, 191, 216));
        clientPanel.setBackground(new Color(230, 230, 250));
        clientPanel.setLayout(null);

        JPanel addClientPanel = new JPanel();
        addClientPanel.setBackground(new Color(245, 245, 220));
        addClientPanel.setBounds(14, 6, 271, 297);
        clientPanel.add(addClientPanel);
        addClientPanel.setLayout(null);

        cnp = new JTextField();
        cnp.setBounds(114, 0, 131, 28);
        addClientPanel.add(cnp);
        cnp.setColumns(10);

        fname = new JTextField();
        fname.setBounds(114, 33, 131, 28);
        addClientPanel.add(fname);
        fname.setColumns(10);

        lname = new JTextField();
        lname.setBounds(114, 67, 131, 28);
        addClientPanel.add(lname);
        lname.setColumns(10);

        phone = new JTextField();
        phone.setBounds(114, 134, 131, 28);
        addClientPanel.add(phone);
        phone.setColumns(10);

        email = new JTextField();
        email.setBounds(114, 169, 131, 28);
        addClientPanel.add(email);
        email.setColumns(10);

        JLabel lblCNP = new JLabel("CNP");
        lblCNP.setBounds(20, 6, 94, 16);
        addClientPanel.add(lblCNP);
        lblCNP.setFont(new Font("Tahoma", Font.BOLD, 13));

        JLabel lblFirstName = new JLabel("First name");
        lblFirstName.setBounds(20, 39, 94, 16);
        addClientPanel.add(lblFirstName);
        lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));

        JLabel lblLastName = new JLabel("Last name");
        lblLastName.setBounds(20, 73, 94, 16);
        addClientPanel.add(lblLastName);
        lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));

        JLabel lblAge = new JLabel("Age");
        lblAge.setBounds(20, 106, 94, 16);
        addClientPanel.add(lblAge);
        lblAge.setFont(new Font("Tahoma", Font.BOLD, 13));

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(20, 140, 94, 16);
        addClientPanel.add(lblPhone);
        lblPhone.setFont(new Font("Tahoma", Font.BOLD, 13));

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(20, 175, 94, 16);
        addClientPanel.add(lblEmail);
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));

        ageSpinner = new JSpinner();
        ageSpinner.setBounds(114, 100, 131, 28);
        addClientPanel.add(ageSpinner);
        ageSpinner.setFont(new Font("Tahoma", Font.BOLD, 13));

        btnClearClientAdd = new JButton("CLEAR");
        btnClearClientAdd.setBounds(40, 203, 192, 28);
        addClientPanel.add(btnClearClientAdd);
        btnClearClientAdd.setForeground(new Color(255, 255, 255));
        btnClearClientAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnClearClientAdd.setBackground(new Color(178, 34, 34));

        btnAddClient = new JButton("ADD CLIENT");
        btnAddClient.setBounds(40, 236, 192, 28);
        addClientPanel.add(btnAddClient);
        btnAddClient.setForeground(Color.WHITE);
        btnAddClient.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAddClient.setBackground(new Color(95, 158, 160));

        btnDeleteClient = new JButton("<html><center>DELETE CLIENT</center></html>\r\n");
        btnDeleteClient.setBounds(40, 269, 192, 28);
        addClientPanel.add(btnDeleteClient);
        btnDeleteClient.setForeground(Color.WHITE);
        btnDeleteClient.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDeleteClient.setBackground(new Color(250, 128, 114));

        JPanel editClientPanel = new JPanel();
        editClientPanel.setBounds(297, 6, 512, 297);
        clientPanel.add(editClientPanel);
        editClientPanel.setLayout(null);
        editClientPanel.setBackground(new Color(245, 245, 220));

        tfCnpOld = new JTextField();
        tfCnpOld.setColumns(10);
        tfCnpOld.setBounds(112, 16, 112, 28);
        editClientPanel.add(tfCnpOld);

        tfFirstNameOld = new JTextField();
        tfFirstNameOld.setColumns(10);
        tfFirstNameOld.setBounds(112, 49, 112, 28);
        editClientPanel.add(tfFirstNameOld);

        tfLastNameOld = new JTextField();
        tfLastNameOld.setColumns(10);
        tfLastNameOld.setBounds(112, 83, 112, 28);
        editClientPanel.add(tfLastNameOld);

        tfPhoneOld = new JTextField();
        tfPhoneOld.setColumns(10);
        tfPhoneOld.setBounds(112, 150, 112, 28);
        editClientPanel.add(tfPhoneOld);

        tfEmailOld = new JTextField();
        tfEmailOld.setColumns(10);
        tfEmailOld.setBounds(112, 185, 112, 28);
        editClientPanel.add(tfEmailOld);

        JLabel lblCnpNew = new JLabel("CNP");
        lblCnpNew.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCnpNew.setBounds(18, 22, 83, 16);
        editClientPanel.add(lblCnpNew);

        JLabel lblFirstNameOld = new JLabel("First name");
        lblFirstNameOld.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblFirstNameOld.setBounds(18, 55, 82, 16);
        editClientPanel.add(lblFirstNameOld);

        JLabel lblLastNameOld = new JLabel("Last name");
        lblLastNameOld.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblLastNameOld.setBounds(18, 89, 82, 16);
        editClientPanel.add(lblLastNameOld);

        JLabel lblAgeOld = new JLabel("Age");
        lblAgeOld.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAgeOld.setBounds(18, 122, 82, 16);
        editClientPanel.add(lblAgeOld);

        JLabel lblPhoneOld = new JLabel("Phone");
        lblPhoneOld.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPhoneOld.setBounds(18, 156, 82, 16);
        editClientPanel.add(lblPhoneOld);

        JLabel lblEmailOld = new JLabel("Email");
        lblEmailOld.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEmailOld.setBounds(18, 191, 82, 16);
        editClientPanel.add(lblEmailOld);

        ageSpinnerOld = new JSpinner();
        ageSpinnerOld.setFont(new Font("Tahoma", Font.BOLD, 13));
        ageSpinnerOld.setBounds(112, 116, 112, 28);
        editClientPanel.add(ageSpinnerOld);

        btnClearClientEdit = new JButton("CLEAR");
        btnClearClientEdit.setForeground(Color.WHITE);
        btnClearClientEdit.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnClearClientEdit.setBackground(new Color(178, 34, 34));
        btnClearClientEdit.setBounds(204, 219, 123, 28);
        editClientPanel.add(btnClearClientEdit);

        btnEditClient = new JButton("EDIT CLIENT");
        btnEditClient.setForeground(Color.WHITE);
        btnEditClient.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnEditClient.setBackground(new Color(95, 158, 160));
        btnEditClient.setBounds(204, 252, 123, 28);
        editClientPanel.add(btnEditClient);

        JLabel lblNewValuesClients = new JLabel("<html><center>with <br> values</center></html>");
        lblNewValuesClients.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewValuesClients.setBounds(236, 122, 52, 32);
        editClientPanel.add(lblNewValuesClients);

        tfCnpNew = new JTextField();
        tfCnpNew.setColumns(10);
        tfCnpNew.setBounds(394, 16, 112, 28);
        editClientPanel.add(tfCnpNew);

        tfFirstNameNew = new JTextField();
        tfFirstNameNew.setColumns(10);
        tfFirstNameNew.setBounds(394, 49, 112, 28);
        editClientPanel.add(tfFirstNameNew);

        tfLastNameNew = new JTextField();
        tfLastNameNew.setColumns(10);
        tfLastNameNew.setBounds(394, 83, 112, 28);
        editClientPanel.add(tfLastNameNew);

        tfPhoneNew = new JTextField();
        tfPhoneNew.setColumns(10);
        tfPhoneNew.setBounds(394, 150, 112, 28);
        editClientPanel.add(tfPhoneNew);

        tfEmailNew = new JTextField();
        tfEmailNew.setColumns(10);
        tfEmailNew.setBounds(394, 185, 112, 28);
        editClientPanel.add(tfEmailNew);

        JLabel lblNewLabel_1_1 = new JLabel("CNP");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_1.setBounds(300, 22, 83, 16);
        editClientPanel.add(lblNewLabel_1_1);

        JLabel lblFirstNameNew = new JLabel("First name");
        lblFirstNameNew.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblFirstNameNew.setBounds(300, 55, 82, 16);
        editClientPanel.add(lblFirstNameNew);

        JLabel lblLastNameNew = new JLabel("Last name");
        lblLastNameNew.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblLastNameNew.setBounds(300, 89, 82, 16);
        editClientPanel.add(lblLastNameNew);

        JLabel lblAgeNew = new JLabel("Age");
        lblAgeNew.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAgeNew.setBounds(300, 122, 82, 16);
        editClientPanel.add(lblAgeNew);

        JLabel lblPhoneNew = new JLabel("Phone");
        lblPhoneNew.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPhoneNew.setBounds(300, 156, 82, 16);
        editClientPanel.add(lblPhoneNew);

        JLabel lblEmailNew = new JLabel("Email");
        lblEmailNew.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEmailNew.setBounds(300, 191, 82, 16);
        editClientPanel.add(lblEmailNew);

        ageSpinnerNew = new JSpinner();
        ageSpinnerNew.setFont(new Font("Tahoma", Font.BOLD, 13));
        ageSpinnerNew.setBounds(394, 116, 112, 28);
        editClientPanel.add(ageSpinnerNew);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 331, 795, 179);
        clientPanel.add(scrollPane);

        clientsTable = new JTable();
        clientsTable.setBackground(new Color(216, 191, 216));

        clientsTable.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(),40));
        clientsTable.getTableHeader().setReorderingAllowed(false);
        clientsTable.setRowHeight(35);

        scrollPane.setViewportView(clientsTable);

        btnViewClients = new JButton("View all clients");
        btnViewClients.setForeground(new Color(255, 255, 255));
        btnViewClients.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnViewClients.setBackground(new Color(205, 92, 92));
        btnViewClients.setBounds(654, 302, 155, 28);
        clientPanel.add(btnViewClients);
        ordersPanel.setBackground(new Color(230, 230, 250));
        tabbedPane.addTab("Orders\r\n", null, ordersPanel, null);
        tabbedPane.setEnabledAt(1, true);
        tabbedPane.setBackgroundAt(1, new Color(216, 191, 216));
        ordersPanel.setLayout(null);

        JPanel placeOrdersPanel = new JPanel();
        placeOrdersPanel.setLayout(null);
        placeOrdersPanel.setBackground(new Color(245, 245, 220));
        placeOrdersPanel.setBounds(275, 60, 271, 328);
        ordersPanel.add(placeOrdersPanel);

        cbProductName = new JComboBox();
        cbProductName.setBounds(114, 33, 131, 28);
        placeOrdersPanel.add(cbProductName);

        cbClientName = new JComboBox();
        cbClientName.setBounds(114, 67, 131, 28);
        placeOrdersPanel.add(cbClientName);

        JLabel lblClientName = new JLabel("Client Name");
        lblClientName.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblClientName.setBounds(20, 73, 82, 16);
        placeOrdersPanel.add(lblClientName);

        orderAmountSpinner = new JSpinner();
        orderAmountSpinner.setFont(new Font("Tahoma", Font.BOLD, 13));
        orderAmountSpinner.setBounds(114, 133, 131, 28);
        placeOrdersPanel.add(orderAmountSpinner);

        btnClearOrder = new JButton("CLEAR");
        btnClearOrder.setForeground(Color.WHITE);
        btnClearOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnClearOrder.setBackground(new Color(178, 34, 34));
        btnClearOrder.setBounds(41, 179, 192, 28);
        placeOrdersPanel.add(btnClearOrder);

        btnAddOrder = new JButton("ADD ORDER");
        btnAddOrder.setForeground(Color.WHITE);
        btnAddOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAddOrder.setBackground(new Color(95, 158, 160));
        btnAddOrder.setBounds(41, 212, 192, 28);
        placeOrdersPanel.add(btnAddOrder);

        btnDeleteOrder = new JButton("<html><center>DELETE ORDER</center></html>\r\n");
        btnDeleteOrder.setForeground(Color.WHITE);
        btnDeleteOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDeleteOrder.setBackground(new Color(250, 128, 114));
        btnDeleteOrder.setBounds(41, 245, 192, 28);
        placeOrdersPanel.add(btnDeleteOrder);

        JLabel lblAmount = new JLabel("Amount");
        lblAmount.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAmount.setBounds(20, 139, 82, 16);
        placeOrdersPanel.add(lblAmount);

        JLabel lblProductName = new JLabel("Product name");
        lblProductName.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblProductName.setBounds(20, 39, 90, 16);
        placeOrdersPanel.add(lblProductName);

        cbClientCnp = new JComboBox();
        cbClientCnp.setBounds(114, 101, 131, 28);
        placeOrdersPanel.add(cbClientCnp);

        JLabel lblClientCnp = new JLabel("Client CNP");
        lblClientCnp.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblClientCnp.setBounds(20, 107, 82, 16);
        placeOrdersPanel.add(lblClientCnp);

        btnReceipt = new JButton("RECEIPT");
        btnReceipt.setForeground(Color.WHITE);
        btnReceipt.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnReceipt.setBackground(new Color(205, 92, 92));
        btnReceipt.setBounds(41, 278, 192, 28);
        placeOrdersPanel.add(btnReceipt);

        btnFetchDataFromDB = new JButton("Get existing clients/products");
        btnFetchDataFromDB.setForeground(Color.WHITE);
        btnFetchDataFromDB.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnFetchDataFromDB.setBackground(new Color(205, 92, 92));
        btnFetchDataFromDB.setBounds(20, 3, 225, 26);
        placeOrdersPanel.add(btnFetchDataFromDB);

        JPanel productsPanel = new JPanel();
        productsPanel.setLayout(null);
        productsPanel.setBackground(new Color(230, 230, 250));
        tabbedPane.addTab("Products", null, productsPanel, null);
        tabbedPane.setBackgroundAt(2, new Color(216, 191, 216));

        JPanel addProductsPanel = new JPanel();
        addProductsPanel.setLayout(null);
        addProductsPanel.setBackground(new Color(245, 245, 220));
        addProductsPanel.setBounds(14, 6, 271, 297);
        productsPanel.add(addProductsPanel);

        tfProductNameAdd = new JTextField();
        tfProductNameAdd.setColumns(10);
        tfProductNameAdd.setBounds(114, 33, 131, 28);
        addProductsPanel.add(tfProductNameAdd);

        tfProductCategAdd = new JTextField();
        tfProductCategAdd.setColumns(10);
        tfProductCategAdd.setBounds(114, 67, 131, 28);
        addProductsPanel.add(tfProductCategAdd);

        tfProductPriceAdd = new JTextField();
        tfProductPriceAdd.setColumns(10);
        tfProductPriceAdd.setBounds(114, 100, 131, 28);
        addProductsPanel.add(tfProductPriceAdd);

        JLabel lblProdName = new JLabel("Product name");
        lblProdName.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblProdName.setBounds(20, 39, 95, 16);
        addProductsPanel.add(lblProdName);

        JLabel lblCategory = new JLabel("Category");
        lblCategory.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCategory.setBounds(20, 73, 82, 16);
        addProductsPanel.add(lblCategory);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPrice.setBounds(20, 106, 82, 16);
        addProductsPanel.add(lblPrice);

        btnClearAddProduct = new JButton("CLEAR");
        btnClearAddProduct.setForeground(Color.WHITE);
        btnClearAddProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnClearAddProduct.setBackground(new Color(178, 34, 34));
        btnClearAddProduct.setBounds(40, 177, 192, 28);
        addProductsPanel.add(btnClearAddProduct);

        btnAddProduct = new JButton("ADD PRODUCT");
        btnAddProduct.setForeground(Color.WHITE);
        btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAddProduct.setBackground(new Color(95, 158, 160));
        btnAddProduct.setBounds(40, 210, 192, 28);
        addProductsPanel.add(btnAddProduct);

        btnDeleteProduct = new JButton("<html><center>DELETE PRODUCT\r\n</center></html>\r\n");
        btnDeleteProduct.setForeground(Color.WHITE);
        btnDeleteProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDeleteProduct.setBackground(new Color(250, 128, 114));
        btnDeleteProduct.setBounds(40, 243, 192, 28);
        addProductsPanel.add(btnDeleteProduct);

        tfStock = new JTextField();
        tfStock.setColumns(10);
        tfStock.setBounds(114, 134, 131, 28);
        addProductsPanel.add(tfStock);

        lblStockOld_1 = new JLabel("Stock");
        lblStockOld_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblStockOld_1.setBounds(20, 140, 82, 16);
        addProductsPanel.add(lblStockOld_1);

        JPanel editProductsPanel = new JPanel();
        editProductsPanel.setLayout(null);
        editProductsPanel.setBackground(new Color(245, 245, 220));
        editProductsPanel.setBounds(297, 6, 530, 297);
        productsPanel.add(editProductsPanel);

        btnClearEditProduct = new JButton("CLEAR");
        btnClearEditProduct.setForeground(Color.WHITE);
        btnClearEditProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnClearEditProduct.setBackground(new Color(178, 34, 34));
        btnClearEditProduct.setBounds(204, 219, 144, 28);
        editProductsPanel.add(btnClearEditProduct);

        btnEditProduct = new JButton("EDIT PRODUCT");
        btnEditProduct.setForeground(Color.WHITE);
        btnEditProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnEditProduct.setBackground(new Color(95, 158, 160));
        btnEditProduct.setBounds(204, 252, 144, 28);
        editProductsPanel.add(btnEditProduct);

        JLabel lblNewValues = new JLabel("<html><center>with <br> values</center></html>");
        lblNewValues.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewValues.setBounds(236, 82, 52, 32);
        editProductsPanel.add(lblNewValues);

        tfProductNameOld = new JTextField();
        tfProductNameOld.setColumns(10);
        tfProductNameOld.setBounds(100, 49, 131, 28);
        editProductsPanel.add(tfProductNameOld);

        tfProductCategOld = new JTextField();
        tfProductCategOld.setColumns(10);
        tfProductCategOld.setBounds(100, 83, 131, 28);
        editProductsPanel.add(tfProductCategOld);

        tfProductPriceOld = new JTextField();
        tfProductPriceOld.setColumns(10);
        tfProductPriceOld.setBounds(100, 116, 131, 28);
        editProductsPanel.add(tfProductPriceOld);

        JLabel lblProdNameOld = new JLabel("Product name");
        lblProdNameOld.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblProdNameOld.setBounds(6, 55, 95, 16);
        editProductsPanel.add(lblProdNameOld);

        JLabel lblCategoryOld = new JLabel("Category");
        lblCategoryOld.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCategoryOld.setBounds(6, 89, 82, 16);
        editProductsPanel.add(lblCategoryOld);

        JLabel lblPriceOld = new JLabel("Price");
        lblPriceOld.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPriceOld.setBounds(6, 122, 82, 16);
        editProductsPanel.add(lblPriceOld);

        tfProductNameNew = new JTextField();
        tfProductNameNew.setColumns(10);
        tfProductNameNew.setBounds(381, 49, 131, 28);
        editProductsPanel.add(tfProductNameNew);

        tfProductCategNew = new JTextField();
        tfProductCategNew.setColumns(10);
        tfProductCategNew.setBounds(381, 83, 131, 28);
        editProductsPanel.add(tfProductCategNew);

        tfProductPriceNew = new JTextField();
        tfProductPriceNew.setColumns(10);
        tfProductPriceNew.setBounds(381, 116, 131, 28);
        editProductsPanel.add(tfProductPriceNew);

        JLabel lblProdNameNew = new JLabel("Product name");
        lblProdNameNew.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblProdNameNew.setBounds(287, 55, 95, 16);
        editProductsPanel.add(lblProdNameNew);

        JLabel lblCategoryNew = new JLabel("Category");
        lblCategoryNew.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCategoryNew.setBounds(287, 89, 82, 16);
        editProductsPanel.add(lblCategoryNew);

        JLabel lblPriceNew = new JLabel("Price");
        lblPriceNew.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPriceNew.setBounds(287, 122, 82, 16);
        editProductsPanel.add(lblPriceNew);

        tfStockOld = new JTextField();
        tfStockOld.setColumns(10);
        tfStockOld.setBounds(100, 151, 131, 28);
        editProductsPanel.add(tfStockOld);

        lblStockOld = new JLabel("Stock");
        lblStockOld.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblStockOld.setBounds(6, 157, 82, 16);
        editProductsPanel.add(lblStockOld);

        tfStockNew = new JTextField();
        tfStockNew.setColumns(10);
        tfStockNew.setBounds(381, 151, 131, 28);
        editProductsPanel.add(tfStockNew);

        lblStockNew = new JLabel("Stock");
        lblStockNew.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblStockNew.setBounds(287, 157, 82, 16);
        editProductsPanel.add(lblStockNew);

        JScrollPane productsScrollPane = new JScrollPane();
        productsScrollPane.setBounds(14, 331, 813, 179);
        productsPanel.add(productsScrollPane);

        btnViewProducts = new JButton("View all products");
        btnViewProducts.setForeground(Color.WHITE);
        btnViewProducts.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnViewProducts.setBackground(new Color(205, 92, 92));
        btnViewProducts.setBounds(672, 302, 155, 28);
        productsPanel.add(btnViewProducts);

        productsTable = new JTable();
        productsTable.setBackground(new Color(216, 191, 216));
        productsTable.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(),40));
        productsTable.getTableHeader().setReorderingAllowed(false);
        productsTable.setRowHeight(35);
        productsScrollPane.setViewportView(productsTable);


    }

    public JTextField getTfStockOld() {
        return tfStockOld;
    }

    public JTextField getTfStockNew() {
        return tfStockNew;
    }

    public JTextField getTfStock() {
        return tfStock;
    }

    public JTable getClientsTable() {
        return clientsTable;
    }

    public JPanel getOrdersPanel() {
        return ordersPanel;
    }

    public JComboBox getCbProductName() {
        return cbProductName;
    }

    public JComboBox getCbClientName() {
        return cbClientName;
    }

    public JTable getProductsTable() {
        return productsTable;
    }

    public JButton getBtnClearClientAdd() {
        return btnClearClientAdd;
    }

    public JButton getBtnAddClient() {
        return btnAddClient;
    }

    public JButton getBtnDeleteClient() {
        return btnDeleteClient;
    }

    public JButton getBtnClearClientEdit() {
        return btnClearClientEdit;
    }

    public JButton getBtnEditClient() {
        return btnEditClient;
    }

    public JButton getBtnViewClients() {
        return btnViewClients;
    }

    public JButton getBtnClearOrder() {
        return btnClearOrder;
    }

    public JButton getBtnAddOrder() {
        return btnAddOrder;
    }

    public JButton getBtnDeleteOrder() {
        return btnDeleteOrder;
    }

    public JComboBox getCbClientCnp() {
        return cbClientCnp;
    }

    public JButton getBtnReceipt() {
        return btnReceipt;
    }

    public JButton getBtnClearAddProduct() {
        return btnClearAddProduct;
    }

    public JButton getBtnAddProduct() {
        return btnAddProduct;
    }

    public JButton getBtnDeleteProduct() {
        return btnDeleteProduct;
    }

    public JButton getBtnClearEditProduct() {
        return btnClearEditProduct;
    }

    public JButton getBtnEditProduct() {
        return btnEditProduct;
    }

    public JButton getBtnViewProducts() {
        return btnViewProducts;
    }

    public JTextField getCnp() {
        return cnp;
    }

    public JTextField getFname() {
        return fname;
    }

    public JTextField getLname() {
        return lname;
    }

    public JTextField getPhone() {
        return phone;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getTfCnpOld() {
        return tfCnpOld;
    }

    public JTextField getTfFirstNameOld() {
        return tfFirstNameOld;
    }

    public JTextField getTfLastNameOld() {
        return tfLastNameOld;
    }

    public JTextField getTfPhoneOld() {
        return tfPhoneOld;
    }

    public JTextField getTfEmailOld() {
        return tfEmailOld;
    }

    public JTextField getTfCnpNew() {
        return tfCnpNew;
    }

    public JTextField getTfFirstNameNew() {
        return tfFirstNameNew;
    }

    public JTextField getTfLastNameNew() {
        return tfLastNameNew;
    }

    public JTextField getTfPhoneNew() {
        return tfPhoneNew;
    }

    public JTextField getTfEmailNew() {
        return tfEmailNew;
    }

    public JTextField getTfProductNameAdd() {
        return tfProductNameAdd;
    }

    public JTextField getTfProductCategAdd() {
        return tfProductCategAdd;
    }

    public JTextField getTfProductPriceAdd() {
        return tfProductPriceAdd;
    }

    public JTextField getTfProductNameOld() {
        return tfProductNameOld;
    }

    public JTextField getTfProductCategOld() {
        return tfProductCategOld;
    }

    public JTextField getTfProductPriceOld() {
        return tfProductPriceOld;
    }

    public JTextField getTfProductNameNew() {
        return tfProductNameNew;
    }

    public JTextField getTfProductCategNew() {
        return tfProductCategNew;
    }

    public JTextField getTfProductPriceNew() {
        return tfProductPriceNew;
    }

    public JSpinner getAgeSpinner() {
        return ageSpinner;
    }

    public JSpinner getAgeSpinnerOld() {
        return ageSpinnerOld;
    }

    public JSpinner getAgeSpinnerNew() {
        return ageSpinnerNew;
    }

    public JSpinner getOrderAmountSpinner() {
        return orderAmountSpinner;
    }

    public JButton getBtnFetchDataFromDB() {
        return btnFetchDataFromDB;
    }
}
