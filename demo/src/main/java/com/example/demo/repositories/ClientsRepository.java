package com.example.demo.repositories;

import com.example.demo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientsRepository extends JpaRepository<Client,Integer> {
    List<Client> findClientById(Integer Id);
    List<Client> findClientsByName(String Name);
    List<Client> findClientsByIdAndName(Integer Id,String Name);

}
