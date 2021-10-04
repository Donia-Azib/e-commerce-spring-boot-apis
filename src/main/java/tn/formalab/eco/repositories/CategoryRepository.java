package tn.formalab.eco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.eco.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
