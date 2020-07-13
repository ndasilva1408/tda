package com.p12.toitdesaines.services;

import com.p12.toitdesaines.DTO.EmployeeDTO;
import com.p12.toitdesaines.entity.Client;
import com.p12.toitdesaines.entity.Employee;
import com.p12.toitdesaines.entity.Simapa;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee getEmployee(Long id);
    Employee createEmployee(EmployeeDTO employeedto);
    void deleteEmployee(Long id);
}
