package com.kata.academy.avia_sales.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.kata.academy.avia_sales.enums.StatusOfFlight;

import javax.persistence.*;
import java.util.Set;


/**
 * Сущность полет
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    /**
     * Номер рейса
     */
    @Column(name = "number", nullable = false)
    private String number;

    /**
     * Встроенный класс - Отправление
     */
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "dateAndTime", column = @Column(name = "departure_date_and_time", nullable = false)),
            @AttributeOverride(name = "airports", column = @Column(name = "departure_airports", nullable = false)),
    })
    private Action departure;


    /**
     * Встроенный класс - Прибытие
     */
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "dateAndTime", column = @Column(name = "arrival_date_and_time", nullable = false)),
            @AttributeOverride(name = "airports", column = @Column(name = "arrival_airports", nullable = false)),
    })
    private Action arrival;

    /**
     * Связь ManyToMany с сущностью Авиакомпания
     */
    @ManyToMany
    @JoinTable(
            name = "flight_avia_company",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "avia_company_id"))
    private Set<AviaCompany> aviaCompany;


    /**
     * Статусы рейса: Запланирован, Отменен, Задержан, Ожидается, Приземлен
     */
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusOfFlight status;

}
