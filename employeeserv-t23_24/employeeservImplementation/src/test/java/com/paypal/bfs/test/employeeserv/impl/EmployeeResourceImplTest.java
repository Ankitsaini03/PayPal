package com.paypal.bfs.test.employeeserv.impl;


import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.execption.ResourceNotFoundException;
import com.paypal.bfs.test.employeeserv.service.EmployeeResourceService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeResourceImplTest{


    @InjectMocks
    EmployeeResourceImpl employeeResource;

    @Mock
    private EmployeeResourceService employeeResourceService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void testEmployeeGetById() throws ResourceNotFoundException {
        when(employeeResourceService.employeeGetById("1")).thenReturn(createEmployee());
         ResponseEntity<Employee> employee= employeeResource.employeeGetById("1");
        assertEquals(HttpStatus.OK, employee.getStatusCode());
    }

    @Test
    public void testAddEmployee() {
        when(employeeResourceService.addEmployee(createEmployee())).thenReturn(createEmployee());
        ResponseEntity<Employee> employee= employeeResource.addEmployee(createEmployee());
        assertEquals(HttpStatus.OK, employee.getStatusCode());
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

}