package scripts.server.model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
     uniqueConstraints = 
     @UniqueConstraint(columnNames = {"gym_number","gym_address"})
)
public class Gym extends AbstractEntity{
    

    

    @Column(name ="gym_number")
    private String gymNumber;
    
    @Column(name = "gym_address")
    private String address;
   

    // @ManyToMany
    // private ArrayList<ContainsGymApparatus> trainingApparatus;
    //@ManyToMany
    //private HashMap<TrainingApparatus,Integer> trainingApparatus;
} 