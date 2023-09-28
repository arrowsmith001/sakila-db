package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Language;
import com.arrowsmith.sakiladb.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://main.d34jypsxbhc933.amplifyapp.com"})
@RequestMapping(path = "/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("")
    public List<Language> getAllLanguages() { return languageService.getAllLanguages(); }

    @PostMapping(path = "")
    public Language saveLanguage(@RequestBody Language language) {
        return languageService.saveLanguage(language);
    }

    @GetMapping("/{id}")
    public Language getLanguageById(@PathVariable Integer id) {
        return languageService.getLanguageById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLanguage(@PathVariable Integer id) {
        languageService.deleteLanguage(id);
    }
}