package com.arrowsmith.sakiladb.repositories;

import com.arrowsmith.sakiladb.entities.Inventory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>
{
    @Query("SELECT i FROM Inventory i WHERE i.film.filmId=:id")
    List<Inventory> findAllByFilmId(Integer id);

    @Query("SELECT i FROM Inventory i WHERE i.film.filmId=:filmId AND i.store.storeId=:storeId")
    List<Inventory> findAllByFilmIdAndStoreId(Integer filmId, Integer storeId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Inventory i WHERE i.film.filmId=:id")
    void deleteByFilmId(Integer id);
}
