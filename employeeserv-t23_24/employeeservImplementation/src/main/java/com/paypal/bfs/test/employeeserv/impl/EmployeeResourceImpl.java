package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.execption.ResourceNotFoundException;
import com.paypal.bfs.test.employeeserv.service.EmployeeResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    private EmployeeResourceService employeeResourceService;

    @Override
    public ResponseEntity<Employee> employeeGetById(String id)  {
      Employee employee =null;
        try {
            employee = employeeResourceService.employeeGetById(id);
        }catch(ResourceNotFoundException e){
            e.printStackTrace();
        }
      return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> addEmployee(Employee employee) {
      employee = employeeResourceService.addEmployee(employee);
      return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
