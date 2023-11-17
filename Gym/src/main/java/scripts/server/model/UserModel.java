package scripts.server.model;



import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scripts.server.model.enums.StatusActivate;
import scripts.server.model.enums.UserRole;


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


    @Enumerated(EnumType.ORDINAL)
    private Set<UserRole> userRole;
}
