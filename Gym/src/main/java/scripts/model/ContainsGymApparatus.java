package scripts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ContainsGymApparatus extends AbstractEntity {
    
    @Id 
    @GeneratedValue(strategy =  GenerationType.IDENTITY) 
    private Integer id;
    @ManyToOne
    @JsonIgnore
    private TrainingApparatus trainingApparatus;
    private Integer count;

}