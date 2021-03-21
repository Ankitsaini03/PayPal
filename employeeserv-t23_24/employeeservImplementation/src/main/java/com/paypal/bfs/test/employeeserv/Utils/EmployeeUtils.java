package com.paypal.bfs.test.employeeserv.Utils;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.model.AddressEntity;
import com.paypal.bfs.test.employeeserv.model.EmployeeEntity;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeUtils {

    public static Employee convertEmployeeEntityToEmployee(EmployeeEntity employeeEntity){
        Employee employee = new Employee();

        employee.setId((int) employeeEntity.getId());
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setDateOfBirth(covertDateToString(employeeEntity.getDateOfBirth()));
        employee.setAddress(covertAddressEntitytoAddress(employeeEntity.getAddress()));

        return employee;
    }

    private static String covertDateToString(Date dateOfBirth) {
        String pattern = "MM/dd/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(dateOfBirth);
    }

    public static Address covertAddressEntitytoAddress(AddressEntity addressEntity) {
        Address address = new Address();

        address.setId((int) addressEntity.getId());
        address.setLine1(addressEntity.getLine1());
        address.setLine2(addressEntity.getLine2());
        address.setCity(addressEntity.getCity());
        address.setState(addressEntity.getState());
        address.setCountry(addressEntity.getCountry());
        address.setZipCode(addressEntity.getZipCode());

        return address;
    }

    public static EmployeeEntity convertEmployeeToEmployeeEntity(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setId((int) employee.getId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setDateOfBirth(covertStringToDate(employee.getDateOfBirth()));
        employeeEntity.setAddress(covertAddressToAddressEntity(employee.getAddress()));

        return employeeEntity;
    }

    private static Date covertStringToDate(String dateOfBirth) {
        return Date.valueOf(dateOfBirth);
    }

    public static AddressEntity covertAddressToAddressEntity(Address address) {
        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setId(address.getId());
        addressEntity.setLine1(address.getLine1());
        addressEntity.setLine2(address.getLine2());
        addressEntity.setCity(address.getCity());
        addressEntity.setState(address.getState());
        addressEntity.setCountry(address.getCountry());
        addressEntity.setZipCode(address.getZipCode());

        return addressEntity;
    }
}
