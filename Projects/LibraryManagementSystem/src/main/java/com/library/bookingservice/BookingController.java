package com.library.bookingservice;

import com.library.common.ConsoleUtils;

public class BookingController {
    private final BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
    public void checkout(int sid) {
        bookingServiceImpl.checkout(
                sid,
                ConsoleUtils.readInt("Book ID: ")
        );
        System.out.println("Booking Successful");
    }
}
