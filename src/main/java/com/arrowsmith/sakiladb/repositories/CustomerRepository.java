package com.arrowsmith.sakiladb.repositories;

import com.arrowsmith.sakiladb.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Customer findByEmail(String email);

    //@Query
   // public List<Customer> findByGenre(String genre);
}
