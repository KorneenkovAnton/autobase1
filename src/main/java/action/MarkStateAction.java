package action;

import DAO.AbstractDAO;
import DAO.CarDAO;
import entity.Car;
import entity.CarState;
import util.Const;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class MarkStateAction implements Action, Const {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Car car = new Car(Integer.parseInt(request.getParameter(CAR_ID)));
        car.setCarState(CarState.valueOf(request.getParameter(CAR_STATE)));
        AbstractDAO<Car> carAbstractDAO = new CarDAO();

        try {
            ((CarDAO)carAbstractDAO).changeCarState(car);
        }finally {
            carAbstractDAO.returnConnectionInPool();
        }
        return MAIN_DIR;
    }
}
