package com.arrowsmith.sakiladb.repositories;

import com.arrowsmith.sakiladb.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>
{

    //@Query
   // public List<Store> findByGenre(String genre);
}
