package com.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.myapp.entity.User;
import com.myapp.service.UserService;

/**
 * Servlet implementation class testServlet
 */
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*@Autowired
    private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}   
	*/
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
		PrintWriter out =response.getWriter(); 
		ServletContext context = getServletContext();
	    WebApplicationContext ctx =  WebApplicationContextUtils.getWebApplicationContext(context);
	    UserService userService = ctx.getBean("userService", UserService.class);		
		List<User> userList = userService.getUserList(); 
		out.println("UserList:"+userList.size());
		String message = new Gson().toJson(userList); //gson.toJson(userList, new TypeToken<ArrayList<User>>() {}.getType(),  response.getWriter());

		
		out.append("Served at: ").append(request.getContextPath());
		try  {      
			out.println("<!DOCTYPE html>");      
			out.println("<html>");      
			out.println("<head>");      
			out.println("<title>Servlet WebController</title>");      
			out.println("</head>");      
			out.println("<body>");                  
			out.println("<br>UserList JSON:<br>" );
			out.println(message);      
			out.println("</body>");      
			out.println("</html>");   
			} catch(Exception ex) {ex.printStackTrace(); }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
