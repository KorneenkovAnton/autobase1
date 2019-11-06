package DAO;

import entity.*;
import util.Const;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO extends AbstractDAO<Flight>implements Const {
    @Override
    public void add(Flight flight) throws SQLException {

    }

    @Override
    public Flight getById(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Flight flight) throws SQLException {

    }

    @Override
    public void delete(Flight flight) throws SQLException {

    }

    @Override
    public List<Flight> getAll() throws SQLException {
        List<Flight> flights = new ArrayList<>();
        PreparedStatement preparedStatement = getPreparedStatement(SELECT_ALL_FROM_FLIGHT);

        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                flights.add(new Flight(resultSet.getInt(ID),new Req(resultSet.getInt(ID),
                        Feature.valueOf(resultSet.getString(FEATURE))),
                        null,resultSet.getBoolean(MARK)));
                if(resultSet.getInt(CAR_ID) != 0){
                    flights.get(flights.size() - 1).setCar(new Car(resultSet.getInt(CAR_ID)));
                }
            }
        }finally {
            closePreparedStatement(preparedStatement);
        }
        return flights;
    }

    public List<Flight> getByUser(User user) throws SQLException {
        List<Flight> flights = new ArrayList<>();
        PreparedStatement preparedStatement = getPreparedStatement(SELECT_FLIGHT_BY_USER);
        preparedStatement.setInt(1,user.getId());

        try{
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                flights.add(new Flight(resultSet.getInt(ID),new Req(resultSet.getInt(ID),
                        Feature.valueOf(resultSet.getString(FEATURE))),
                        new Car(resultSet.getInt(CAR_ID),CarState.valueOf(resultSet.getString(STATE)),
                        user,Feature.valueOf(resultSet.getString(FEATURE))),resultSet.getBoolean(MARK)));
            }
        }finally {
            closePreparedStatement(preparedStatement);
        }
        return flights;
    }

    public void markFlight(Flight flight)throws SQLException{
        PreparedStatement preparedStatement = getPreparedStatement(UPDATE_FLIGHT_MARK);

        try {
            preparedStatement.setBoolean(1,flight.isMark());
            preparedStatement.setInt(2,flight.getId());
            preparedStatement.execute();
        }finally {
            closePreparedStatement(preparedStatement);
        }
    }

    public void setCar(Flight flight, Car car) throws SQLException {
        PreparedStatement preparedStatement = getPreparedStatement(SET_CAR_FOR_FLIGHT);

        try {
            preparedStatement.setInt(1,car.getId());
            preparedStatement.setInt(2,flight.getId());
            preparedStatement.execute();
        }finally {
            closePreparedStatement(preparedStatement);
        }
    }
}
