package com.aht.NhanSu.controller;

import com.aht.NhanSu.model.Aht_Parts;
import com.aht.NhanSu.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("rest/parts")
public class PartsController {
    @Autowired
    private PartsService partsService;

    @GetMapping("")
    public ResponseEntity<List<Aht_Parts>> findAll(){
        return ResponseEntity.ok().body(partsService.findAllParts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aht_Parts>> findById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(partsService.findPartsById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Aht_Parts> create(@RequestBody Aht_Parts ahtParts){
        return ResponseEntity.ok().body(partsService.createParts(ahtParts));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Aht_Parts> update(@RequestBody Aht_Parts ahtParts, @PathVariable("id") int id){
        ahtParts.setPartsId(id);
        return ResponseEntity.ok().body(partsService.updateParts(ahtParts));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable("id") int id){
        partsService.deleteParts(id);
        return HttpStatus.OK;
    }
}
