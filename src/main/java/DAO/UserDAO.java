package DAO;


import entity.Role;
import entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import util.Const;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<User> implements Const{

    public User getByLoginAndPassword(String login,String password) throws SQLException{
        User user = null;
        PreparedStatement preparedStatement = getPreparedStatement(GET_BY_LOGIN_AND_PASSWORD);

        try {
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,DigestUtils.md5Hex(password));
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt(ID));
                user.setLogin(login);
                user.setPassword(password);
                if(resultSet.getString(ROLE)!= null){
                    user.setRole(Role.valueOf(resultSet.getString(ROLE)));
                }
            }
        }finally {
            closePreparedStatement(preparedStatement);
        }

        return user;
    }

    @Override
    public void add(User user) throws SQLException{
        PreparedStatement preparedStatement = getPreparedStatement(ADD);
        try {
            preparedStatement.setString(1,user.getLogin());
            preparedStatement.setString(2,DigestUtils.md5Hex(user.getPassword()));
            preparedStatement.execute();
        }finally {
            closePreparedStatement(preparedStatement);
        }

    }

    @Override
    public User getById(int id) throws SQLException{
        User user = new User();
        PreparedStatement preparedStatement = getPreparedStatement(GET_BY_ID);

        try {
            preparedStatement.setString(1,String.valueOf(id));

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user.setId(resultSet.getInt(ID));
                user.setLogin(resultSet.getString(LOGIN_JSP));
                user.setPassword(resultSet.getString(PASSWORD));///DigestUtils
                if(resultSet.getString(ROLE)!= null){
                    user.setRole(Role.valueOf(resultSet.getString(ROLE)));
                }
            }
        }finally {
            closePreparedStatement(preparedStatement);
        }
        return user;
    }

    @Override
    public void update(User user) throws SQLException{

    }

    @Override
    public void delete(User user) throws SQLException{
        PreparedStatement preparedStatement = getPreparedStatement(DELETE_USER);

        try {
            preparedStatement.setInt(1,user.getId());
            preparedStatement.executeUpdate();
        }finally {
            closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement preparedStatement = getPreparedStatement(GET_USERS);

        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                users.add(new User(resultSet.getInt(ID),Role.DRIVER,resultSet.getString(LOGIN),null));
            }
        }finally {
            closePreparedStatement(preparedStatement);
        }
        return users;
    }
}
