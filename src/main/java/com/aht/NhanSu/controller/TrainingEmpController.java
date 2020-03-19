package com.aht.NhanSu.controller;

import com.aht.NhanSu.model.Aht_Training_Emp;
import com.aht.NhanSu.service.TrainingEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest/quanlykhoahoc")
public class TrainingEmpController {

    @Autowired
    private TrainingEmpService trainingEmpService;

    @GetMapping("")
    public ResponseEntity<List<Aht_Training_Emp>> findAll(){
        return ResponseEntity.ok().body(trainingEmpService.findAllTrainingEmp());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aht_Training_Emp>> findById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(trainingEmpService.findTrainingEmpById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Aht_Training_Emp> create(@RequestBody Aht_Training_Emp ahtTrainingEmp){
        return ResponseEntity.ok().body(trainingEmpService.createTrainingEmp(ahtTrainingEmp));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Aht_Training_Emp> update(@RequestBody Aht_Training_Emp ahtTrainingEmp, @PathVariable("id") int id){
        ahtTrainingEmp.setTrainingEmpId(id);
        return ResponseEntity.ok().body(trainingEmpService.updateTrainingEmp(ahtTrainingEmp));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable("id") int id){
        trainingEmpService.deleteTrainingEmp(id);
        return HttpStatus.OK;
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<List<Aht_Training_Emp>> findEmpByTrainingId(@PathVariable("id") int id){
        return ResponseEntity.ok().body(trainingEmpService.findEmpByTrainingId(id));
    }

    @GetMapping("/same-name/{trainingId}/{empId}")
    public ResponseEntity<Aht_Training_Emp> sameName(@PathVariable("trainingId") int trainingId, @PathVariable("empId") int empId){
        return ResponseEntity.ok().body(trainingEmpService.sameName(trainingId,empId));
    }
}
