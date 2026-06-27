package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.TheaterRequest;
import com.cfs.BookMyShow.entity.Theater;
import com.cfs.BookMyShow.repository.TheaterRepository;
import com.cfs.BookMyShow.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/theaters")


public class TheaterController {

    @Autowired
    private final TheaterService theaterService;

    @PostMapping
    public ResponseEntity<Theater> addTheater(@RequestBody TheaterRequest theaterRequest){
        return ResponseEntity.ok(theaterService.addTheater(theaterRequest));
    }

    @GetMapping
    public ResponseEntity<List<Theater>> getAllTheater(){
        return ResponseEntity.ok(theaterService.getAllTheaters());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id){
        return ResponseEntity.ok(theaterService.getTheaterById(id));
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<Theater>>getTheaterByCity(@PathVariable Long cityId){
        return ResponseEntity.ok(theaterService.getTheaterByCity(cityId));
    }

}
