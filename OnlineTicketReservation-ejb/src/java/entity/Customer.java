/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "customer", catalog = "online_ticket_booking", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "Customer.findByCustomerName", query = "SELECT c FROM Customer c WHERE c.customerName = :customerName"),
    @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password"),
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email"),
    @NamedQuery(name = "Customer.findByAddress", query = "SELECT c FROM Customer c WHERE c.address = :address"),
    @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone"),
    @NamedQuery(name = "Customer.findByDob", query = "SELECT c FROM Customer c WHERE c.dob = :dob"),
    @NamedQuery(name = "Customer.findByGenre", query = "SELECT c FROM Customer c WHERE c.genre = :genre"),
    @NamedQuery(name = "Customer.findByCreateday", query = "SELECT c FROM Customer c WHERE c.createday = :createday"),
    @NamedQuery(name = "Customer.findByPassport", query = "SELECT c FROM Customer c WHERE c.passport = :passport"),
    @NamedQuery(name = "Customer.findByLastDay", query = "SELECT c FROM Customer c WHERE c.lastDay = :lastDay"),
    @NamedQuery(name = "Customer.findCustomer", query = "SELECT c FROM Customer c WHERE c.email = :email AND c.password = :password"),
    @NamedQuery(name = "Customer.findByStatus", query = "SELECT c FROM Customer c WHERE c.status = :status")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "customer_name", nullable = false, length = 1000)
    private String customerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "password", nullable = false, length = 1000)
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "email", nullable = false, length = 1000)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "address", nullable = false, length = 1000)
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "phone", nullable = false, length = 1000)
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dob", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "genre", nullable = false, length = 1000)
    private String genre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createday", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "passport", nullable = false, length = 1000)
    private String passport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_day", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastDay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "status", nullable = false, length = 1000)
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private List<Ticket> ticketList;

    public Customer() {
    }

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }

    public Customer(Integer customerId, String customerName, String password, String email, String address, String phone, Date dob, String genre, Date createday, String passport, Date lastDay, String status) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.dob = dob;
        this.genre = genre;
        this.createday = createday;
        this.passport = passport;
        this.lastDay = lastDay;
        this.status = status;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getCreateday() {
        return createday;
    }

    public void setCreateday(Date createday) {
        this.createday = createday;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Date getLastDay() {
        return lastDay;
    }

    public void setLastDay(Date lastDay) {
        this.lastDay = lastDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Customer[ customerId=" + customerId + " ]";
    }
    
}
