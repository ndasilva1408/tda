package com.p12.toitdesaines.services.impl;

import com.p12.toitdesaines.DAO.EmployeeRepository;
import com.p12.toitdesaines.DTO.EmployeeDTO;
import com.p12.toitdesaines.entity.Employee;
import com.p12.toitdesaines.mapper.EmployeeMapper;
import com.p12.toitdesaines.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toDto(employeeDTO);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
