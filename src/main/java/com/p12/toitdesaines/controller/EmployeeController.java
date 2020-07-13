package com.p12.toitdesaines.controller;

import com.p12.toitdesaines.DTO.EmployeeDTO;
import com.p12.toitdesaines.entity.Client;
import com.p12.toitdesaines.entity.Employee;
import com.p12.toitdesaines.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/getEmployees")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> employeeList = employeeService.getEmployees();
        if(employeeList == null) return  ResponseEntity.noContent().build();
        return  new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping(value = "/saveEmp")
    public ResponseEntity<Employee> createBillet(@RequestBody EmployeeDTO employeedto) {
        Employee employee2 = employeeService.createEmployee(employeedto);
        return new ResponseEntity<>(employee2, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteEmployee")
    public ResponseEntity<Void> deleteEmployee(@RequestParam(name = "id",defaultValue = "")Long id){
        Employee employee = employeeService.getEmployee(id);
        if(employee==null) return ResponseEntity .noContent().build();
        employeeService.deleteEmployee(employee.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
