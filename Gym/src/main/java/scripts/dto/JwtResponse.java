package scripts.dto;


import java.util.Collection;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    
    private String jwtToken;

    private Collection<?> roles; 
}
