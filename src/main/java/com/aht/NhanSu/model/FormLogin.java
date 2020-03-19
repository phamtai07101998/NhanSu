package com.aht.NhanSu.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
public class FormLogin {
    @NotBlank
    String username;
    @NotBlank
    String password;
}
