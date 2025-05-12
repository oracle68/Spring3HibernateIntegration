package com.myapp.struts;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HelloAction extends Action{
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response)
        throws Exception {
		
		HelloForm helloForm = (HelloForm) form;
		helloForm.setMessage("Hello World! Struts");
		
		String pattern = "dd-MM-yyyy hh:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); 
		String date = simpleDateFormat.format(new Date()); 		
		helloForm.setData(date);
		
		return mapping.findForward("success");
	}
	
} 