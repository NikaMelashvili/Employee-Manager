package com.melashvili.employeemanager.controllers;

import com.melashvili.employeemanager.model.*;
import com.melashvili.employeemanager.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Admin>> getAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/get/admin/{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/post/admin")
    public ResponseEntity<Void> saveAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/put/admin/{id}")
    public ResponseEntity<Void> updateAdmin(@PathVariable Long id,
                            @RequestBody Admin admin) {
        adminService.updateAdminById(id, admin);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/admin/{id}")
    public ResponseEntity<Void> deleteAdminById(@PathVariable Long id) {
        adminService.deleteAdminById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // employees section

    @GetMapping("/get/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/get/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/post/employees")
    public ResponseEntity<Void> saveEmployee(@RequestBody Employee employee) {

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
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/put/employees/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable Long id,
                               @RequestBody Employee employee) {
        employeeService.updateEmployeeById(id, employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // employees tier section

    @GetMapping("/get/tiers")
    public ResponseEntity<List<EmployeeTier>> getAllEmployeeTiers() {
        List<EmployeeTier> tiers = employeeTierService.getAllEmployeeTiers();
        return new ResponseEntity<>(tiers, HttpStatus.OK);
    }

    @GetMapping("/get/tiers/{id}")
    public ResponseEntity<EmployeeTier> getEmployeeTierById(@PathVariable Long id) {
        EmployeeTier tier = employeeTierService.getEmployeeTierById(id);
        return new ResponseEntity<>(tier, HttpStatus.OK);
    }

    @PostMapping("/post/tiers")
    public ResponseEntity<Void> addEmployeeTier(@RequestBody EmployeeTier employeeTier) {
        employeeTierService.addEmployeeTier(employeeTier);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/put/tiers/{id}")
    public ResponseEntity<Void> updateTier(@PathVariable Long id,
                           @RequestBody EmployeeTier employeeTier) {
        employeeTierService.updateEmployeeTierById(id, employeeTier);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/tiers/{id}")
    public ResponseEntity<Void> deleteEmployeeTier(@PathVariable Long id) {
        employeeTierService.deleteEmployeeTierById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // salary section

    @GetMapping("/get/salary")
    public ResponseEntity<List<Salary>> getAllSalaries(){
        List<Salary> salaries = salaryService.getAllSalaries();
        return new ResponseEntity<>(salaries, HttpStatus.OK);
    }

    @GetMapping("/get/salary/{id}")
    public ResponseEntity<Salary> getSalaryById(@PathVariable Long id){
        Salary salary = salaryService.getSalaryById(id);
        return new ResponseEntity<>(salary, HttpStatus.OK);
    }

    @PostMapping("/post/salary")
    public ResponseEntity<Void> addSalary(@RequestBody Salary salary){
        salaryService.saveSalary(salary);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/put/salary/{id}")
    public ResponseEntity<Void> updateSalary(@PathVariable Long id,
                             @RequestBody Salary salary){
        salaryService.updateSalaryById(id, salary);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/salary/{id}")
    public ResponseEntity<Void> deleteSalary(@PathVariable Long id){
        salaryService.deleteSalaryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // sectors section

    @GetMapping("/get/sector")
    public ResponseEntity<List<Sector>> getAllSectors(){
        List<Sector> sectors = sectorService.getAllSectors();
        return new ResponseEntity<>(sectors, HttpStatus.OK);
    }

    @GetMapping("/get/sector/{id}")
    public ResponseEntity<Sector> getSectorById(@PathVariable Long id){
        Sector sector = sectorService.getSectorById(id);
        return new ResponseEntity<>(sector, HttpStatus.OK);
    }

    @PostMapping("/post/sector")
    public ResponseEntity<Void> saveSector(@RequestBody Sector sector) {
        sectorService.addSector(sector);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/put/sector/{id}")
    public ResponseEntity<Void> updateSector(@PathVariable Long id,
                             @RequestBody Sector sector) {
        sectorService.updateSector(id, sector);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/sector/{id}")
    public ResponseEntity<Void> deleteSector(@PathVariable Long id) {
        sectorService.deleteSectorById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // task section

    @GetMapping("/get/task")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/get/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Task task = taskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
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
    public ResponseEntity<Void> updateTask (@PathVariable Long id,
                            @RequestBody Task task) {
        taskService.updateTaskById(id, task);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
