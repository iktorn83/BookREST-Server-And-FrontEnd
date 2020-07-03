package com.wiktorkowalczyk.bookrest.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor
@Entity

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleid;
    @Enumerated(EnumType.STRING)
    private RoleType name;

    public Role(RoleType name) {
        this.name = name;
    }

}
