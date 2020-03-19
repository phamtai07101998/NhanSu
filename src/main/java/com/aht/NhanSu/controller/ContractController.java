package com.aht.NhanSu.controller;

import com.aht.NhanSu.model.Aht_Contract;
import com.aht.NhanSu.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("rest/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @GetMapping("")
    public ResponseEntity<List<Aht_Contract>> findAll(){
        return ResponseEntity.ok().body(contractService.findAllContract());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aht_Contract>> findById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(contractService.findContractById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Aht_Contract> create(@RequestBody Aht_Contract ahtContract){
        return ResponseEntity.ok().body(contractService.createContract(ahtContract));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Aht_Contract> update(@RequestBody Aht_Contract ahtContract, @PathVariable("id") int id){
        ahtContract.setContractId(id);
        return ResponseEntity.ok().body(contractService.updateContract(ahtContract));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable("id") int id){
        contractService.deleteContract(id);
        return HttpStatus.OK;
    }
}
