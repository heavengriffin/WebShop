package models;

import annotations.StringNotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private int productId;
    @StringNotEmpty
    private String name;
    @StringNotEmpty
    private String category;
    @Digits(fraction = 0, integer = 10, message = "integers only")
    @Min(value = 0, message = "positive integers only")
    private int quantityInStock;
    @Digits(fraction = 2, integer = 10, message = "numbers with or without two decimals only")
    @Min(value = 0, message = "positive values only")
    private int price;
    private static int itemsSold = 0;
    private String quantity;
    private int id;
    private String updateId;

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(int itemsSold) {
        Product.itemsSold = itemsSold;
    }

    public static List<Product> getAll() throws ClassNotFoundException {

        List<Product> products = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Developer'sAngles9")) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("product_id"));
                product.setName(resultSet.getString("name"));
                product.setCategory(resultSet.getString("category"));
                product.setQuantityInStock(resultSet.getInt("quantity_in_stock"));
                product.setPrice(resultSet.getInt("unit_price"));
                products.add(product);
            }
        } catch (SQLException exc) {
            System.err.println(exc.getMessage());
        }

        return products;
    }
    public void updateQuantity() throws ClassNotFoundException {
        int number = Integer.parseInt(quantity);
        List<Product> products = Product.getAll();
        int left = 0;
        for (Product p : products) {
            if (id == p.productId) {
                left = p.quantityInStock - number;
                break;
            }
        }

        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Developer'sAngles9")) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET quantity_in_stock = ? WHERE product_id = ?");
            preparedStatement.setInt(1, left);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    public int updateProduct() throws ClassNotFoundException {
        int updated = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Developer'sAngles9")) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET name = ?, category = ?, quantity_in_stock = ?, unit_price = ? WHERE product_id = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, category);
            preparedStatement.setInt(3, quantityInStock);
            preparedStatement.setInt(4, price);
            preparedStatement.setInt(5, productId);
            updated = preparedStatement.executeUpdate();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return updated;
    }

    public int insertProduct() throws ClassNotFoundException {
        int inserted = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Developer'sAngles9")) {
            if (name != null && !name.isEmpty() && category != null && !category.isEmpty()) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products (name, category, quantity_in_stock, unit_price) VALUES (?, ?, ?, ?)");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, category);
                preparedStatement.setInt(3, quantityInStock);
                preparedStatement.setInt(4, price);
                inserted = preparedStatement.executeUpdate();
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return inserted;
    }

    public int delete() throws ClassNotFoundException, SQLIntegrityConstraintViolationException {
        int deleted = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Developer'sAngles9")) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products WHERE product_id = " + productId);
            deleted = preparedStatement.executeUpdate();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return deleted;
    }

    public void updateItemSold() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Developer'sAngles9")) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET items_sold = ? WHERE product_id = ?");
            preparedStatement.setInt(1, itemsSold);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

}
