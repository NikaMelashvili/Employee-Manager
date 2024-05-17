package com.melashvili.employeemanager.services;

import com.melashvili.employeemanager.model.dto.SalaryDTO;
import com.melashvili.employeemanager.model.lib.Salary;
import com.melashvili.employeemanager.model.mapper.SalaryMapper;
import com.melashvili.employeemanager.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {

    private final SalaryRepository salaryRepository;

    @Autowired
    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public List<SalaryDTO> getAllSalaries() {
        Iterable<Salary> temp = salaryRepository.findAll();
        List<Salary> salaries = new ArrayList<>();
        for (Salary salary : temp) {
            salaries.add(salary);
            System.out.println(salary.toString());
        }
        List<SalaryDTO> salariesDTOs = new ArrayList<>();
        for (Salary salary : salaries) {
            salariesDTOs.add(SalaryMapper.salaryToDto(salary));
        }
        return salariesDTOs;
    }

    public SalaryDTO getSalaryById(Long id) {
        return SalaryMapper.salaryToDto(salaryRepository.findById(id).get());
    }

    public void saveSalary(SalaryDTO salary) {
        salaryRepository.save(SalaryMapper.dtoToSalary(salary));
    }

    public void updateSalaryById(Long id, SalaryDTO updatedSalary) {
        Optional<Salary> salaryOptional = salaryRepository.findById(id);

        if (salaryOptional.isPresent()) {
            Salary salary = salaryOptional.get();

            salary.setEmployee(updatedSalary.getEmployee());
            salary.setGrossSalary(updatedSalary.getGrossSalary());
            salary.setNetSalary(updatedSalary.getNetSalary());

            salaryRepository.save(salary);
        } else {
            System.out.println("Salary not found");
        }
    }

    public void deleteSalaryById(Long id) {
        salaryRepository.deleteById(id);
    }
}
