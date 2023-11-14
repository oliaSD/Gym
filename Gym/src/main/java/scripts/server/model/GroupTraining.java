package scripts.server.model;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table( uniqueConstraints 
        =  @UniqueConstraint(columnNames = {"group_number"})
)
public class GroupTraining extends AbstractEntity{
    

   

    @Column(name = "group_number")
    private String groupNumber;


    private GroupType groupType;

    private GroupAgeType groupAgeType;

    private GroupSkillType gropSkillType;

    @ManyToMany
    private ArrayList<Client> clients;

}
