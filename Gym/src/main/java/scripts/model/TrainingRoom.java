package scripts.model;



import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scripts.model.enums.TypeOfRoom;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainingRoom  extends AbstractEntity{
    
    private Double square;

    private Integer maxCountOfClient;

    private TypeOfRoom typeOfRoom;

    @ManyToOne
    @JsonIgnore
    private Gym gym;    

    @OneToMany
    private Collection<ContainsGymApparatus> apparatus;
    //private Collection<ContainsGymApparatus> apparatus;
}
