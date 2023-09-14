package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Language;
import com.arrowsmith.sakiladb.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public Language saveLanguage(Language Language) {
        return languageRepository.save(Language);
    }

    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    public Language getLanguageById(Byte id) {
        return languageRepository.findById(id).orElse(null);
    }

    public void deleteLanguage(Byte id) {
        languageRepository.deleteById(id);
    }
}