package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myapp.entity.Item;
import com.myapp.util.HibernateUtil;

//@Component
public class ItemAction extends Action{
	
	/*@Autowired 
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	} */  
	
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
             // extract user data
            ItemForm formBean = (ItemForm)form;	
            try
            {	
	            if (formBean.getName().equals(""))
	            {
	            	formBean.setError("Name");
	            	return mapping.findForward(FAILURE);
	            }	
	            else
	            	
	            {
		            if (formBean.getPrice().equals(""))
		            {
		            	formBean.setError("Price");
		            	return mapping.findForward(FAILURE);
		            }	
		            else	
		            {
		            	try
		            	{
		            	System.out.println("Add Item"); 
		            	Item i = new Item();
		            	i.setId(1L);
		            	i.setName(formBean.getName());
		            	i.setDescription(formBean.getDescription());
		            	Double d = Double.parseDouble(formBean.getPrice());
		            	i.setPrice(d);
		            	Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		            	Transaction tx  = s.beginTransaction();
		            	s.save(i);
		            	tx.commit();	
		            	//s.close();
		            	System.out.println("Add Item 5");
		            	return mapping.findForward(SUCCESS);
		            	}catch (Exception ex) {
		            		ex.printStackTrace();
		            	}
		            	
		            }	
	            } 	
           
		    }catch (java.lang.NullPointerException ex) 
		    {  formBean.setError("sin valores");   
		       return mapping.findForward(FAILURE);
		    }   
            return mapping.findForward(FAILURE);            

    }            
 
}
