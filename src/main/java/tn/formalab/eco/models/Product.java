package tn.formalab.eco.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name",unique = true,nullable = false)
    private String name;

    @Column(name = "description",nullable = true)
    private String description;

    @Column(name = "imageURL",nullable = true)
    private String imageURL;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "idCategory")
//    @JsonIgnoreProperties("products")
    public Category category;
}
