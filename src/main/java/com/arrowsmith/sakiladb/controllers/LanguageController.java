package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Language;
import com.arrowsmith.sakiladb.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping("")
    public Language saveLanguage(@RequestBody Language language) { return languageService.saveLanguage(language); }

    @GetMapping("")
    public List<Language> getAllLanguages() { return languageService.getAllLanguages(); }

    @GetMapping("/{id}")
    public Language getLanguageById(@PathVariable Byte id) {
        return languageService.getLanguageById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLanguage(@PathVariable Byte id) {
        languageService.deleteLanguage(id);
    }
}