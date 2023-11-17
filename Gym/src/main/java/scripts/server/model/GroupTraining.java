package scripts.server.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scripts.server.model.enums.GroupAgeType;
import scripts.server.model.enums.GroupSkillType;
import scripts.server.model.enums.GroupType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( uniqueConstraints 
        =  @UniqueConstraint(columnNames = {"group_number"}),
    name = "GroupTraining"
)
public class GroupTraining extends AbstractEntity{
    

   

    @Column(name = "group_number")
    private String groupNumber;


    private GroupType groupType;

    private GroupAgeType groupAgeType;

    private GroupSkillType gropSkillType;

    @ManyToMany(cascade = {CascadeType.ALL})
    // @JoinTable(
    //     name = "Client"
    //     ,joinColumns  = {}
    //     ,inverseJoinColumns  = {}
    // )
    private Set<Client> clients =  new HashSet<Client>();

}           
