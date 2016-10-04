/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Account;
import stub.AccountStub;
import java.util.Date;
import java.util.List;
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

public class LoginDAO {

    private String username;
    private String password;
    private String message;
    private List<Account> acc = getAllAccounts();
    private final FacesContext facesContext;
    private final HttpServletRequest httpServletRequest;
    private FacesMessage faceMessage;

    public LoginDAO() {
        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<Account> getAcc() {
        return acc;
    }

    public void setAcc(List<Account> acc) {
        this.acc = acc;
    }

    public List<Account> getAllAccounts() {
        try {
            AccountStub stub = new AccountStub();
            return stub.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String login() {
        AccountStub stub = new AccountStub();
        int check = stub.findListAccount(username, password).size();
        if (check == 1) {
            Account account = stub.findSingleAccount(username, password);
            SessionBean sessionBean = new SessionBean();
            httpServletRequest.getSession().setAttribute("username", username);
            faceMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucessfully", null);
            facesContext.addMessage(null, faceMessage);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("username", username);

            account.setLastDay(new Date());
            stub.edit(account);

            if (account.getRoleId().getRoleType().equalsIgnoreCase("admin")) {
                return "indexAdminManagement?faces-redirect=true";
            } else {
                return "indexStaffManagement?faces-redirect=true";
            }
        } else {
            faceMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Username or password is incorrect",
                    "\nPlease try again");
            facesContext.addMessage(null, faceMessage);
            return "loginPage";
        }
    }
}
