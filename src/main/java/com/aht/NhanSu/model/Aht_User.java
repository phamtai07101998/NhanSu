package com.aht.NhanSu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "aht_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aht_User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_pass")
    private String userPass;

    @Column(name = "user_email")
    private String userMail;

//    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Aht_User_Role> listUserRole ;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "aht_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Aht_Role> roles = new HashSet<>();

    public Aht_User(String userName, String userPass, String userMail) {
        this.userName = userName;
        this.userPass = userPass;
        this.userMail = userMail;
    }
}
