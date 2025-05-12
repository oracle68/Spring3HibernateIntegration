package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LogForm extends org.apache.struts.action.ActionForm {
    
    private String name;
    private String error;
   
    public String getName() {
        return name;
    }
    public void setName(String string) {
        name = string;
    }

    public void setError() {
    this.error =
        "<span style='color:red'>Entra un nombre tron</span>";
    }
     public String getError() {
        return error;
    }   

    /***/
    public LogForm() {
        super();
        // TODO Auto-generated constructor stub
    }
     
     /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
  /*  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
    */
}