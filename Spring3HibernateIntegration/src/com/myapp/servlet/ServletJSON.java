package com.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.myapp.entity.Persona;

/**
 * Servlet implementation class ServletJSON
 */
//@WebServlet("/ServletJSON")
public class ServletJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    Persona p1 = new Persona("pedro", "perez", 20);
	    Persona p2 = new Persona("pedro", "perez", 20);
	    List<Persona> lista = new ArrayList<Persona>();
	    lista.add(p1);
	    lista.add(p2);
	    PrintWriter pw = response.getWriter();
	    Gson gson = new Gson();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    pw.println(gson.toJson(lista));		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
