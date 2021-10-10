package tn.formalab.eco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.eco.models.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    public Optional<Category> findByName(String name);
}
