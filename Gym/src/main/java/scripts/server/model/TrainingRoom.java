package scripts.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scripts.server.model.enums.TypeOfRoom;

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
    private Gym gym;

    
}
