package scripts.server.model;

import org.hibernate.annotations.ForeignKey;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class Client {
    

    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private   Integer id;

    @Column(name = "user_model_id")
    private Integer userModelId;
    
    @OneToOne
    @JoinColumn(name = "user_model_id", 
       referencedColumnName = "user_id", 
       insertable = false, updatable = false, 
       foreignKey = @jakarta.persistence
         .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private UserModel userModel;



}
