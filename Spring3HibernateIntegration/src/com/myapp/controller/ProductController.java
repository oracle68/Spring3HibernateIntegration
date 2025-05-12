package com.myapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.entity.Product;
import com.myapp.util.HibernateUtil;

@RestController
public class ProductController {

	@RequestMapping(value="/product/{id}", method = RequestMethod.GET)
	public void getProductIdl(@PathVariable("id") Long id,HttpServletResponse response) throws IOException {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	    Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.eq("id",id));
		
		Product  p =   (Product) criteria.uniqueResult();

	    tx.commit();
	    response.setHeader("Custom-Header", "Header");
	    if (p==null)
	    {
	    	response.setStatus(404);
	    	response.getWriter().println("NOT FOUND");	    	
	    }	
	    else
	    	
	    {
	    	response.setStatus(200);
	    	response.getWriter().println(p);
	    }
	    
	}	
	
	@RequestMapping(value="/productList", method = RequestMethod.GET)
	public void ProducList(HttpServletResponse response) throws IOException {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	    Criteria criteria = session.createCriteria(Product.class);
		
		List<Product>  pList =   criteria.list();

	    tx.commit();
	    response.setHeader("Custom-Header", "Header");
	    if (pList==null)
	    {
	    	response.setStatus(404);
	    	response.getWriter().println("NOT FOUND");	    	
	    }	
	    else
	    	
	    {
	    	response.setStatus(200);
	    	response.getWriter().println(pList);
	    }
	    
	}		
}
