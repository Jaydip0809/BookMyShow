package com.cfs.BookMyShow.service;


import com.cfs.BookMyShow.dto.ScreenRequest;
import com.cfs.BookMyShow.entity.Screen;
import com.cfs.BookMyShow.entity.Theater;
import com.cfs.BookMyShow.repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenService {

    private final ScreenRepository screenRepository;
    private final TheaterService theaterService;

    public Screen addScreen(ScreenRequest screenRequest){
        Theater theater = theaterService.getTheaterById(screenRequest.getTheaterId());
        Screen screen = Screen.builder()
                .theater(theater)
                .totalSeats(screenRequest.getTotalSeats())
                .name(screenRequest.getName())
                .build();
        return screenRepository.save(screen);
    }

    public List<Screen> getAllScreen(){
        return screenRepository.findAll();
    }

    public Screen getScreenById(Long id){
        return screenRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Screen not found with id : "+id));
    }

    public List<Screen> getScreenByTheater(Long theaterId){
        return screenRepository.findByTheaterId(theaterId);
    }
    
}
