package com.aht.NhanSu.controller;

import com.aht.NhanSu.model.Aht_Contract_Emp;
import com.aht.NhanSu.service.ContractEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest/contractEmp")
public class DanhMucHopDongController {

    @Autowired
    private ContractEmpService contractEmpService;

    @GetMapping("")
    public ResponseEntity<List<Aht_Contract_Emp>> findAll(){
        return ResponseEntity.ok().body(contractEmpService.findAllCntractEmp());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aht_Contract_Emp>> findById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(contractEmpService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Aht_Contract_Emp> create(@RequestBody Aht_Contract_Emp ahtContractEmp){
        return ResponseEntity.ok().body(contractEmpService.createContractEmp(ahtContractEmp));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Aht_Contract_Emp> update(@RequestBody Aht_Contract_Emp ahtContractEmp, @PathVariable("id") int id){
        ahtContractEmp.setContractEmpId(id);
        return ResponseEntity.ok().body(contractEmpService.updateContractEmp(ahtContractEmp));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable("id") int id){
        contractEmpService.deleteEmp(id);
        return HttpStatus.OK;
    }


    @PostMapping("/update-date")
    public HttpStatus updateStatus(@RequestBody Date date){
        contractEmpService.updateStatus(date);
        return HttpStatus.OK;
    }

}
