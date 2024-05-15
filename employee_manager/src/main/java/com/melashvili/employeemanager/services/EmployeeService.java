package com.melashvili.employeemanager.services;

import com.melashvili.employeemanager.model.lib.Employee;
import com.melashvili.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        Iterable<Employee> temp = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : temp) {
            employees.add(employee);
//            System.out.println(employee.toString());
        }
        return employees;
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
//        System.out.println(employee.toString());
    }

    public void updateEmployeeById(Long id, Employee updatedEmployee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if(employeeOptional.isPresent()) {
            Employee employeeToUpdate = employeeOptional.get();

            employeeToUpdate.setEmployeeFirstName(updatedEmployee.getEmployeeFirstName());
            employeeToUpdate.setEmployeeLastName(updatedEmployee.getEmployeeLastName());
            employeeToUpdate.setAdmin(updatedEmployee.getAdmin());
            employeeToUpdate.setSector(updatedEmployee.getSector());
            employeeToUpdate.setTier(updatedEmployee.getTier());

            employeeRepository.save(employeeToUpdate);
        } else {
            System.out.println("Employee not found");
        }
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
