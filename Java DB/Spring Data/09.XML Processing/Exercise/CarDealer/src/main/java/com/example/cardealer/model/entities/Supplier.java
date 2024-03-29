package com.example.cardealer.model.entities;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity {

    private String name;

    @Column(name = "is_importer")
    private boolean isImporter;

    @OneToMany(mappedBy = "supplier",   fetch = FetchType.EAGER)
    private Set<Part> parts;

    public Supplier() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
