package com.exercise.Crud.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table (name="MANGA")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;  //long?

    private String title;

    private String author;

}
