package action;

import DAO.AbstractDAO;
import DAO.CarDAO;
import DAO.FlightDAO;
import entity.Car;
import entity.Flight;
import entity.User;
import util.Const;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class MainPageAction implements Action, Const {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String answer = null;
        List<Car> cars;
        List<Flight> flights;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER_ATTR);
        AbstractDAO<Car> carDAO = new CarDAO();
        AbstractDAO<Flight> flightDAO = new FlightDAO();

        try {
            switch (user.getRole()){
                case ADMIN:{
                    flights = flightDAO.getAll();
                    cars = carDAO.getAll();
                    session.setAttribute(CARS_ATTR,cars);
                    session.setAttribute(FLIGHTS_ATTR,flights);

                    answer = MAIN_ADMIN_JSP;
                    break;
                }
                case DRIVER:{
                    cars = ((CarDAO)carDAO).getByUser(user);
                    flights = ((FlightDAO)flightDAO).getByUser(user);
                    session.setAttribute(CARS_ATTR,cars);
                    session.setAttribute(FLIGHTS_ATTR,flights);

                    answer = MAIN_DRIVER_JSP;
                    break;
                }
                case USER:{
                    answer = MAIN_USER_JSP;
                }
            }
        }finally {
            carDAO.returnConnectionInPool();
            flightDAO.returnConnectionInPool();
        }

        return answer;
    }
}
