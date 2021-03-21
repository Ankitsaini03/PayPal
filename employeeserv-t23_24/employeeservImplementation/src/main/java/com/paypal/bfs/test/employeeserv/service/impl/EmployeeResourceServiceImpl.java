package com.paypal.bfs.test.employeeserv.service.impl;

import com.paypal.bfs.test.employeeserv.Utils.EmployeeUtils;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.execption.ResourceNotFoundException;
import com.paypal.bfs.test.employeeserv.model.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.EmployeeResourceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeResourceServiceImpl implements EmployeeResourceService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee employeeGetById(String id) throws ResourceNotFoundException {
        Employee employee = null;
        if(StringUtils.isNotBlank(id)) {
            long employeeId = Long.valueOf(id);
            EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

               employee = EmployeeUtils.convertEmployeeEntityToEmployee(employeeEntity);

        }
        return employee;
    }

    @Override
    public Employee addEmployee(Employee employeeDetails) {
        Employee createdEmployee = null;
        EmployeeEntity employeeEntity = EmployeeUtils.convertEmployeeToEmployeeEntity(employeeDetails);
        EmployeeEntity employee = employeeRepository.save(employeeEntity);

        if(employee !=null){
            createdEmployee = EmployeeUtils.convertEmployeeEntityToEmployee(employee);
        }
        return createdEmployee;
    }
}
