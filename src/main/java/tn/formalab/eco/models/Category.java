package tn.formalab.eco.models;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(name = "name",nullable = false,unique = true,length = 10)
    public String name;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
