package com.testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

		

		String lo = req.getParameter("sourceofcandidate");
		String pas = req.getParameter("name");

		String sor = req.getParameter("source");
		String loc = req.getParameter("location");

		String id = req.getParameter("email");
		String ph = req.getParameter("workphone");

		String no = req.getParameter("cellno");
		String avl = req.getParameter("availability");

		String ben = req.getParameter("benchcandidate");
		String skl = req.getParameter("skills");

		String ex = req.getParameter("experience");
		String not = req.getParameter("notes");

		String code = req.getParameter("code");
		String rate = req.getParameter("rate");

		String st = req.getParameter("status");
		String hom = req.getParameter("homephone");

		String ext = req.getParameter("ext");
		String rel = req.getParameter("relocation");

		String gsk = req.getParameter("genericskills");

			// System.out.println("Record for "+lo+" has been inserted");
		    PrintWriter out = res.getWriter();

			out.println("<html><head>");

			out.println("<title>TestServlet ( by ");
			out.println(" )</title>");
			out.println("<style>body, p { font-family:tahoma;");
			out.println(" font-size:12pt; }</style>");
			out.println("</head>");
			out.println("<body bgcolor=lightyellow>");
			out.println("<body>");
			out.println("<p><b>Details Entered</b>");
			out.println("</p>");
			out.println("<br>");

			out.println("<table border=2>");

			out.println("<tr>");
			out.println("<td>Sourece Of Candidate</td>");
			out.println("<td> " + lo + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Name</td>");
			out.println("<td> " + pas + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Sourece</td> ");
			out.println("<td> " + sor + " <td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Location</td>");
			out.println("<td> " + loc + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Email Id</td>");
			out.println("<td> " + id + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Phone No</td>");
			out.println("<td> " + ph + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Cell No</td>");
			out.println("<td> " + no + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Availability</td>");
			out.println("<td> " + avl + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Bench Candidate</td>");
			out.println("<td> " + ben + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Skills</td>");
			out.println("<td> " + skl + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Experience</td>");
			out.println("<td> " + ex + " </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Notes</td>");
			out.println("<td> " + not + " </td>");
			out.println("</tr>");

			out.println("</table>");

			// out.println(loc + pas);
			out.println("<br>");
			out.println("<form method=post action=http://localhost:8080/examples/2.html name=form1 ONSUBMIT=return ValidateEAddress()>");

			out.println("<input  id=button type=submit value=Submit>");

			out.println("</body></html>");

		}

		

	

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		doGet(req, res);
	}
}