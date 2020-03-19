package com.aht.NhanSu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/helo")
public class HelloWord {
    @GetMapping("")
    public ResponseEntity xinChao(){
        String a = "Helo mina san";
        return ResponseEntity.ok().body(a);
    }
}
