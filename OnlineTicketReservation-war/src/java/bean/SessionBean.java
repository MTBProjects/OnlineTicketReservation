/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Account;
import stub.AccountStub;
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
public class SessionBean {

    private String username;
    private final FacesContext facesContext;
    private final HttpServletRequest httpServletRequest;
    private FacesMessage faceMessage;
    private boolean isLoggedIn = false;
    private boolean isAdmin = true;
    private Account acc = new Account();

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SessionBean() {
        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("username") != null) {
            username = httpServletRequest.getSession().getAttribute("username").toString();
            this.setIsLoggedIn(true);
        }
        System.out.println(username);
    }

    public Account getAccountData() {
        AccountManagedBean bean = new AccountManagedBean();
        acc = bean.findByName(username);
        return acc;
    }

    public boolean isAdmin(String role) {
        return acc.getRoleId().getRoleType().contains(role);
    }

    public String logout()  {
        this.setIsLoggedIn(false);
        httpServletRequest.getSession().removeAttribute("username");
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        faceMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Session end!", null);
        facesContext.addMessage(null, faceMessage);
        return "/employee/loginPage?faces-redirect=true";
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

}
