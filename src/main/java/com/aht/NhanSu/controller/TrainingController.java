package com.aht.NhanSu.controller;

import com.aht.NhanSu.model.Aht_Training;
import com.aht.NhanSu.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("rest/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping("")
    public ResponseEntity<List<Aht_Training>> findAll(){
        return ResponseEntity.ok().body(trainingService.findAllTraining());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aht_Training>> findById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(trainingService.findTrainingById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Aht_Training> create(@RequestBody Aht_Training ahtTraining){
        return ResponseEntity.ok().body(trainingService.createTraining(ahtTraining));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Aht_Training> update(@RequestBody Aht_Training ahtTraining, @PathVariable("id") int id){
        ahtTraining.setTrainingId(id);
        return ResponseEntity.ok().body(trainingService.updateTraining(ahtTraining));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable("id") int id){
        trainingService.deleteTraining(id);
        return HttpStatus.OK;
    }

    @PostMapping("/update-status")
    public HttpStatus updateStatus(@RequestBody Date date){
        trainingService.updateStatus(date);
        return HttpStatus.OK;
    }

    @GetMapping("/training-xpires")
    public ResponseEntity<List<Aht_Training>> trainingExpires(){
        return ResponseEntity.ok().body(trainingService.trainingExpires());
    }
}
