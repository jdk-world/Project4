package com.testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8081/swagger-ui.html
//http://localhost:8081/1.html
public class TestServlet extends HttpServlet {
	static String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	static String url = "jdbc:odbc:pass";
	static Connection con;
	static Statement s;
	static ResultSet rs;

	static String driver1 = "com.mysql.jdbc.Driver";

	static String url1 = "jdbc:mysql://localhost:3306/employee";

	public void init() throws ServletException {
		System.out.println("TestServlet : init");
	}

	public void destroy() {
		System.out.println("TestServlet : destroy");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		String lo = req.getParameter("login");
		String pas = req.getParameter("password");
		String p = "s";
		RequestDispatcher rd = req.getRequestDispatcher("/TestServlet2");
		try {
			Class.forName(driver1);
		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		}
		try {
			con = DriverManager.getConnection(url1, "root", "root");
			s = con.createStatement();
			String sql = "SELECT * FROM login WHERE name ='" + lo + "'";
			rs = s.executeQuery(sql);

			// String p;

			while (rs.next()) {
				p = rs.getString(2);

			}

		}

		catch (SQLException ce) {
			System.out.println(ce);
		}

		if (p.equals(pas)) {

			res.sendRedirect("./form.html");

		}

		if (p.equals("gupt")) {
			rd.forward(req, res);// method may be include or forward

		} else {
			// print content
			res.sendRedirect("./Failure.jsp");
			// return "forward:/newpage";

		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doGet(req, res);
	}
}
