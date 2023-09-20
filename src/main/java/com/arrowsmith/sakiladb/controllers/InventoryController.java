package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Inventory;
import com.arrowsmith.sakiladb.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping(path="")
    public Inventory saveInventory(@RequestBody Inventory inventory) { return inventoryService.saveInventory(inventory); }


    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable Integer id) {
        return inventoryService.getInventoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable Integer id) {
        inventoryService.deleteInventory(id);
    }

    @GetMapping("")
    public List<Inventory> getInventoriesByFilmIdAndStoreId(@RequestParam Integer filmId, @RequestParam Integer storeId){
        return inventoryService.findAllByFilmIdAndStoreId(filmId, storeId);
    }

}