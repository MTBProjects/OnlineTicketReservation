/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Admin
 */
@ManagedBean
@RequestScoped
public class mainBean {

    /**
     * Creates a new instance of mainBean
     */
    public mainBean() {
    }
    
    public String getContextPath() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ex = fc.getExternalContext();
        String s = ex.getRequestContextPath();
        return s;
    }

}
