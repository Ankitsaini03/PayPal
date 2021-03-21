package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @RequestMapping("/v1/bfs/employees/{id}")
    @GetMapping
    ResponseEntity<Employee> employeeGetById(@PathVariable("id") String id) ;

    /**
     * Create the {@link Employee} resource by employeeDetails.
     *
     * @param employeeDetails employee employeeDetail.
     * @return {@link Employee} resource.
     */
    @RequestMapping("/v1/bfs/employees")
    @PostMapping
    ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employeeDetails);

    // ----------------------------------------------------------
    // TODO - add a new operation for creating employee resource.
    // ----------------------------------------------------------
}
