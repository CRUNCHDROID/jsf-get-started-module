package com.crunchdroid.beans;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Riad YOUSFI <riad.yousfi@outlook.com>
 */
@XmlRootElement
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String firstname;

    private String lastname;

    private Integer age;

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + '}';
    }

}
