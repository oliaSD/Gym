package scripts.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scripts.model.UserRole;

@Repository
public interface RoleRepository  extends CrudRepository<UserRole, Integer>{

    public List<UserRole> findByName(String name);
    
}
