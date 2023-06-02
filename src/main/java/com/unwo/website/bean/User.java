package com.unwo.website.bean;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int id;
    private String username;
    private String password;
    private int sex;
    private String email;
    private Date join_date;
}