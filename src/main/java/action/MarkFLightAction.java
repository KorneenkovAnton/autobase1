package action;

import DAO.AbstractDAO;
import DAO.CarDAO;
import DAO.FlightDAO;
import entity.Car;
import entity.CarState;
import entity.Flight;
import util.Const;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.event.ContainerListener;
import java.sql.SQLException;

public class MarkFLightAction implements Action, Const{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int flightId = Integer.parseInt(request.getParameter(FLIGHT_ID));
        boolean flightMark = Boolean.parseBoolean(request.getParameter(FLIGHT_MARK));
        AbstractDAO<Flight> flightAbstractDAO = new FlightDAO();
        Car car = new Car(Integer.parseInt(request.getParameter(CAR_ID)));
        car.setCarState(CarState.valueOf(request.getParameter(CAR_STATE)));
        AbstractDAO<Car> carAbstractDAO = new CarDAO();

        try {
            ((CarDAO)carAbstractDAO).changeCarState(car);
            ((FlightDAO)flightAbstractDAO).markFlight(new Flight(flightId,flightMark));
        }finally {
            flightAbstractDAO.returnConnectionInPool();
            carAbstractDAO.returnConnectionInPool();
        }

        return MAIN_DIR;
    }
}
