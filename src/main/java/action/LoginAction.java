package action;

import DAO.*;
import entity.Car;
import entity.User;
import pool.ConnectionPool;
import util.Const;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class LoginAction implements Action, Const {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        User user;
        String answer = LOGIN_JSP;
        AbstractDAO<User> dao = new UserDAO();
        HttpSession session = request.getSession();

        try {
            user = ((UserDAO)dao).getByLoginAndPassword(request.getParameter(LOGIN),request.getParameter(PASSWORD));
            if(user != null){
                session.setAttribute(USER_ATTR,user);
                answer = MAIN_DIR;
            }
        }finally {
            dao.returnConnectionInPool();
        }

        return answer;
    }
}
