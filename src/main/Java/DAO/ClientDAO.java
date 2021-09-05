package DAO;


import Service.Order.Client;

import java.sql.SQLException;
import java.util.List;


public interface ClientDAO {

    //read
    void add(Client client) throws SQLException;

    List<Client> getAll() throws SQLException;

    Client getById(int ID) throws SQLException;


    //update
    void update(Client client) throws SQLException;

    //delete
    void removeById(int id) throws SQLException;

}