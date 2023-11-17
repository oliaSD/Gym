package scripts.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public record ContainsGymApparatus (
    @Id 
    @GeneratedValue(strategy =  GenerationType.IDENTITY) 
    Integer id, 
    @ManyToOne
    TrainingApparatus trainingApparatus, 
    Integer count,
    @ManyToOne
    TrainingRoom trainingRoom
    ){
}