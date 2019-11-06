package util;


public interface Const {

    String USER_ATTR = "user";
    String CAR_ID = "car_id";
    String FLIGHT_ID = "flight_id";
    String MAIN_DIR = "/main";
    String LOGIN_JSP = "/login.jsp";
    String LOGIN = "login";
    String PASSWORD = "password";
    String CARS_ATTR = "cars";
    String FLIGHTS_ATTR = "flights";
    String MAIN_ADMIN_JSP = "/MainAdmin.jsp";
    String MAIN_DRIVER_JSP = "/MainDriver.jsp";
    String MAIN_USER_JSP = "/MainUser.jsp";
    String FLIGHT_MARK = "Flight_mark";
    String CAR_STATE = "car_state";
    String FEATURE = "feature";
    String ID = "id";
    String STATE = "state";
    String MARK = "mark";
    String ROLE = "role";

    ///SQL
    String SELECT_ALL_FROM_CAR = "SELECT car.car_id,car.feature,usr.id FROM car INNER JOIN usr ON car.driver_id = usr.id WHERE car.state = 'GOOD'";
    String SELECT_FROM_CAR_BY_USER = "SELECT * FROM car WHERE driver_id = ?";
    String UPDATE_CAR_STATE = "UPDATE car SET state = ? WHERE car_id = ?";
    String SELECT_ALL_FROM_FLIGHT = "SELECT * FROM flight INNER JOIN request ON flight.req_id = request.req_id WHERE mark = 0";
    String SELECT_FLIGHT_BY_USER = "SELECT * FROM flight INNER JOIN car ON flight.car_id = car.car_id JOIN usr ON car.driver_id = usr.id WHERE mark = 0 AND usr.id = ?";
    String UPDATE_FLIGHT_MARK = "UPDATE flight SET mark = ? WHERE id = ?";
    String SET_CAR_FOR_FLIGHT = "UPDATE flight SET car_id = ? WHERE id = ?";
    String ADD = "INSERT INTO usr(login,password) VALUES (?,?)";
    String GET_BY_LOGIN_AND_PASSWORD = "SELECT * FROM usr WHERE login = ? AND password = ?";
    String GET_BY_ID = "SELECT * FROM usr WHERE id=?";
    String DELETE_USER = "DELETE FROM usr WHERE id = ?";

}
