package scripts.model;



import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingApparatus extends AbstractEntity{
    
      
    private String name;

    private String discription;

  
}
