package tn.formalab.eco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.formalab.eco.models.Category;
import tn.formalab.eco.repositories.CategoryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categories")
//http://localhost:8081/categories   /....(URLApi)
public class CategoryController {
    public CategoryRepository repo;

    @Autowired
    public CategoryController(CategoryRepository repo) {
        this.repo = repo;
    }
// AFFICHER TOUS LES CATS - AFFICHER UNE SEUL CAT (phone/5) - insertion - modification d'une cat ( 5 pc-phone)...

    @GetMapping(path = "")
    public ResponseEntity<List<Category>> APIGetAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
    }

    //api insertion
    @PostMapping(path = "/create")
    public ResponseEntity<Category> APIAddCategory(@RequestBody Category category) {
        Category createdCategory = repo.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    //    categ by id
    //http://localhost:8081/categories/88
    @GetMapping(path = "{id}")
    public ResponseEntity<Category> APIGetCategoryById(@PathVariable Integer id) {
       Optional<Category> category =  repo.findById(id);
       if(category.isPresent())
           return ResponseEntity.status(HttpStatus.OK).body(category.get());
       else
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    //http://localhost:8081/categories/name/esmElCat
    @GetMapping(path = "name/{name}")
    public ResponseEntity<Category> APIGetCategoryByName(@PathVariable String name){
        Optional<Category> category =  repo.findByName(name);
        if(category.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(category.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Category());
    }

//    modification PUT / PATCH
    @PutMapping(path = "")
    public ResponseEntity<Category> APIUpdateCategoryById(@RequestBody Category categoryToUpdate)
    {
        Optional<Category> category =  repo.findById(categoryToUpdate.id);
        if(category.isPresent())
        {
//            modification{id,name} {name}
            Category updated = repo.save(categoryToUpdate);
            return ResponseEntity.status(HttpStatus.OK).body(updated);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Category());
    }


//    suppression
//    http://localhost:8081/categories/15
//    choix : id ??? delete / nothing

//    json : "message" : "category deleted with success "
//    json : "message" : "failed ..!"
//    HashMap / Map  {("message" , "failed ..!")(key , value)(key , value)(key , value)(key , value)}
    @DeleteMapping(path = "{id}")
    public ResponseEntity<HashMap<String,String>> APIDeleteCategoryById(@PathVariable Integer id){
        Optional<Category> category =  repo.findById(id);
        HashMap<String,String> json = new HashMap<>();
        if(category.isPresent())
        {
//            suppression{id,name} {name}
            repo.delete(category.get());
            json.put("message" , "category deleted with success...! ");
            return ResponseEntity.status(HttpStatus.OK).body(json);
        }
        else
        {
            json.put("message" , "failed ? category not found..!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
        }
    }

    //    suppression
    //    http://localhost:8081/categories/15
    //    category body => delete
    @DeleteMapping(path = "")
    public ResponseEntity<HashMap<String,String>> APIDeleteCategoryByCategory(@RequestBody Category category){
        Optional<Category> categoryToDelete =  repo.findByName(category.name);
        HashMap<String,String> json = new HashMap<>();
        if(categoryToDelete.isPresent())
        {
//            suppression{id,name} {name}
            repo.delete(categoryToDelete.get());
            json.put("message" , "category deleted with success...! ");
            return ResponseEntity.status(HttpStatus.OK).body(json);
        }
        else
        {
            json.put("message" , "failed ? category not found..!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
        }
    }

}
