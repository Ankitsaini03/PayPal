package com.paypal.bfs.test.employeeserv.service.impl;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.execption.ResourceNotFoundException;
import com.paypal.bfs.test.employeeserv.model.AddressEntity;
import com.paypal.bfs.test.employeeserv.model.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeResourceServiceImplTest  {

    @InjectMocks
    EmployeeResourceServiceImpl employeeResourceService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEmployeeGetById() throws ResourceNotFoundException {
        when(employeeRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(createEmployeeEntity()));
        Employee employee = employeeResourceService.employeeGetById("1");
        assertEquals(createEmployeeEntity().getFirstName(), employee.getFirstName());
    }

    @Test
    public void testAddEmployee() {
        when(employeeRepository.save(createEmployeeEntity())).thenReturn((createEmployeeEntity()));
        Employee employee = employeeResourceService.addEmployee(createEmployee());
        assertEquals(createEmployeeEntity().getFirstName(), createEmployee().getFirstName());
    }

    @Test(expected = NullPointerException.class)
    public void testWhenExecptionEmployeeGetById() throws ResourceNotFoundException {
        ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException("Employee not found for this id :: ");
        when(employeeRepository.findById(Long.valueOf(1))).thenReturn(null);
        Employee employee = employeeResourceService.employeeGetById("1");
        assertEquals(createEmployeeEntity().getFirstName(), employee.getFirstName());
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