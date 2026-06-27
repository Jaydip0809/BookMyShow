package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.SeatRequest;
import com.cfs.BookMyShow.dto.TheaterRequest;
import com.cfs.BookMyShow.entity.Seat;
import com.cfs.BookMyShow.entity.Theater;
import com.cfs.BookMyShow.service.ScreenService;
import com.cfs.BookMyShow.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor

public class SeatController {

    private final SeatService seatService;

    @PostMapping
    public ResponseEntity<Seat> addSeat(@RequestBody SeatRequest seatRequest) {
        return ResponseEntity.ok(seatService.addSeat(seatRequest));
    }

    @GetMapping("/screen/{screenId}")
    public ResponseEntity<List<Seat>> getSeatByScreen(@PathVariable Long screenId){
        return ResponseEntity.ok(seatService.getSeatByScreen(screenId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long id){
        return ResponseEntity.ok(seatService.getSeatById(id));
    }



}

