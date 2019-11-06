package servlet;

import action.AbstractActionFactory;
import action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = AbstractActionFactory.getInstance().getAction(req);
        if(action != null){
            String view;
            try {
                view = action.execute(req,resp);
                getServletContext().getRequestDispatcher(view).forward(req,resp);

            } catch (SQLException e) {
                e.printStackTrace();
                getServletContext().getRequestDispatcher("/Error.jsp").forward(req,resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
