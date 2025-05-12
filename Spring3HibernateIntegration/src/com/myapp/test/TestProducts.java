package com.myapp.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.myapp.entity.Product;
import com.myapp.util.HibernateUtil;

public class TestProducts {

	public static void main (String  args[])
	{
		new TestProducts().save();
	}
	public void save ()
	{
		Long id=2L;
		String name="P22";
		String description ="Desc 22";
		Double price=220.0;
		Product p = new Product(id,name,description,price);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	    session.save(p);
	    Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.like("name","%",MatchMode.ANYWHERE));
		criteria.add(Restrictions.ge("price", 10.0));
		List<Product> pList = criteria.list();
		for (Product var: pList)
		{
			System.out.println(var.toString());	
		}		
	    tx.commit();
	  
			  
	}  
}
