package com.kata.academy.avia_sales.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Сущность Авиалинии
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "airline")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    /**
     * название авиалиний
     */
    @Column(name = "name", nullable = false)
    private String name;

    public Airline(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 31 + (name == null ? 0 : name.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Airline airline = (Airline) obj;
        return this.name == airline.name || (this.name != null && this.name.equals(airline.name));
    }

    @Override
    public String toString() {
        return String.format(" Airline = [name = %s]", name);
    }

}
