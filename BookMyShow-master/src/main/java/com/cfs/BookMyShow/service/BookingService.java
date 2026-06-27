package com.cfs.BookMyShow.service;


import com.cfs.BookMyShow.dto.BookingRequest;
import com.cfs.BookMyShow.dto.SeatRequest;
import com.cfs.BookMyShow.dto.ShowRequest;
import com.cfs.BookMyShow.dto.UserRequest;
import com.cfs.BookMyShow.entity.*;
import com.cfs.BookMyShow.enums.BookingStatus;
import com.cfs.BookMyShow.repository.BookingRepository;
import com.cfs.BookMyShow.repository.SeatRepository;
import com.cfs.BookMyShow.repository.ShowRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.sql.ClientInfoStatus;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;
    private final UserService userService;
    private final ShowService showService;


    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    @Transactional
    public Booking createBooking(BookingRequest bookingRequest){

        User user = userService.getUserById(bookingRequest.getUserId());
        Show show = showService.getShowById(bookingRequest.getShowId());


        
        List<Long> alreadyBookedSeat = bookingRepository.finalBookedSeatIdsByShowId(show.getId());
        for (Long seatId: bookingRequest.getSeatIds()){
            if(alreadyBookedSeat.contains(seatId)){
                throw new RuntimeException("seat with id "+seatId+" is already Booked");
            }
        }

        List<Seat> seats = seatRepository.findAllById(bookingRequest.getSeatIds());
        if (seats.size()!=bookingRequest.getSeatIds().size()){
            throw new RuntimeException("Some seats are invalid");
        }

        double totalPrice = seats.size()*show.getTicketPrice();

        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .seats(seats)
                .totalPrice(totalPrice)
                .status(BookingStatus.CONFIRMED)
                .build();
        return bookingRepository.save(booking);
    }

    public  Booking getBookingById(Long id){
        return bookingRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Booking not found with id : "+id));
    }

    public List<Booking> getBookingByUser(Long userId){
        return bookingRepository.findByUserId(userId);
    }

    public Booking cancelBooking(Long bookingId){
        Booking booking = getBookingById(bookingId);
        booking.setStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking);

    }

    public List<Seat> getAvailableSeats(Long showId){
        Show show = showService.getShowById(showId);
        List<Seat> allSeats = seatRepository.findByScreenId(show.getScreen().getId());
        List<Long> bookingSeatsIds = bookingRepository.finalBookedSeatIdsByShowId(showId);
        return allSeats
                .stream()
                .filter(seat -> !bookingSeatsIds.contains(seat.getId()))
                .toList();
    }

}
