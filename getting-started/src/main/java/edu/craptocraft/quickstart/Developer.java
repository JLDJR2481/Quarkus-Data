package edu.craptocraft.quickstart;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Developer extends PanacheEntity {

    @Column(unique = true)
    public String name;

    @Column
    public Integer age;

}
