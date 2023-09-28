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
    @Query("DELETE FROM Rental r WHERE r.inventory.inventoryId IN (SELECT inventoryId from Inventory i where i.film.filmId = :id)")
    void deleteByInventoriesWithFilmId(Integer id);
}
