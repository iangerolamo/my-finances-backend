package com.ig.myfinancesbackend.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {

    private Integer id;

    private String name;

    private String email;

    private String password;
}
