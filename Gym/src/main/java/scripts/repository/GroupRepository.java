package scripts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scripts.model.GroupTraining;


@Repository
public interface GroupRepository  extends    CrudRepository<GroupTraining, Integer>
{
    
}
