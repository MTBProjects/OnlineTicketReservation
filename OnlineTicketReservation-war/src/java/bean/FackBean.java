/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author PC
 */
@ManagedBean(name = "fack")
@RequestScoped
public class FackBean {

    private String param_1;
    private String param_2;
    private String param_3;
    private String param_4;
    private String param_5;
    private String param_6;

    public String getParam_1() {
        return param_1;
    }

    public void setParam_1(String param_1) {
        this.param_1 = param_1;
    }

    public String getParam_2() {
        return param_2;
    }

    public void setParam_2(String param_2) {
        this.param_2 = param_2;
    }

    public String getParam_3() {
        return param_3;
    }

    public void setParam_3(String param_3) {
        this.param_3 = param_3;
    }

    public String getParam_4() {
        return param_4;
    }

    public void setParam_4(String param_4) {
        this.param_4 = param_4;
    }

    public String getParam_5() {
        return param_5;
    }

    public void setParam_5(String param_5) {
        this.param_5 = param_5;
    }

    public String getParam_6() {
        return param_6;
    }

    public void setParam_6(String param_6) {
        this.param_6 = param_6;
    }

    public String show() {
        FacesContext f = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) f.getExternalContext().getRequest();
        param_1 = request.getParameter("choosen-number");
        param_2 = request.getParameter("choosen-number--cheap");
        param_3 = request.getParameter("choosen-number--middle");
        param_4 = request.getParameter("choosen-number--expansive");
        param_5 = request.getParameter("choosen-cost");
        param_6 = request.getParameter("choosen-sits");
        System.out.println("param1: " + param_1);
        System.out.println("param2: " + param_2);
        System.out.println("param3: " + param_3);
        System.out.println("param4: " + param_4);
        System.out.println("param5: " + param_5);
        System.out.println("param6: " + param_6);
        param_6 = param_6.trim();
        param_6 = param_6.replaceAll(" ", "");
        List<String> lst = new ArrayList();
        StringTokenizer tok = new StringTokenizer(param_6);
        do {
            String temp = tok.nextToken(",");
            if (!lst.contains(temp)) {
                lst.add(temp);
            }
        } while (tok.hasMoreTokens());
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i));
        }
        return "test_ajax";
    }

    public String text() {
        return "book_s2";
    }
}
