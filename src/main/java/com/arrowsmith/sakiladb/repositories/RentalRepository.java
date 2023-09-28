package com.arrowsmith.sakiladb.repositories;

import com.arrowsmith.sakiladb.entities.Rental;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer>
{
    @Modifying
    @Transactional
    @Query("DELETE FROM Rental r WHERE r.inventory.inventory_id IN (SELECT inventory_id from Inventory i where i.film.film_id = :id)")
    void deleteByInventoriesWithFilmId(Integer id);
}
