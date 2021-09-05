package DAO;

import Connection.ConnectionManager;
import Service.Order.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOClient extends ConnectionManager implements ClientDAO {

    Connection connection = getConnection();
    @Override
    public void add(Client client) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO \"Clients\" (firstName, lastName) VALUES(?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());

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
    public List<Client> getAll() throws SQLException {
        PreparedStatement statement = null;
        List<Client> clientList = new ArrayList<>();
        String sql = "SELECT id, firstName, lastName FROM \"Clients\"";
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("ID"));
                client.setFirstName(resultSet.getString("firstName"));
                client.setLastName(resultSet.getString("lastName"));

                clientList.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {

                statement.close();

            }
        }
        return clientList;
    }

    @Override
    public Client getById(int ID) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, firstName, lastName FROM \"Clients\" WHERE ID = ?";

        Client client = new Client();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                client.setId(resultSet.getInt("ID"));
                client.setFirstName(resultSet.getString("firstName"));
                client.setLastName(resultSet.getString("lastName"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {

                preparedStatement.close();

            }
        }
        return client;
    }

    @Override
    public void update(Client client) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE \"Clients\" SET firstName = ?, lastName = ? WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setInt(3, client.getId());

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
    public void removeById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM \"Clients\" WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {

                preparedStatement.close();

            }
        }
    }
}
