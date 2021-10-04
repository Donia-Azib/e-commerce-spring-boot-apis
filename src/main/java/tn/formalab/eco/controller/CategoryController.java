package tn.formalab.eco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.formalab.eco.models.Category;
import tn.formalab.eco.repositories.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
//    CRUD : CREATE READ UPDATE DELETE


//    GET POST DELETE PUT PATCH ("url")
//    public TypeRetour esmMeth(Para)
//    {
//        return typeRetour
//    }

    public CategoryRepository repo;

    @Autowired
    public CategoryController(CategoryRepository repo) {
        this.repo = repo;
    }

//    api : get all categories
//        n'accediw lel base -> categorie
//        JPA : methode prédéfinie findAll() "select * from ?"
//        interface CategoryRepo ==== JPARepo + Category
//        interface ProductRepo ==== JPARepo + Product
    @GetMapping(path = "")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
    }


}
