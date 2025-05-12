package com.myapp.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.myapp.controller.UserController;
import com.myapp.entity.User;

@Repository
public class UserDaoImpl implements UserDAO {

	final static Logger log = Logger.getLogger(UserDaoImpl.class); 	
   @Autowired
   private SessionFactory sessionFactory;
	
    @Override
	public void insertData(User user) {
		this.sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList(){
		return this.sessionFactory.getCurrentSession().createQuery("from Usuarios").list();
	}

	@Override
	public void deleteData(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
                //User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        if (null != user) {
        	this.sessionFactory.getCurrentSession().delete(user);
        }
	}
	
	@Override
	public void updateData(User user) {
		    log.debug("**********************updateData**************User.gender "+user.getGender());
            this.sessionFactory.getCurrentSession().update(user); 

	}

        @Override
	public User getUser(Integer id) {
            User user =(User) this.sessionFactory.getCurrentSession().get(User.class, id);
            return user;
        }
        
        @Override
        public String getExistFirstname(String firstname){
            //String fn = firstname;
            String existe;
            User user = new User(); //) this.sessionFactory.getCurrentSession().get(User.class, firstname);
            user = (User) this.sessionFactory.getCurrentSession().createQuery("from Usuarios where firstname=:firstname").setParameter("firstname", firstname).uniqueResult();
            
            if (user!=null){
                System.out.println("USUARIO :"+user.getFirstName());
                existe ="Existe el user";
            }
            else
            {existe ="NO Existe el user";}    
            System.out.println("EXISTE USUARIOS :"+existe);
             return existe;
        }        

}
