package com.library.bookingservice;

public class BookingServiceImpl implements BookingService{
    private final BookingDAO bookingDAO = new BookingDAO();

    @Override
    public void checkout(int sid, int bid) {
        bookingDAO.checkout(sid, bid);
    }
}
