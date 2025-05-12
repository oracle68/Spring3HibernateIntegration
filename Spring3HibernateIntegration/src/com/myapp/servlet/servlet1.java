package com.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class servlet1
 */
@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger log = Logger.getLogger(servlet1.class);    
	//@Autowired
	//SimpleFilter simpleFilter;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        boolean b =false;
		PrintWriter out = response.getWriter();
		out.append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		   if(session.getAttribute("cart") == null)
		        session.setAttribute("cart", "cart");
		
		Date d = new Date();
		request.setAttribute("fecha", d);
		List<String> usuarios = new ArrayList<String>(); 
		usuarios = getUsuarios();
		request.setAttribute("usuarios", usuarios);
		if (b)
		{	
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/pag.jsp");
		rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private List<String> getUsuarios()
	{
		List<String> usuarios = new ArrayList<String>(); 
		try {
		    Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		} catch (Exception ex) {
		    log.error("No se encontro el Driver MySQL para JDBC.");
	        }

		try {
			
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jose", "jose");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select first_name from usuarios");
            while (rs.next()){
                usuarios.add(rs.getString(1));
            }

            conn.close();
        }catch (Exception ex){ex.printStackTrace();}
		return usuarios;
	}
	

}
