package scripts.server.model;

import java.sql.Time;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule extends AbstractEntity{

    
    private Date date;

    private Time time;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private GroupTraining group;

    @ManyToOne
    private TrainingRoom trainingRoom;
}
