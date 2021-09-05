package DAO;

import Service.Order.Order;
import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {

    //read
    void add(Order order) throws SQLException;

    List<Order> getAll() throws SQLException;

    Order getById(int ID) throws SQLException;


    //update
    void update(Order order) throws SQLException;

    //delete
    void removeById(int id) throws SQLException;

}
