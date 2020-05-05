package s1;

import java.sql.*;
import java.util.ArrayList;

public class CityDAO {

    private static String url = "jdbc:postgresql://localhost/citiesdb";
    private static String username = "postgres";
    private static String password = "vitya22102000";

    public static ArrayList<City> select() {

        ArrayList<City> cities = new ArrayList<City>();
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM cities");
                while (resultSet.next()) {

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int stateId = resultSet.getInt(3);
                    City city = new City(id, name, stateId);
                    cities.add(city);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cities;
    }

    public static City selectOne(int id) {

        City city = null;
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "SELECT * FROM cities WHERE id=?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {

                        int prodId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        int price = resultSet.getInt(3);
                        city = new City(prodId, name, price);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return city;
    }

    public static int insert(City city) {

        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "INSERT INTO cities (name, state_id) Values (?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, City.getName());
                    preparedStatement.setInt(2, City.getStateId());

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public static int update(City city) {

        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "UPDATE cities SET name = ?, state_id = ? WHERE id = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, City.getName());
                    preparedStatement.setInt(2, City.getStateId());
                    preparedStatement.setInt(3, City.getId());

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public static int delete(int id) {

        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "DELETE FROM cities WHERE id = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}


