package com.aht.NhanSu.controller;

import com.aht.NhanSu.model.*;
import com.aht.NhanSu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest/employee")
public class QuanLyNhanVienController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<Aht_Employee>> findAllEmployee(){
        return ResponseEntity.ok().body(employeeService.findAllEmployee());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aht_Employee>> findEmpById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(employeeService.findEmployeeById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Aht_Employee> createEmp(@RequestBody Aht_Employee ahtEmployee){
        return ResponseEntity.ok().body(employeeService.createEmployee(ahtEmployee));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Aht_Employee> updateEmp(@PathVariable("id") int id, @RequestBody Aht_Employee ahtEmployee){
        ahtEmployee.setEmpId(id);
        return ResponseEntity.ok().body(employeeService.updateEmployee(ahtEmployee));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteEmp(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }

    @GetMapping("/contract-type/{type}")
    public ResponseEntity<List<ContractEmpResult>> findEmpByTypeContract(@PathVariable("type") int type){
        return ResponseEntity.ok().body(employeeService.findEmpByTypeContract(type));
    }

    @GetMapping("/department/{partsId}/{departId}")
    public ResponseEntity<List<Aht_Employee>> findEmpByDepartment(@PathVariable("partsId") int partsId,@PathVariable("departId") int departId){
        return ResponseEntity.ok().body(employeeService.findEmpByDepartment(partsId,departId));
    }

    @GetMapping("/nv-het-hop-dong")
    public ResponseEntity<List<Aht_Contract_Emp>> empContractExpire(){
        return ResponseEntity.ok().body(employeeService.findEmpByStatustContract());
    }

    @GetMapping("/nv-con-hop-dong")
    public ResponseEntity<List<Aht_Contract_Emp>> empContract(){
        return ResponseEntity.ok().body(employeeService.empContract());
    }
}
