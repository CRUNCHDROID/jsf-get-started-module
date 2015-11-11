package com.crunchdroid.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Riad YOUSFI
 */
@Entity
@Table
@XmlRootElement
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 45, message = "Size 45")
    @NotNull(message = "NotNull firstname")
    @Column(name = "firstname")
    private String firstname;

    @Size(max = 45, message = "Size 45")
    @NotNull(message = "NotNull lastname")
    @Column(name = "lastname")
    private String lastname;

    @NotNull(message = "NotNull birthDate")
    @Pattern(regexp = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", message = "Pattern birthDate")
    @Temporal(TemporalType.DATE)
    @Past(message = "Past birthDate")
    @Column(name = "birth_date")
    private Date birthDate;

    @NotNull(message = "NotNull email")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Pattern email")
    @Column(name = "email")
    private String email;

    @Transient
    private Integer age;

    public Person() {
    }

    public Person(String firstname, String lastname, Date birthDate, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        Calendar now = GregorianCalendar.getInstance();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(this.birthDate);
        return now.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        return String.format("Person[ id = %s, firstname = %s, lastname = %s, birthDate = %s, email = %s, age = %s ]",
                id, firstname, lastname, birthDate, email, age);
    }

}
