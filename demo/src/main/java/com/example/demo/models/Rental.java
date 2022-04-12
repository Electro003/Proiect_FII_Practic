package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RentedBooks", schema = "RentedBooks")
public class Rental {
    @Id
    private Integer id;

    Integer itemid;
    Integer clientid;
    Date rented_date , returned_date;
}
