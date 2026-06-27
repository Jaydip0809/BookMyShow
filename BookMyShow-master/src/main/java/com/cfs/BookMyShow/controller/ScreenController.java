package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.ScreenRequest;
import com.cfs.BookMyShow.dto.SeatRequest;
import com.cfs.BookMyShow.entity.Screen;
import com.cfs.BookMyShow.entity.Seat;
import com.cfs.BookMyShow.entity.Show;
import com.cfs.BookMyShow.repository.ScreenRepository;
import com.cfs.BookMyShow.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.ScreenSleepEvent;
import java.util.List;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor

public class ScreenController {

    private final ScreenService screenService;

    @PostMapping
    public ResponseEntity<Screen> addScreen(@RequestBody ScreenRequest screenRequest) {
        return ResponseEntity.ok(screenService.addScreen(screenRequest));
    }

    @GetMapping
    public ResponseEntity<List<Screen>> getAllScreen(){
        return ResponseEntity.ok(screenService.getAllScreen());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Long id) {
        return ResponseEntity.ok(screenService.getScreenById(id));
    }

    @GetMapping("/theater/{theaterId}")
    public ResponseEntity<List<Screen>> getScreenByTheater(@PathVariable Long theaterId){
        return ResponseEntity.ok(screenService.getScreenByTheater(theaterId));
    }

}
