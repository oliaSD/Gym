package scripts.server.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.engine.internal.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scripts.server.model.enums.TypeOfBody;
import lombok.AccessLevel;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access =  AccessLevel.PUBLIC)
@Table(name = "Client")
public class Client extends Man{


    // @Column(name = "user_model_id")
    // private Integer userModelId;

 



    private TypeOfBody typeOfBody;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy =  "clients")
    private Set<GroupTraining> groupTrainings = new HashSet<GroupTraining>();
}
