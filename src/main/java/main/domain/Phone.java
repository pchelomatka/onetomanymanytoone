package main.domain;


import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "area_code")
    private String area_code;

    @Column(name = "p_number")
    private Integer p_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public Integer getP_number() {
        return p_number;
    }

    public void setP_number(Integer p_number) {
        this.p_number = p_number;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        if(!employee.getPhones().contains(this)) {
            employee.getPhones().add(this);
        }
    }
}
