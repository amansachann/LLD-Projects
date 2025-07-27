package com.codewithaman;

import java.time.LocalDate;

public class Experience {
    private String company;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    public Experience(String company, String title, LocalDate startDate, LocalDate endDate, String description) {
        this.company = company;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }
}

