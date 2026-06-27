package com.cfs.BookMyShow.service;


import com.cfs.BookMyShow.dto.SeatRequest;
import com.cfs.BookMyShow.entity.Screen;
import com.cfs.BookMyShow.entity.Seat;
import com.cfs.BookMyShow.enums.SeatType;
import com.cfs.BookMyShow.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;
    private final ScreenService screenService;

    public Seat addSeat(SeatRequest request){
        Screen screen = screenService.getScreenById(request.getScreenId());
        Seat seat = Seat.builder()
                .screen(screen)
                .seatNumber(request.getSeatNumber())
                .row(request.getRow())
                .col(request.getCol())
                .seatType(SeatType.valueOf(request.getSeatType()))
                .build();
        return seatRepository.save(seat);
    }

    public List<Seat> getSeatByScreen(Long screenId){
        return seatRepository.findByScreenId(screenId);
    }

    public Seat getSeatById(Long id){
        return seatRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Seat not found with id : "+id));
    }






}
