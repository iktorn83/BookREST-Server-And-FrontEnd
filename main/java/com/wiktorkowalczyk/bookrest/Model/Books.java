package com.wiktorkowalczyk.bookrest.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class Books {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;


    private String name;
    private String author;
    private int year;




}
