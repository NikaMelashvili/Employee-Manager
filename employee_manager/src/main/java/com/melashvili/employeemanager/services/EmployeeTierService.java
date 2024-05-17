package com.melashvili.employeemanager.services;

import com.melashvili.employeemanager.model.dto.EmployeeTierDTO;
import com.melashvili.employeemanager.model.lib.EmployeeTier;
import com.melashvili.employeemanager.model.mapper.EmployeeTierMapper;
import com.melashvili.employeemanager.repository.EmployeeTierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTierService {

    private final EmployeeTierRepository employeeRepository;

    @Autowired
    public EmployeeTierService(EmployeeTierRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeTierDTO> getAllEmployeeTiers() {
        Iterable<EmployeeTier> temp = employeeRepository.findAll();
        List<EmployeeTier> tiers = new ArrayList<>();
        for (EmployeeTier tier : temp) {
            tiers.add(tier);
            System.out.println(tier.toString());
        }
        List<EmployeeTierDTO> employeeTierDTOS = new ArrayList<>();
        for (EmployeeTier tier : tiers) {
            employeeTierDTOS.add(EmployeeTierMapper.employeeTierToDto(tier));
        }
        return employeeTierDTOS;
    }

    public EmployeeTierDTO getEmployeeTierById(Long id) {
        return EmployeeTierMapper.employeeTierToDto(employeeRepository.findById(id).orElse(null));
    }

    public void addEmployeeTier(EmployeeTierDTO employeeTier) {
        employeeRepository.save(EmployeeTierMapper.dtoToEmployeeTier(employeeTier));
    }

    public void updateEmployeeTierById(Long id, EmployeeTierDTO updatedEmployeeTier) {
        Optional<EmployeeTier> tierOptional = employeeRepository.findById(id);

        if (tierOptional.isPresent()) {
            EmployeeTier tier = tierOptional.get();

            tier.setTierName(updatedEmployeeTier.getTierName());
            tier.setTierDescription(updatedEmployeeTier.getTierDescription());

            employeeRepository.save(tier);
        } else {
            System.out.println("Employee tier not found");
        }
    }

    public void deleteEmployeeTierById(Long id) {
        employeeRepository.deleteById(id);
    }
}
