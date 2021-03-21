package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.execption.ResourceNotFoundException;

/**
 * Interface for employee resource operations service.
 */
public interface EmployeeResourceService {


    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    Employee employeeGetById( String id) throws ResourceNotFoundException;

    /**
     * Create the {@link Employee} resource by employeeDetails.
     *
     * @param employeeDetails employee employeeDetail.
     * @return {@link Employee} resource.
     */
    Employee addEmployee(Employee employeeDetails);
}
