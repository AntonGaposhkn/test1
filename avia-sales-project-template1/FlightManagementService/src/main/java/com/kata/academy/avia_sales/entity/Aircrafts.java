package com.kata.academy.avia_sales.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * Сущность Воздушные судна
 */

@Entity
@Data
@Table(name = "aircrafts")
@NoArgsConstructor
public class Aircrafts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    /**
     * номер самолета
     */
    @Column(name = "number", nullable = false)
    private String number;

    /**
     * название самолета
     */
    @Column(name = "name", nullable = false)
    private String name;

    public Aircrafts(String number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 31 + (name == null ? 0 : name.hashCode()) + (number == null ? 0 : number.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Aircrafts aircrafts = (Aircrafts) obj;
        return (this.name == aircrafts.name || (this.name != null && this.name.equals(aircrafts.name)))
                && (this.number == aircrafts.number || (this.number != null && this.number.equals(aircrafts.number)));
    }

    @Override
    public String toString() {
        return String.format(" Aircrafts = [name = %s, number = %s]", name, number);
    }


}
