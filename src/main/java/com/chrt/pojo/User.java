package com.chrt.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    @Column(name = "date_join")
    private Date dateJoin;
}
