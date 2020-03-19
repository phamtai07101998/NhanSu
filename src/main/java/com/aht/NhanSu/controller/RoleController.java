package com.aht.NhanSu.controller;

import com.aht.NhanSu.model.Aht_Role;
import com.aht.NhanSu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/role")
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public ResponseEntity<List<Aht_Role>> findAllRole(){
        return ResponseEntity.ok().body(roleService.listRole());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aht_Role>> findRoleById(@PathVariable("id") long id){
        return ResponseEntity.ok().body(roleService.findRoleById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Aht_Role> createRole(@RequestBody Aht_Role role){
        return ResponseEntity.ok().body(roleService.createRole(role));
    }
}
