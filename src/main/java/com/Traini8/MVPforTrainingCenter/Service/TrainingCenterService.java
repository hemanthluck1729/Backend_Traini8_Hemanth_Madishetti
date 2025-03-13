package com.Traini8.MVPforTrainingCenter.Service;


import com.Traini8.MVPforTrainingCenter.Entity.TrainingCenter;
import com.Traini8.MVPforTrainingCenter.Repository.TrainingCenterRepository;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TrainingCenterService {

    private static final Logger log = LoggerFactory.getLogger(TrainingCenterService.class);
    private final TrainingCenterRepository centerRepository;


    public TrainingCenterService(TrainingCenterRepository centerRepository) {
        this.centerRepository = centerRepository;


    }

    public TrainingCenter addCenter(TrainingCenter trainingCenter) {
        log.info("Training center details :{}",trainingCenter.toString());
        return centerRepository.save(trainingCenter);


    }

    public List<TrainingCenter> findCenters() {
        return centerRepository.findAll();
    }



    
}
