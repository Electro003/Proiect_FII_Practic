package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="books",schema = "books")
//DIII CEE NU MERGE ??????????????
//RIP subclasa ComicBook - ucisa de Bazele de date care nu vor sa coopereze
public class Book {
    @Id
    private Integer id;

    Integer series;
    Integer number;
    String title;
    String author;
}
