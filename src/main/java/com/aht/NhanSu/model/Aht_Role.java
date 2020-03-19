package com.aht.NhanSu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import net.bytebuddy.build.ToStringPlugin;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "aht_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aht_Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;

    @Column(name = "role_name")
    private String roleName;

//    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Aht_User_Role> listUserRole ;
//
//    public Aht_Role(long roleId) {
//        this.roleId = roleId;
//    }

    public Aht_Role(String roleName) {
        this.roleName = roleName;
    }
}
