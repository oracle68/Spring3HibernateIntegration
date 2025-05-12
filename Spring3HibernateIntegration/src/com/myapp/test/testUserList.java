package com.myapp.test;

import java.util.List;

import com.myapp.dao.UserDaoImpl;
import com.myapp.entity.User;

public class testUserList {

	public static void  main(String args[]) throws Exception
	{
      new testUserList().loadUserList();
	}
	
   public String loadUserList()
   {
	   String message=" <table>\n" + 
	   		"     <tr>\n" + 
	   		"     <td>ID</td><td>FirstName</td><td>LastName</td><td>City</td>\n" + 
	   		"     </tr>";   
    try
    {
  	UserDaoImpl udi = new UserDaoImpl();   
      List<User> us = udi.getUserList(); 
      for (User var :us)
      {
    
      	message=message+"<tr><td>"+var.getId()+" </td><td>"+var.getFirstName()+"</td><td>"+var.getLastName()+"</td><td>"+var.getCity()+"</td> </tr>";
        
            
      }
      message=message+"</table>";
      return message;
     }catch (Exception ex){ex.printStackTrace(); return null;}
      /*finally {
                System.out.println("se cierran los recursos");
                return nuull;
              }
    */
    
   }
}
