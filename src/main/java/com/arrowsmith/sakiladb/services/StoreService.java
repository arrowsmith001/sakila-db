package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Store;
import com.arrowsmith.sakiladb.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Store saveStore(Store Store) {
        return storeRepository.save(Store);
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(Integer id) {
        return storeRepository.findById(id).orElse(null);
    }

    public void deleteStore(Integer id) {
        storeRepository.deleteById(id);
    }


}