package action;

import DAO.AbstractDAO;
import DAO.CarDAO;
import entity.Car;
import entity.Feature;
import entity.User;
import util.Const;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class AddCarAction implements Action, Const {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Car car = new Car(Feature.valueOf(request.getParameter("feature")),
                new User(Integer.parseInt(request.getParameter("user_id"))));
        AbstractDAO<Car> carDAO = new CarDAO();

        try {
            carDAO.add(car);
        }finally {
            carDAO.returnConnectionInPool();
        }

        return MAIN_DIR;
    }
}
