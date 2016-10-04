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
import stub.CustomerStub;

/**
 *
 * @author PC
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    private String email;
    private String password;
    private String message;
    private final FacesContext facesContext;
    private final HttpServletRequest httpServletRequest;
    private FacesMessage faceMessage;

    public LoginBean() {
        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String login() {
        CustomerStub stub = new CustomerStub();
        int check = stub.findCustomer(email, password).size();
        if (check == 1) {
            httpServletRequest.getSession().setAttribute("email", email);
            faceMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucessfully", null);
            facesContext.addMessage(null, faceMessage);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("email", email);
            return "main?faces-redirect=true";
        } else {
            faceMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed", null);
            facesContext.addMessage(null, faceMessage);
            return "login";
        }
    }   
}
