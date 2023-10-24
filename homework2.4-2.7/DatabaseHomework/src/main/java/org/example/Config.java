package org.example;

import java.time.LocalDateTime;
import java.sql.*;

public class Config {

    Config() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "user", "user");
    }

    // вывод на экран базы данных из двух таблиц
    public void meme(){
        try {
            Statement  statement = getConnection().createStatement();
            String query = "SELECT paydate, value, name FROM expenses, receivers WHERE receiver=receivers.num";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+" "+ resultSet.getString(2)+" "+resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // добавление в базу
    public void addInDb (String[] args) throws SQLException {

        if (args.length != 4){
            System.out.println("ожидается 4 аргумента, ни больше ни меньше");
        }

        int num = Integer.parseInt(args[0]);
        String date = args[1];
        int receiver = Integer.parseInt(args[2]);
        double value =Double.parseDouble(args[3]);

        String sql = "INSERT INTO expenses (num, paydate,receiver,value) VALUES (?,?,?,?)";
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ps.setInt(1, num);
        ps.setString(2, date);
        ps.setInt(3, receiver);
        ps.setDouble(4, value);
        ps.executeUpdate();
    }
}
