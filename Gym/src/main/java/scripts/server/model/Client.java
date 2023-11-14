package scripts.server.model;


import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access =  AccessLevel.PUBLIC)
public class Client extends Man{
    

    // @Column(name = "user_model_id")
    // private Integer userModelId;

  

    private TypeOfBody typeOfBody;

    @ManyToMany
    private ArrayList<GroupTraining> groupsEmployees;
}
