package com.arrowsmith.sakiladb.repositories;

import com.arrowsmith.sakiladb.entities.FilmCategory;
import com.arrowsmith.sakiladb.entities.FilmCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, FilmCategoryId>
{

}

