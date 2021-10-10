package tn.formalab.eco.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(name = "name",nullable = false,unique = true,length = 100)
    public String name;

    @OneToMany
//    @JsonIgnoreProperties("category")
    public List<Product> products;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
