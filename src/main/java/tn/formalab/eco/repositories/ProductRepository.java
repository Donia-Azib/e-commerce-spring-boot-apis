package tn.formalab.eco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.eco.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
