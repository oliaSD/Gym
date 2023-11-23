package scripts.model;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scripts.model.enums.TypeOfBody;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access =  AccessLevel.PUBLIC)
@Table(name = "Client")
public class Client extends Man{


    private TypeOfBody typeOfBody;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy =  "clients")
    private Set<GroupTraining> groupTrainings = new HashSet<GroupTraining>();
}
