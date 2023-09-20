package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Inventory;
import com.arrowsmith.sakiladb.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    
    public Inventory saveInventory(Inventory Inventory) {
        return inventoryRepository.save(Inventory);
    }

    public List<Inventory> getAllInventorys() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryById(Integer id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    public void deleteInventory(Integer id) {

        inventoryRepository.deleteById(id);
    }

    public List<Inventory> findAllByFilmIdAndStoreId(Integer filmId, Integer storeId)
    {
        return inventoryRepository.findAllByFilmIdAndStoreId(filmId, storeId);
    }

}