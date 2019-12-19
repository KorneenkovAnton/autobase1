package DAO;

import pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public abstract class AbstractDAO<T> implements DAO<T> {
    private Connection connection;
    private ConnectionPool connectionPool;

    public AbstractDAO(){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    @Override
    public abstract void add(T t) throws SQLException;

    @Override
    public abstract T getById(int id) throws SQLException;

    @Override
    public abstract void update(T t) throws SQLException;

    @Override
    public abstract void delete(T t) throws SQLException;

    public abstract List<T> getAll() throws SQLException;

    public void returnConnectionInPool(){
        connectionPool.closeConnection(this.connection);
    }

    public PreparedStatement getPreparedStatement(String sql){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public PreparedStatement getPreparedStatement(String sql,int config){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql,config);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public void closePreparedStatement(PreparedStatement preparedStatement){
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void statrTran() throws SQLException {
        connection.setAutoCommit(false);
    }

    public void commitTran() throws SQLException {
        connection.commit();
    }

    public void rollbackTran() throws SQLException {
        connection.rollback();
    }
}

