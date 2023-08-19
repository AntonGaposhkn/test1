package com.kata.academy.avia_sales.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


/**
 * Сущность Авиакомпания
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "avia_company")
public class AviaCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    /**
     * Название авиакомпании
     */
    @Column(name = "name", nullable = false)
    private String name;


    public AviaCompany(String name) {
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

        AviaCompany aviaCompany = (AviaCompany) obj;
        return this.name == aviaCompany.name || (this.name != null && this.name.equals(aviaCompany.name));
    }

    @Override
    public String toString() {
        return String.format(" AviaCompany = [name = %s]", name);
    }
}
