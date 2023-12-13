package scripts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import scripts.model.UserModel;
import scripts.model.UserRole;
import scripts.repository.RoleRepository;
import scripts.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class UserService  implements UserDetailsService{

    
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    // @Autowired
    // public UserService(UserRepository userRepository, RoleRepository roleRepository) {
    //     //super(userRepository);
    //     this.userRepository = userRepository;
    //     this.roleRepository = roleRepository;
    // }


    public Optional<UserModel> findByName(String name){
        var user = userRepository.findByName(name);
        if(user.isEmpty() || user.size()==0){
            return Optional.ofNullable(null);
        }
        return Optional.of(user.get(0));
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = findByName(username).orElseThrow(()-> 
            new UsernameNotFoundException( String.format("User %s not found", username)
            ));
        return new User(
            user.getName()
            ,user.getPassword()
            ,user.getUserRole().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }


    public UserModel createNewUser(UserModel userModel){
        List<UserRole> roles  = new ArrayList<UserRole>();
        roleRepository.findAll().forEach(roles::add);
        //userModel.setUserRole(userModel.getUserRole().stream().distinct().filter(x->roles.contains(x)).collect(Collectors.toList()));
        return userRepository.save(userModel); 
    }

    public ResponseEntity<?> getIdByName(String name) {
        var user = userRepository.findByName(name).get(0);
        return ResponseEntity.ok(user.getId());
    }

}
