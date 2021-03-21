package com.paypal.bfs.test.employeeserv.Utils;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.model.AddressEntity;
import com.paypal.bfs.test.employeeserv.model.EmployeeEntity;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.assertEquals;

public class EmployeeUtilsTest  {


    @Test
    public void testConvertEmployeeEntityToEmployee(){
        EmployeeEntity employeeEntity = createEmployeeEntity();
        Employee employee = EmployeeUtils.convertEmployeeEntityToEmployee(employeeEntity);

        assertEquals(employeeEntity.getFirstName(), employee.getFirstName());
    }

    @Test
    public void testConvertEmployeeToEmployeeEntity(){
        Employee employee  = createEmployee();
        EmployeeEntity employeeEntity = EmployeeUtils.convertEmployeeToEmployeeEntity(employee);

        assertEquals(employeeEntity.getFirstName(), employee.getFirstName());
    }

    @Test
    public void testCovertAddressEntitytoAddress(){
        AddressEntity addressEntity  = createAddressEntity();
        Address address = EmployeeUtils.covertAddressEntitytoAddress(addressEntity);

        assertEquals(address.getCountry(), addressEntity.getCountry());
    }

    @Test
    public void testCovertAddressToAddressEntityTest(){
        Address address = createAddress();
        AddressEntity addressEntity = EmployeeUtils.covertAddressToAddressEntity(address);

        assertEquals(address.getCountry(), addressEntity.getCountry());

    }

    private Employee createEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Test");
        employee.setLastName("Test");
        employee.setAddress(createAddress());
        employee.setDateOfBirth("2001-01-11");
        return employee;
    }

    private Address createAddress() {
        Address address =new Address();
        address.setId(1);
        address.setLine1("test");
        address.setLine2("test");
        address.setCity("test");
        address.setState("test");
        address.setCountry("test");
        address.setZipCode(12354);
        return address;
    }


    private EmployeeEntity createEmployeeEntity() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(1);
        employeeEntity.setFirstName("Test");
        employeeEntity.setLastName("Test");
        employeeEntity.setAddress(createAddressEntity());
        employeeEntity.setDateOfBirth(new Date(new java.util.Date().getTime()));
        return employeeEntity;
    }

    private AddressEntity createAddressEntity() {
        AddressEntity addressEntity =new AddressEntity();
        addressEntity.setId(1);
        addressEntity.setLine1("test");
        addressEntity.setLine2("test");
        addressEntity.setCity("test");
        addressEntity.setState("test");
        addressEntity.setCountry("test");
        addressEntity.setZipCode(12354);
        return addressEntity;
    }


}