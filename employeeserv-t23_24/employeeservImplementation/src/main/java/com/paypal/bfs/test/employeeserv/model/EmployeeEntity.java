package com.paypal.bfs.test.employeeserv.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "employee")
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employee_id")
    private long id;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "address", joinColumns = @JoinColumn(name = "employee_id"),
               inverseJoinColumns = @JoinColumn(name = "address_id"))
    private AddressEntity address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity employee = (EmployeeEntity) o;
        return id == employee.id &&
                firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                dateOfBirth.equals(employee.dateOfBirth) &&
                address.equals(employee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, dateOfBirth, address);
    }
}
