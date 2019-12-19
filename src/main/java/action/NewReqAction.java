package action;

import DAO.AbstractDAO;
import DAO.FlightDAO;
import DAO.RequestDAO;
import entity.Feature;
import entity.Flight;
import entity.Req;
import util.Const;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class NewReqAction implements Action, Const {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        AbstractDAO<Req> reqAbstractDAO = new RequestDAO();
        AbstractDAO<Flight> flightAbstractDAO = new FlightDAO();
        Feature feature = Feature.valueOf(request.getParameter("feature"));
        Req req = new Req(feature);
        Flight flight;

        try {
            reqAbstractDAO.add(req);
            flight = new Flight(req);
            flightAbstractDAO.add(flight);
        }finally {
            reqAbstractDAO.returnConnectionInPool();
            flightAbstractDAO.returnConnectionInPool();
        }

        return MAIN_DIR;
    }
}
