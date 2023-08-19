package com.kata.academy.avia_sales.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Сущность Аэропорты
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "airports")
public class Airports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;


    /**
     * название аэропорта
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * код аэропорта
     */
    @Column(name = "сode", nullable = false)
    private String сode;

    public Airports(String name, String сode) {
        this.name = name;
        this.сode = сode;
    }

    @Override
    public int hashCode() {
        return 31 + (name == null ? 0 : name.hashCode()) + (сode == null ? 0 : сode.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Airports airports = (Airports) obj;
        return (this.name == airports.name || (this.name != null && this.name.equals(airports.name)))
                && (this.сode == airports.сode || (this.сode != null && this.сode.equals(airports.сode)));
    }

    @Override
    public String toString() {
        return String.format(" Aircrafts = [name = %s, airportСode = %s]", name, сode);
    }


}

