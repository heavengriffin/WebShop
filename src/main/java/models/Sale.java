package models;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sale {

    private int saleId;
    private int productId;

    private int buyerId;

    private int quantity;

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public void insert() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(Dao.URL, Dao.USERNAME, Dao.PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO sales (product_id, buyer_id, quantity) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, productId);
            preparedStatement.setInt(2, buyerId);
            preparedStatement.setInt(3, quantity);
            preparedStatement.execute();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    public static List<Sale> getAll() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        List<Sale> sales = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(Dao.URL, Dao.USERNAME, Dao.PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM sales");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sale sale = new Sale();
                sale.setSaleId(resultSet.getInt("sale_id"));
                sale.setProductId(resultSet.getInt("product_id"));
                sale.setBuyerId(resultSet.getInt("buyer_id"));
                sale.setQuantity(resultSet.getInt("quantity"));
                sales.add(sale);
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return sales;
    }

    public void deleteByProduct() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(Dao.URL, Dao.USERNAME, Dao.PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM sales WHERE product_id = ?");
            preparedStatement.setInt(1, productId);
            preparedStatement.execute();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    public void deleteByBuyer() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(Dao.URL, Dao.USERNAME, Dao.PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM sales WHERE buyer_id = ?");
            preparedStatement.setInt(1, buyerId);
            preparedStatement.execute();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}
