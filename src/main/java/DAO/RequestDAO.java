package DAO;

import entity.Req;
import util.Const;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RequestDAO extends AbstractDAO<Req> implements Const {
    @Override
    public void add(Req req) throws SQLException {
        PreparedStatement preparedStatement = getPreparedStatement(ADD_NEW_REQUEST,PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,req.getFeature().toString());
        preparedStatement.executeUpdate();
        try(ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
            if(resultSet.next()){
                req.setId(resultSet.getInt(1));
            }
        }
    }

    @Override
    public Req getById(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Req req) throws SQLException {

    }

    @Override
    public void delete(Req req) throws SQLException {

    }

    @Override
    public List<Req> getAll() throws SQLException {
        return null;
    }
}
