package action;


import DAO.*;
import entity.User;
import pool.ConnectionPool;
import util.Const;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;

public class RegisterAction implements Action, Const {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        User user = new User();
        AbstractDAO dao = new UserDAO();

        try {
            user.setLogin(request.getParameter(LOGIN));
            user.setPassword(request.getParameter(PASSWORD));
            dao.add(user);
        }finally {
            dao.returnConnectionInPool();
        }

        return LOGIN_JSP;
    }
}
