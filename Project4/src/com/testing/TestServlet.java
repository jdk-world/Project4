 package com.testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
static String path = "C:\\Users\\Saurabh\\Desktop\\google\\original\\";
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

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		res.setContentType("text/html");

		PrintWriter out = res.getWriter();
		String lo = req.getParameter("login");
		String pas = req.getParameter("password");

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

			String p = "s";
			// String p;

			while (rs.next()) {
				p = rs.getString(2);

			}
			if (p.equals(pas)) {
				// print content
				out.println("<html><head>");
				out.println("<title>TestServlet ( by ");
				out.println(" )</title>");
				out.println("<style>body, p { font-family:tahoma;");
				out.println(" font-size:12pt; }</style>");
				out.println("</head>");
				out.println("<body>");
				out.println("<p>Welcome ");
				out.println(lo);
				out.println(" ) :</p>");
				out.println(lo + pas);
				out.println("</body></html>");

				res.sendRedirect("./form.html");

				out.close();

			} else {
				// print content
				out.println("<html><head>");
				out.println("<title>TestServlet ( by ");

				out.println(" )</title>");
				out.println("<style>body, p { font-family:tahoma;");
				out.println(" font-size:12pt; }</style>");
				out.println("</head>");
				out.println("<body>");

				out.println("<p>You r not registered user saurabh");

				out.println(" ) :</p>");
				out.println(lo + pas);
				out.println("</body></html>");

				out.close();
			}

		}

		catch (SQLException ce) {
			System.out.println(ce);
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		doGet(req, res);
	}
}
