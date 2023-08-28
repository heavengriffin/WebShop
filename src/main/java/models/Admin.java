package models;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Admin {

    private String name;
    private String surname;
    private String address;
    private String telephoneNumber;
    private String username;
    private String password;

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

    public boolean check() throws ClassNotFoundException {
        boolean valid = false;
        Map<String, String> values = new HashMap<>();

        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(Dao.URL, Dao.USERNAME, Dao.PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT username, password FROM admins");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                values.put(resultSet.getString("username"), resultSet.getString("password"));
            }

            for (Map.Entry<String, String> v : values.entrySet()) {
                valid = v.getKey().equals(username) && v.getValue().equals(password);
                //System.out.print(v.getKey() + " " + username + " " + v.getValue() + " " + password + "\n" + valid);
                if (valid)
                    break;
            }

        } catch (SQLException exc) {
            System.err.println(exc.getMessage());
        }

        return valid;
    }
}
