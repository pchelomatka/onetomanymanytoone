package main.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer emp_id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "manager_id")
    private Integer manager_id;

    @OneToMany(mappedBy = "employee")
    private List<Phone> phones;


    public Integer getId() {
        return emp_id;
    }

    public void setId(Integer id) {
        this.emp_id = id;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void addPhone(Phone phone) {
        this.phones.add(phone);
        if(this != phone.getEmployee()) {
            phone.setEmployee(this);
        }
    }
}
