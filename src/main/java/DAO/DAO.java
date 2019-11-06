package DAO;


import java.sql.SQLException;

public interface DAO<T> {
    void add(T t) throws SQLException;
    T getById(int id) throws SQLException;
    void update(T t) throws SQLException;
    void delete(T t) throws SQLException;
}
