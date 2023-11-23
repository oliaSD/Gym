package scripts.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scripts.model.Gym;
import java.util.Collection;

@Repository
public interface GymRepository extends CrudRepository<Gym,Integer> {
 
    public Collection<Gym> findByName(String name);
}
