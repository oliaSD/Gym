package scripts.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scripts.model.enums.GroupAgeType;
import scripts.model.enums.GroupSkillType;
import scripts.model.enums.GroupType;

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
     @JsonIgnore
    private Set<Client> clients =  new HashSet<Client>();

}           
