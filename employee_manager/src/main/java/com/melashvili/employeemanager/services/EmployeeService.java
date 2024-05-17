package com.melashvili.employeemanager.services;

import com.melashvili.employeemanager.model.dto.AdminDTO;
import com.melashvili.employeemanager.model.dto.EmployeeDTO;
import com.melashvili.employeemanager.model.dto.EmployeeTierDTO;
import com.melashvili.employeemanager.model.dto.SectorDTO;
import com.melashvili.employeemanager.model.lib.Admin;
import com.melashvili.employeemanager.model.lib.Employee;
import com.melashvili.employeemanager.model.lib.EmployeeTier;
import com.melashvili.employeemanager.model.lib.Sector;
import com.melashvili.employeemanager.model.mapper.EmployeeMapper;
import com.melashvili.employeemanager.repository.AdminRepository;
import com.melashvili.employeemanager.repository.EmployeeRepository;
import com.melashvili.employeemanager.repository.EmployeeTierRepository;
import com.melashvili.employeemanager.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final AdminRepository adminRepository;

    private final EmployeeTierRepository employeeTierRepository;

    private final SectorRepository sectorRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,
                           AdminRepository adminRepository,
                           EmployeeTierRepository employeeTierRepository,
                           SectorRepository sectorRepository) {
        this.employeeRepository = employeeRepository;
        this.adminRepository = adminRepository;
        this.employeeTierRepository = employeeTierRepository;
        this.sectorRepository = sectorRepository;
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

    public void addEmployee(EmployeeDTO employee) {
        Employee newEmployee = EmployeeMapper.dtoToEmployeeDTO(employee);

        Long adminId = newEmployee.getAdmin().getAdminId();
        Long sectorId = newEmployee.getSector().getSectorId();
        Long tierId = newEmployee.getTier().getTierId();

        Admin admin = adminId != null ? adminRepository.findById(adminId).orElse(null) : null;
        Sector sector = sectorId != null ? sectorRepository.findById(sectorId).orElse(null) : null;
        EmployeeTier tier = tierId != null ? employeeTierRepository.findById(tierId).orElse(null) : null;

        newEmployee.setAdmin(admin);
        newEmployee.setSector(sector);
        newEmployee.setTier(tier);

        employeeRepository.save(newEmployee);
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
