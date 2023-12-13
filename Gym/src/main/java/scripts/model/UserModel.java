package scripts.model;



import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scripts.model.enums.StatusActivate;



@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access =  AccessLevel.PUBLIC)
public class UserModel extends AbstractEntity{


    private String name;

    private String email;

    private String password;

    private StatusActivate statusActivate;
    
    @ManyToMany
    private Collection<UserRole> userRole;
}
