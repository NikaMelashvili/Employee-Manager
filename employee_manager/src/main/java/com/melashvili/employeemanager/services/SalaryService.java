package com.melashvili.employeemanager.services;

import com.melashvili.employeemanager.model.lib.Salary;
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

    public List<Salary> getAllSalaries() {
        Iterable<Salary> temp = salaryRepository.findAll();
        List<Salary> salaries = new ArrayList<>();
        for (Salary salary : temp) {
            salaries.add(salary);
            System.out.println(salary.toString());
        }
        return salaries;
    }

    public Salary getSalaryById(Long id) {
        return salaryRepository.findById(id).get();
    }

    public void saveSalary(Salary salary) {
        salaryRepository.save(salary);
    }

    public void updateSalaryById(Long id, Salary updatedSalary) {
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
