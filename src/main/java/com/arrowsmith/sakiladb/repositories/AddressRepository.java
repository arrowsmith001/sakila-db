package com.arrowsmith.sakiladb.repositories;

import com.arrowsmith.sakiladb.entities.Address;
import com.arrowsmith.sakiladb.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>
{

}
