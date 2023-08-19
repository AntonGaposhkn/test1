package com.kata.academy.avia_sales.entity;

import lombok.Data;


import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * Встраиваемый класс
 */
@Embeddable
@Data
public class Action {

    /**
     * дата и время
     */
    private LocalDateTime dateAndTime;

    /**
     * Авиакомпания
     */
    private Airports airports;
}
