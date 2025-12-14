package com.library.models;

import java.time.LocalDateTime;

public class BookingDetails {
    private int id;
    private int studentId;
    private int bookId;
    private LocalDateTime checkout_date;
    private LocalDateTime return_date;
}
