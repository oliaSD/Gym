package scripts.dto;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scripts.model.UserRole;
import scripts.model.enums.StatusActivate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationUserDto {
    private String name;

    private String email;
    
    private String password;

    private StatusActivate statusActivate;
    
    private Collection<UserRole> userRole;
}
