package com.Traini8.MVPforTrainingCenter.Controller;

import com.Traini8.MVPforTrainingCenter.DTOs.TrainingCenterResponseDTO;
import com.Traini8.MVPforTrainingCenter.Entity.TrainingCenter;
import com.Traini8.MVPforTrainingCenter.Service.TrainingCenterService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class TrainingCenterController {

    private  final TrainingCenterService service;
    private final ModelMapper mapper;


    public TrainingCenterController(TrainingCenterService service,ModelMapper mapper)  {
        this.service = service;
        this.mapper=mapper;
    }

    //Adding a center 
    @PostMapping("add/training-center")
    public ResponseEntity<TrainingCenterResponseDTO> addTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter){
        TrainingCenter savedCenter= service.addCenter(trainingCenter);//returns center saved in Database
        TrainingCenterResponseDTO response=mapper.map(savedCenter, TrainingCenterResponseDTO.class);//<\ Mapping to Response DTO 
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    // Get All Centers from Database
    @GetMapping("/training-centers")
    public ResponseEntity<List<TrainingCenter>> getAllCenter(){
        return new ResponseEntity<>(service.findCenters(),HttpStatus.OK);
    }



}
