package scripts.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    private String city;

    private String pathToImage;

    @Column
    private String name;


   
    @OneToMany
    private Collection<TrainingRoom> trainingRooms;
    // @ManyToMany
    // private ArrayList<ContainsGymApparatus> trainingApparatus;
    //@ManyToMany
    //private HashMap<TrainingApparatus,Integer> trainingApparatus;
} 