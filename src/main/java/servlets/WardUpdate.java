package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BranchDAO;
import dao.UserDAO;
import dao.WardDAO;
import model.Branch;
import model.User;
import model.Ward;

@WebServlet("/editward")
public class WardUpdate extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn = new Conn();
		Connection dbConnection;
		dbConnection = conn.get_connection();

		WardDAO wardDAO = new WardDAO(dbConnection);

		Ward newWard = new Ward(Integer.parseInt(req.getParameter("wardid")), req.getParameter("wname"),
				Integer.parseInt(req.getParameter("doctor")), req.getParameter("purpose"),
				Integer.parseInt(req.getParameter("beds")), Float.parseFloat(req.getParameter("rate")),
				Integer.parseInt(req.getParameter("branch")));
		PrintWriter out = resp.getWriter();
		int ret = wardDAO.updateUser(newWard);
		if (ret != 0) {
			resp.sendRedirect("registration/wardRegister.jsp");
		} else {
			resp.sendRedirect("registration/wardRegister.jsp");
		}
	}
}
