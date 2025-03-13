package com.Traini8.MVPforTrainingCenter.Repository;

import com.Traini8.MVPforTrainingCenter.Entity.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter,Long> {


}
