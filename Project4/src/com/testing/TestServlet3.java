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

public class TestServlet3 extends HttpServlet {

	static String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	static String url = "jdbc:odbc:pass";
	static Connection con;
	static Statement s;
	static ResultSet rs;

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
		String columnName = req.getParameter("column");
		String columnValue = req.getParameter("value");

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		}

		try {
			con = DriverManager.getConnection(url);
			s = con.createStatement();
			String sql = "SELECT name,location,cellno,skills,relocation FROM passw WHERE id ="
					+ columnValue + " ";
			rs = s.executeQuery(sql);

			String p = "s";
			String q = "a";
			String r = "b";
			String t = "c";
			String u = "d";

			while (rs.next()) {
				p = rs.getString(1);
				q = rs.getString(2);
				r = rs.getString(3);
				t = rs.getString(4);
				u = rs.getString(5);
				// v=rs.getString(6);
			}

			out.println("<html><head>");

			out.println("<title>TestServlet ( by ");
			out.println(" )</title>");
			out.println("<style>body, p { font-family:tahoma;");
			out.println(" font-size:12pt; }</style>");
			out.println("</head>");
			out.println("<body bgcolor=lightyellow>");
			out.println("<body>");

			out.println("<font color=#FF0000><b>CANDIDATE'S PROFILE</b></font>");

			// out.println("<b>Candidate Profile</b>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");

			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<td><b>Name Of Candidate</b></td>");
			out.println("<td> " + p + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td><b>Location</b></td>");
			out.println("<td> " + q + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td><b>Cell No</b></td>");
			out.println("<td> " + r + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td><b>Skills</b></td>");
			out.println("<td> " + t + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td><b>Re Location</b></td>");
			out.println("<td> " + u + " </td>");
			out.println("</tr>");

			out.println("</table>");

			/*
			 * out.println(p); out.println(q); out.println(r); out.println(t);
			 * out.println(u);
			 */
			out.println("<br>");

			out.println("<td> " + columnName + " </td>");
			out.println("<td> " + columnValue + " </td>");

			out.println("</body></html>");

			out.close();

			con.commit();
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