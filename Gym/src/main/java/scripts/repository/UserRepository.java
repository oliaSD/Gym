package scripts.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scripts.model.UserModel;


@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {

    public List<UserModel> findByName(String name);

  
}
