package DAO;

import Service.Order.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO{

    //read
    void add(Book book) throws SQLException;

    List<Book> getAll() throws SQLException;

    Book getById(int ID) throws SQLException;


    //update
    void update(Book book) throws SQLException;

    //delete
    void removeById(int id) throws SQLException;

}
