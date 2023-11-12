package scripts.server.database;


import org.springframework.data.repository.CrudRepository;
import scripts.server.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer> {


}