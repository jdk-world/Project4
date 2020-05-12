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

public class TestServlet4 extends HttpServlet {

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
		String sk = req.getParameter("skills");
		String loc = req.getParameter("location");
		String rloc = req.getParameter("relocation");

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		}
		try {

			if (sk != ("null") && loc.equals("null") && rloc.equals("null")) {
				con = DriverManager.getConnection(url);
				s = con.createStatement();
				String sql = "SELECT id,name,location,cellno,skills,relocation FROM passw WHERE skills ='"
						+ sk + "'ORDER by id ";
				rs = s.executeQuery(sql);
			}

			else if ((loc != "null") && sk.equals("null")
					&& rloc.equals("null")) {
				con = DriverManager.getConnection(url);
				s = con.createStatement();
				String sql = "SELECT id,name,location,cellno,skills,relocation FROM passw WHERE location ='"
						+ loc + "'ORDER by id ";
				rs = s.executeQuery(sql);
			}

			else if ((rloc != "null") && sk.equals("null")
					&& loc.equals("null")) {
				con = DriverManager.getConnection(url);
				s = con.createStatement();
				String sql = "SELECT id,name,location,cellno,skills,relocation FROM passw WHERE relocation ='"
						+ rloc + "'ORDER by id ";
				rs = s.executeQuery(sql);
			}

			else if ((rloc != "null") && (sk != "null") && loc.equals("null")) {
				con = DriverManager.getConnection(url);
				s = con.createStatement();
				String sql = "SELECT id,name,location,cellno,skills,relocation FROM passw WHERE relocation ='"
						+ rloc + "' and skills='" + sk + "'ORDER by id ";
				rs = s.executeQuery(sql);
			}

			else if ((rloc != "null") && (loc != "null") && sk.equals("null")) {
				con = DriverManager.getConnection(url);
				s = con.createStatement();
				String sql = "SELECT id,name,location,cellno,skills,relocation FROM passw WHERE relocation ='"
						+ rloc + "' and location='" + loc + "'ORDER by id ";
				rs = s.executeQuery(sql);
			} else if ((sk != "null") && (loc != "null") && rloc.equals("null")) {
				con = DriverManager.getConnection(url);
				s = con.createStatement();
				String sql = "SELECT id,name,location,cellno,skills,relocation FROM passw WHERE location ='"
						+ loc + "' and skills='" + sk + "'ORDER by id ";
				rs = s.executeQuery(sql);
			}

			else {
				con = DriverManager.getConnection(url);
				s = con.createStatement();
				String sql = "SELECT id,name,location,cellno,skills,relocation FROM passw WHERE location ='"
						+ loc
						+ "' and skills='"
						+ sk
						+ "' and relocation='"
						+ rloc + "'ORDER by id ";
				rs = s.executeQuery(sql);
			}

			// /////////////////////////////

			String p = "s";
			String q = "a";
			String r = "b";
			String t = "c";
			String u = "d";
			String v = "e";

			out.println("<html><head>");

			out.println("<title>TestServlet ( by ");
			out.println(" )</title>");
			out.println("<style>body, p { font-family:tahoma;");
			out.println(" font-size:12pt; }</style>");
			out.println("</head>");
			out.println("<body bgcolor=lightyellow>");
			out.println("<body>");
			out.println("YOU QUERRIED FOR--");
			out.println("<br>");

			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<td><b>S.No.</b></td>");
			out.println("<td><b>Name</b></td>");
			out.println("<td><b>Location</b></td>");
			out.println("<td><b>Cell no</b></td>");
			out.println("<td><b>Skills</b></td>");
			out.println("<td><b>Relocation</b></td>");
			out.println("<tr>");

			while (rs.next()) {
				p = rs.getString(1);
				q = rs.getString(2);
				r = rs.getString(3);
				t = rs.getString(4);
				u = rs.getString(5);
				v = rs.getString(6);

				out.println("<tr>");

				out.println("<td> " + p + " </td>");
				out.println("<td> " + q + " </td>");
				out.println("<td> " + r + " </td>");
				out.println("<td> " + t + " </td>");
				out.println("<td> " + u + " </td>");
				out.println("<td> " + v + " </td>");

				out.println("</tr>");
			}
			out.println("</body></html>");

			// /out.println(sk);

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
