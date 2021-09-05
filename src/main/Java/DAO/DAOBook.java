package DAO;

import Connection.ConnectionManager;
import Service.Order.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOBook extends ConnectionManager implements BookDAO {

    Connection connection = getConnection();

    @Override
    public void add(Book book) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO \"Books\" (name, author, genre, presence) VALUES(?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setBoolean(4, book.isPresence());

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
    public List<Book> getAll() throws SQLException {
        PreparedStatement statement = null;
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT id, name, author, genre, presence FROM \"Books\"";
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setGenre(resultSet.getString("genre"));
                book.setPresence(resultSet.getBoolean("presence"));

                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {

                statement.close();

            }
        }
        return bookList;
    }

    @Override
    public Book getById(int ID) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, name, author, genre, presence FROM \"Books\" WHERE id = ?";

        Book book = new Book();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ID);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setGenre(resultSet.getString("genre"));
                book.setPresence(resultSet.getBoolean("presence"));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (preparedStatement != null) {

                preparedStatement.close();
            }
        }
        return book;
    }

    @Override
    public void update(Book book) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE \"Books\" SET name = ?, author = ?, genre = ?, presence = ?  WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setBoolean(4, book.isPresence());

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

        String sql = "DELETE FROM \"Books\" WHERE id = ?";

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
