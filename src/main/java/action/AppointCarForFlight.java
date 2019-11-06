package action;

import DAO.AbstractDAO;
import DAO.FlightDAO;
import entity.Car;
import entity.Flight;
import entity.Role;
import entity.User;
import util.Const;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class AppointCarForFlight implements Action, Const {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        User admin = (User) session.getAttribute(USER_ATTR);
        AbstractDAO dao = new FlightDAO();
        int carId = Integer.parseInt(request.getParameter(CAR_ID));
        int flightId = Integer.parseInt(request.getParameter(FLIGHT_ID));

        if(admin.getRole() == Role.ADMIN){
            try {
                ((FlightDAO) dao).setCar(new Flight(flightId),new Car(carId));
            }finally {
                dao.returnConnectionInPool();
            }
        }
        return MAIN_DIR;
    }
}
