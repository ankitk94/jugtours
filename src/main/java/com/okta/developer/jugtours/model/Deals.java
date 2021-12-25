package com.okta.developer.jugtours.model;

import java.sql.Time;
import java.time.LocalDate;
import javax.persistence.Id;

public class Deals {
    @Id
    public Long id;
    public LocalDate startTime;
    public LocalDate endTime;
    public Long totalItems;
    public float price;
    public Long remainingItems;
    public Boolean isDealOngoing;
}
