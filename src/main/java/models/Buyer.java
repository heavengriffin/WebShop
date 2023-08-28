package models;

import annotations.MustBeUnique;
import annotations.StringNotEmpty;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer {

    private int buyerId;
    @StringNotEmpty
    private String name;
    @StringNotEmpty
    private String surname;
    @StringNotEmpty
    private String address;
    private String telephoneNumber;

    @MustBeUnique
    @StringNotEmpty
    private String username;
    @StringNotEmpty
    private String password;

    private int numberOfProductsBought;

    private static String quantity;

    private static String currentBuyer;


    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumberOfProductsBought() {
        return numberOfProductsBought;
    }

    public void setNumberOfProductsBought(int numberOfProductsBought) {
        this.numberOfProductsBought = numberOfProductsBought;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getCurrentBuyer() {
        return currentBuyer;
    }

    public void setCurrentBuyer(String currentBuyer) {
        Buyer.currentBuyer = currentBuyer;
    }

    public Map<String, String> getKeys() throws ClassNotFoundException {

        Map<String, String> values = new HashMap<>();

        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Developer'sAngles9")) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT username, password FROM buyers");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                values.put(resultSet.getString("username"), resultSet.getString("password"));
            }
        } catch (SQLException exc) {
            System.err.println(exc.getMessage());
        }
        return values;
    }

    public boolean validate(Map<String, String> map) {

        boolean valid = false;

        for (Map.Entry<String, String> v : map.entrySet()) {
            valid = v.getKey().equals(username) && v.getValue().equals(password);
            if (valid) {
                currentBuyer = v.getKey();
                break;

            }
        }
        return valid;
    }

    public static List<Buyer> getAllBuyers() throws ClassNotFoundException {

        List<Buyer> buyers = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(Dao.URL, Dao.USERNAME, Dao.PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM buyers");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Buyer buyer = new Buyer();
                buyer.setBuyerId(resultSet.getInt("buyer_id"));
                buyer.setName(resultSet.getString("name"));
                buyer.setSurname(resultSet.getString("surname"));
                buyer.setAddress(resultSet.getString("address"));
                buyer.setTelephoneNumber(resultSet.getString("telephone_number"));
                buyer.setUsername(resultSet.getString("username"));
                buyer.setPassword(resultSet.getString("password"));
                buyer.setNumberOfProductsBought(resultSet.getInt("number_of_products_bought"));
                buyers.add(buyer);
            }
        } catch (SQLException exc) {
            System.err.println(exc.getMessage());
        }

        return buyers;
    }

    public static void updateBuyer() throws ClassNotFoundException {
        List<Buyer> buyers;
        int currentId = 0;
        int oldQuantity = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
            try(Connection connection = DriverManager.getConnection(Dao.URL, Dao.USERNAME, Dao.PASSWORD)) {
                buyers = Buyer.getAllBuyers();
                for (Buyer b : buyers) {
                    if (currentBuyer.equals(b.getUsername())) {
                        currentId = b.getBuyerId();
                        oldQuantity = b.getNumberOfProductsBought();
                    }
                }
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE buyers SET number_of_products_bought = ? WHERE buyer_id = ?");
                int newQuantity = Integer.parseInt(quantity);
                int currentQuantity = oldQuantity + newQuantity;
                preparedStatement.setInt(1, currentQuantity);
                preparedStatement.setInt(2, currentId);
                preparedStatement.execute();
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
    }

    public int insertBuyer() throws ClassNotFoundException {
        int inserted = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(Dao.URL, Dao.USERNAME, Dao.PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO buyers(name, surname, address, telephone_number, username, password) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, telephoneNumber);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);
            inserted = preparedStatement.executeUpdate();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return inserted;
    }

    public int updateBuyerByAdmin() throws ClassNotFoundException {
        int updated = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(Dao.URL, Dao.USERNAME, Dao.PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE buyers SET name = ?, surname = ?, address = ?, telephone_number = ?, username = ?, password = ?, number_of_products_bought = ? WHERE buyer_id = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, telephoneNumber);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);
            preparedStatement.setInt(7, numberOfProductsBought);
            preparedStatement.setInt(8, buyerId);
            updated = preparedStatement.executeUpdate();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return updated;
    }

    public int delete() throws ClassNotFoundException, SQLIntegrityConstraintViolationException {
        int deleted = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(Dao.URL, Dao.USERNAME, Dao.PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM buyers WHERE buyer_id = " + buyerId);
            deleted = preparedStatement.executeUpdate();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return deleted;
    }
}
