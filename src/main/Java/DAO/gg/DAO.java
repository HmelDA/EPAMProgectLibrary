package DAO.gg;

import java.sql.SQLException;
import java.util.List;


public interface DAO<T extends Object> {

    //read
    void add(T t) throws SQLException;

    List<T> getAll() throws SQLException;

    T getById(int ID) throws SQLException;


    //update
    void update(T user) throws SQLException;

    //delete
    void removeById(int id) throws SQLException;
    
}