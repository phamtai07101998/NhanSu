package com.aht.NhanSu.controller;

import com.aht.NhanSu.model.Aht_Department;
import com.aht.NhanSu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/department")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public ResponseEntity<List<Aht_Department>> findAll(){
        return ResponseEntity.ok().body(departmentService.findAllDepartment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aht_Department>> findById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(departmentService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Aht_Department> create(@RequestBody Aht_Department ahtDepartment){
        return ResponseEntity.ok().body(departmentService.createDepartment(ahtDepartment));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Aht_Department> update(@RequestBody Aht_Department ahtDepartment, @PathVariable("id") int id){
        ahtDepartment.setDepartmentId(id);
        return ResponseEntity.ok().body(departmentService.updateDepartment(ahtDepartment));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable("id") int id){
        departmentService.deleteDepartment(id);
        return HttpStatus.OK;
    }
}
