package DAO;

import entity.*;
import util.Const;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO extends AbstractDAO<Car> implements Const {
    @Override
    public void add(Car car) throws SQLException {
        PreparedStatement preparedStatement = getPreparedStatement("INSERT INTO car(state,driver_id,feature) VALUES(?,?,?)");

        try {
            preparedStatement.setString(1,CarState.GOOD.toString());
            preparedStatement.setInt(2,car.getUser().getId());
            preparedStatement.setString(3,car.getFeature().toString());
            preparedStatement.execute();
        }finally {
            closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public Car getById(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Car car) throws SQLException {

    }

    @Override
    public void delete(Car car) throws SQLException {

    }

    @Override
    public List<Car> getAll() throws SQLException {
        List<Car> cars = new ArrayList<>();
        PreparedStatement preparedStatement = getPreparedStatement(
                SELECT_ALL_FROM_CAR);

        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                cars.add(new Car(resultSet.getInt(CAR_ID),Feature.valueOf(resultSet.getString(FEATURE)),
                        new User(resultSet.getInt(ID))));
            }
        }finally {
            closePreparedStatement(preparedStatement);
        }
        return cars;
    }

    public List<Car> getByUser(User user) throws SQLException{
        List<Car> cars = null;
        PreparedStatement preparedStatement = getPreparedStatement(SELECT_FROM_CAR_BY_USER);

        try {
            preparedStatement.setInt(1,user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                cars = new ArrayList<>();
                do{
                    cars.add(new Car(resultSet.getInt(CAR_ID),CarState.valueOf(resultSet.getString(STATE)),
                            user,Feature.valueOf(resultSet.getString(FEATURE))));
                }while (resultSet.next());
            }
        }finally {
            closePreparedStatement(preparedStatement);
        }
        return cars;
    }

    public void changeCarState(Car car) throws SQLException{
        PreparedStatement preparedStatement = getPreparedStatement(UPDATE_CAR_STATE);

        try {
            preparedStatement.setString(1,car.getCarState().toString());
            preparedStatement.setInt(2,car.getId());
            preparedStatement.execute();
        }finally {
            closePreparedStatement(preparedStatement);
        }

    }
}
