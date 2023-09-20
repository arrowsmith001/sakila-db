package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Store;
import com.arrowsmith.sakiladb.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping(path="")
    public Store saveStore(@RequestBody Store store) { return storeService.saveStore(store); }

    @GetMapping("")
    public List<Store> getAllStores() { return storeService.getAllStores(); }

    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable Integer id) {
        return storeService.getStoreById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable Integer id) {
        storeService.deleteStore(id);
    }


}

