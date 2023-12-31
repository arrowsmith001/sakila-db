package com.arrowsmith.sakiladb.repositories;

import com.arrowsmith.sakiladb.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>
{

}
