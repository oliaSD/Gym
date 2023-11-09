package scripts.server.database;


import org.springframework.data.repository.CrudRepository;
import scripts.server.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {


}