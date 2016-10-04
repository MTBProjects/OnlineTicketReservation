/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
@ManagedBean
@RequestScoped
public class LoginSessionBean {

    private String email;
    private final FacesContext facesContext;
    private final HttpServletRequest httpServletRequest;
    private FacesMessage faceMessage;
    private boolean isLoggedIn = false;
    
    public LoginSessionBean() {
        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("email") != null) {
            email = httpServletRequest.getSession().getAttribute("email").toString();
            this.setIsLoggedIn(true);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    
    public String endSession() {
        this.setIsLoggedIn(false);
        httpServletRequest.getSession().removeAttribute("email");
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "main?faces-redirect=true";
    }
    
    
}
