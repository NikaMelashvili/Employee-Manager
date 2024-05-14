package com.melashvili.employeemanager.controllers;

import com.melashvili.employeemanager.model.*;
import com.melashvili.employeemanager.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final AdminService adminService;

    private final EmployeeService employeeService;

    private final EmployeeTierService employeeTierService;

    private final SalaryService salaryService;

    private final SectorService sectorService;

    private final TaskService taskService;

    @Autowired
    public MainController(AdminService adminService,
                          EmployeeService employeeService,
                          EmployeeTierService employeeTierService,
                          SalaryService salaryService,
                          SectorService sectorService,
                          TaskService taskService) {
        this.adminService = adminService;
        this.employeeService = employeeService;
        this.employeeTierService = employeeTierService;
        this.salaryService = salaryService;
        this.sectorService = sectorService;
        this.taskService = taskService;
    }

    // admins section

    @GetMapping("/get/admin")
    public List<Admin> getAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/get/admin/{id}")
    public Admin getAdmin(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/post/admin")
    public void saveAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
    }

    @PutMapping("/put/admin/{id}")
    public void updateAdmin(@PathVariable Long id,
                            @RequestBody Admin admin) {
        adminService.updateAdminById(id, admin);
    }

    @DeleteMapping("/delete/admin/{id}")
    public void deleteAdminById(@PathVariable Long id) {
        adminService.deleteAdminById(id);
    }

    // employees section

    @GetMapping("/get/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/post/employees")
    public void saveEmployee(@RequestBody Employee employee) {

        Long adminId = employee.getAdmin().getAdminId();
        Long sectorId = employee.getSector().getSectorId();
        Long tierId = employee.getTier().getTierId();

        Admin admin = adminId != null ? adminService.getAdminById(adminId) : null;
        Sector sector = sectorId != null ? sectorService.getSectorById(sectorId) : null;
        EmployeeTier tier = tierId != null ? employeeTierService.getEmployeeTierById(tierId) : null;

        employee.setAdmin(admin);
        employee.setSector(sector);
        employee.setTier(tier);

        employeeService.addEmployee(employee);
    }

    @PutMapping("/put/employees/{id}")
    public void updateEmployee(@PathVariable Long id,
                               @RequestBody Employee employee) {
        employeeService.updateEmployeeById(id, employee);
    }

    @DeleteMapping("/delete/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }

    // employees tier section

    @GetMapping("/get/tiers")
    public List<EmployeeTier> getAllEmployeeTiers() {
        return employeeTierService.getAllEmployeeTiers();
    }

    @GetMapping("/get/tiers/{id}")
    public EmployeeTier getEmployeeTierById(@PathVariable Long id) {
        return employeeTierService.getEmployeeTierById(id);
    }

    @PostMapping("/post/tiers")
    public void addEmployeeTier(@RequestBody EmployeeTier employeeTier) {
        employeeTierService.addEmployeeTier(employeeTier);
    }

    @PutMapping("/put/tiers/{id}")
    public void updateTier(@PathVariable Long id,
                           @RequestBody EmployeeTier employeeTier) {
        employeeTierService.updateEmployeeTierById(id, employeeTier);
    }

    @DeleteMapping("/delete/tiers/{id}")
    public void deleteEmployeeTier(@PathVariable Long id) {
        employeeTierService.deleteEmployeeTierById(id);
    }

    // salary section

    @GetMapping("/get/salary")
    public List<Salary> getAllSalaries(){
        return salaryService.getAllSalaries();
    }

    @GetMapping("/get/salary/{id}")
    public Salary getSalaryById(@PathVariable Long id){
        return salaryService.getSalaryById(id);
    }

    @PostMapping("/post/salary")
    public void addSalary(@RequestBody Salary salary){
        salaryService.saveSalary(salary);
    }

    @PutMapping("/put/salary/{id}")
    public void updateSalary(@PathVariable Long id,
                             @RequestBody Salary salary){
        salaryService.updateSalaryById(id, salary);
    }

    @DeleteMapping("/delete/salary/{id}")
    public void deleteSalary(@PathVariable Long id){
        salaryService.deleteSalaryById(id);
    }

    // sectors section

    @GetMapping("/get/sector")
    public List<Sector> getAllSectors(){
        return sectorService.getAllSectors();
    }

    @GetMapping("/get/sector/{id}")
    public Sector getSectorById(@PathVariable Long id){
        return sectorService.getSectorById(id);
    }

    @PostMapping("/post/sector")
    public void saveSector(@RequestBody Sector sector) {
        sectorService.addSector(sector);
    }

    @PutMapping("/put/sector/{id}")
    public void updateSector(@PathVariable Long id,
                             @RequestBody Sector sector) {
        sectorService.updateSector(id, sector);
    }

    @DeleteMapping("/delete/sector/{id}")
    public void deleteSector(@PathVariable Long id) {
        sectorService.deleteSectorById(id);
    }

    // task section

    @GetMapping("/get/task")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/get/task/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    // under construction ...
//    @PostMapping("/post/task")
//    public void saveTask(@RequestBody Task task) {
//
//        MultipartFile multipartFile = task.getTaskFile();
//
//        taskService.saveTask(task);
//    }

    @PutMapping("/put/task/{id}")
    public void updateTask (@PathVariable Long id,
                            @RequestBody Task task) {
        taskService.updateTaskById(id, task);
    }

    @DeleteMapping("/delete/task/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }
}
