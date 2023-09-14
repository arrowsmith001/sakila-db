package com.arrowsmith.sakiladb.repositories;

import com.arrowsmith.sakiladb.entities.Film;
import com.arrowsmith.sakiladb.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Byte>
{

}
