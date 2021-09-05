package DAO;

import Connection.ConnectionManager;
import Service.Order.Book;
import Service.Order.Client;
import Service.Order.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOOrder extends ConnectionManager implements OrderDAO{
    Connection connection = getConnection();

    @Override
    public void add(Order order) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO \"Orders\" (client, bookOne, bookTwo, bookThree, isConfirmed) VALUES(?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, order.getClient());
            preparedStatement.setString(2, order.getBookOne());
            preparedStatement.setString(3, order.getBookTwo());
            preparedStatement.setString(4, order.getBookThree());
            preparedStatement.setBoolean(5, order.isConfirmed());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();

            }
        }
    }

    @Override
    public List<Order> getAll() throws SQLException {
        PreparedStatement statement = null;
        List<Client> ordersList = new ArrayList<>();
        String sql = "SELECT id, client, bookOne, bookTwo, bookThree, isConfirmed FROM \"Clients\"";
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setC(resultSet.getString("client"));
                order.setAuthor(resultSet.getString("author"));
                order.setGenre(resultSet.getString("genre"));
                order.setPresence(resultSet.getBoolean("presence"));

                ordersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {

                statement.close();

            }
        }
        return ordersList;
    }

    @Override
    public Order getById(int ID) throws SQLException {
        return null;
    }

    @Override
    public void removeById(int id) throws SQLException {

    }

    @Override
    public void update(Order order) throws SQLException {
    }
}
